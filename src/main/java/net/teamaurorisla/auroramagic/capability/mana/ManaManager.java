package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.teamaurorisla.auroramagic.network.AMNetworkHandler;
import net.teamaurorisla.auroramagic.network.msg.ManaDataPacket;
import org.jetbrains.annotations.NotNull;

import static net.teamaurorisla.auroramagic.capability.mana.ManaType.*;

public class ManaManager {

    private final Player player;
    private final ManaData manaData;

    public ManaManager(@NotNull Player player) {
        this.player = player;
        this.manaData = player.getCapability(ManaProvider.MANA_CAPABILITY).orElse(null);
    }

    public ManaData getManaData() {
        return manaData;
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
        }
        AMNetworkHandler.sendToPlayerClient(new ManaDataPacket(manaData), (ServerPlayer) player);
        return this;
    }

    public ManaManager add(ManaType type, double value) {
        return set(type, (get(type) + value));
    }

    public ManaManager consume(ManaType type, double value, boolean whenNotEnough) {
        if (get(type) < value) {
            return whenNotEnough ? set(type, (get(type) - value)).setOverloaded(true) : this;
        } else {
            return set(type, (get(type) - value));
        }
    }

    public boolean isOverloaded() {
        return manaData.isOverloaded();
    }

    public ManaManager setOverloaded(boolean b) {
        manaData.setOverloaded(b);
        AMNetworkHandler.sendToPlayerClient(new ManaDataPacket(manaData), (ServerPlayer) player);
        return this;
    }

//    public ManaManager overload() {
//        if (isOverloaded()) return this;
//        else return setOverloaded(true).consume(STABLE, 4.0);
//    }
//
//    public ManaManager unOverload(int tick) {
//        if (isOverloaded()) return setOverloaded(false).add(MAX_STABLE, 4.0);
//        else return this;
//    }

    /**---------------- ↓↓↓ Builder ↓↓↓ ----------------**/
    public static ManaManager of(Player player) {
        return new ManaManager(player);
    }

}