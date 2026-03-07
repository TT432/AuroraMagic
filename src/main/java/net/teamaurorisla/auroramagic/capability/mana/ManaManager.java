package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.teamaurorisla.auroramagic.network.AMNetworkHandler;
import net.teamaurorisla.auroramagic.network.msg.ManaDataPacket;
import net.teamaurorisla.auroramagic.registry.AMAttribute;
import org.jetbrains.annotations.NotNull;

import static net.teamaurorisla.auroramagic.capability.mana.ManaType.*;

public class ManaManager {

    private static final double DEFAULT_MAX_MANA = 10.0;

    private final Player player;
    private ManaData manaData;

    public ManaManager(@NotNull Player player) {
        this.player = player;
        player.getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(manaData -> this.manaData = manaData);
    }

    public double getCurrentMana() {
        return get(STABLE) + get(SURGE);
    }

    public double getMaxMana() {
        return get(MAX_STABLE) + get(MAX_SURGE);
    }

    public double get(ManaType type) {
        return switch (type) {
            case STABLE -> manaData.getStable();
            case SURGE -> manaData.getSurge();
            case MAX_STABLE -> getMaxAttributeValue(AMAttribute.MAX_STABLE_MANA.get());
            case MAX_SURGE -> getMaxAttributeValue(AMAttribute.MAX_SURGE_MANA.get());
        };
    }

    public ManaManager set(ManaType type, double value) {
        switch (type) {
            case STABLE -> manaData.setStable(Math.min(Math.max(value, 0.0), get(MAX_STABLE)));
            case SURGE -> manaData.setSurge(Math.min(Math.max(value, 0.0), get(MAX_SURGE)));
            case MAX_STABLE -> {
                setMaxAttributeValue(AMAttribute.MAX_STABLE_MANA.get(), value);
                manaData.setStable(Math.min(manaData.getStable(), get(MAX_STABLE)));
            }
            case MAX_SURGE -> {
                setMaxAttributeValue(AMAttribute.MAX_SURGE_MANA.get(), value);
                manaData.setSurge(Math.min(manaData.getSurge(), get(MAX_SURGE)));
            }
        }
        return sendToPlayerClient();
    }

    public ManaManager add(ManaType type, double value) {
        return set(type, (get(type) + value));
    }

    public ManaManager cut(ManaType type, double value) {
        return set(type, (get(type) - value));
    }

    public ManaManager consume(double value) {
        return consume(value, false);
    }

    public ManaManager consume(double value, boolean isStableFirst) {
        double stable = get(STABLE);
        double surge = get(SURGE);
        double first = isStableFirst ? stable : surge;
        if (first < value) {
            if (isStableFirst) return set(STABLE, 0.0).cut(SURGE, value - first);
            else return set(SURGE, 0.0).cut(STABLE, value - first);
        } else {
            if (isStableFirst) return cut(STABLE, value);
            else return cut(SURGE, value);
        }
    }

    public boolean isOverloaded() {
        return manaData.isOverloaded();
    }

    public ManaManager setOverloaded(boolean b, double cutValue) {
        manaData.setOverloaded(b);
        return cut(MAX_STABLE, cutValue);
    }

    public ManaData getManaData() {
        return manaData;
    }

    public ManaManager setManaData(ManaData newManaData) {
        manaData.setSelf(newManaData);
        manaData.setStable(Math.min(manaData.getStable(), get(MAX_STABLE)));
        manaData.setSurge(Math.min(manaData.getSurge(), get(MAX_SURGE)));
        return sendToPlayerClient();
    }

    public ManaManager sendToPlayerClient() {
        if (player instanceof ServerPlayer serverPlayer) {
            AMNetworkHandler.sendToPlayerClient(new ManaDataPacket(manaData), serverPlayer);
        }
        return this;
    }

    private double getMaxAttributeValue(Attribute attribute) {
        AttributeInstance instance = player.getAttribute(attribute);
        return instance != null ? instance.getValue() : DEFAULT_MAX_MANA;
    }

    private void setMaxAttributeValue(Attribute attribute, double value) {
        AttributeInstance instance = player.getAttribute(attribute);
        if (instance != null) {
            instance.setBaseValue(Math.max(value, 0.0));
        }
    }

    public static ManaManager of(@NotNull Player player) {
        return new ManaManager(player);
    }

}