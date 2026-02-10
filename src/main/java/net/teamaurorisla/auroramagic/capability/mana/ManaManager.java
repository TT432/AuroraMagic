package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.teamaurorisla.auroramagic.network.AMNetworkHandler;
import net.teamaurorisla.auroramagic.network.msg.ManaDataPacket;
import org.jetbrains.annotations.NotNull;

import static net.teamaurorisla.auroramagic.capability.mana.ManaType.*;

public class ManaManager {

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
            case MAX_STABLE -> manaData.getMaxStable();
            case MAX_SURGE -> manaData.getMaxSurge();
        };
    }

    public ManaManager set(ManaType type, double value) {
        switch (type) {
            case STABLE -> manaData.setStable(value);
            case SURGE -> manaData.setSurge(value);
            case MAX_STABLE -> manaData.setMaxStable(value);
            case MAX_SURGE -> manaData.setMaxSurge(value);
        } return sendToPlayerClient();
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
        return sendToPlayerClient();
    }

    public ManaManager sendToPlayerClient() {
        AMNetworkHandler.sendToPlayerClient(new ManaDataPacket(manaData), (ServerPlayer) player);
        return this;
    }

    public static ManaManager of(@NotNull Player player) {
        return new ManaManager(player);
    }

}