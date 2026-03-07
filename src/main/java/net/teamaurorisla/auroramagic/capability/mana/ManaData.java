package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;

public class ManaData {

    private double stable;
    private double surge;
    private boolean isOverloaded;

    public ManaData() {
        this(10.0, 10.0, false);
    }

    public ManaData(double stable, double surge, boolean isOverloaded) {
        this.stable = Math.max(stable, 0.0);
        this.surge = Math.max(surge, 0.0);
        this.isOverloaded = isOverloaded;
    }

    public double getStable() {
        return stable;
    }

    public double getSurge() {
        return surge;
    }

    public boolean isOverloaded() {
        return isOverloaded;
    }

    public ManaData setStable(double mana) {
        this.stable = Math.max(mana, 0.0);
        return this;
    }

    public ManaData setSurge(double mana) {
        this.surge = Math.max(mana, 0.0);
        return this;
    }

    public ManaData setOverloaded(boolean b) {
        this.isOverloaded = b;
        return this;
    }

    public ManaData setSelf(ManaData manaData) {
        this.stable = manaData.getStable();
        this.surge = manaData.getSurge();
        this.isOverloaded = manaData.isOverloaded();
        return this;
    }

    public void writeToNetwork(FriendlyByteBuf buf) {
        buf.writeDouble(stable);
        buf.writeDouble(surge);
        buf.writeBoolean(isOverloaded);
    }

    public static ManaData readFromNetwork(FriendlyByteBuf buf) {
        return new ManaData(buf.readDouble(), buf.readDouble(), buf.readBoolean());
    }

    CompoundTag serialize(CompoundTag tag) {
        tag.putDouble("stable", stable);
        tag.putDouble("surge", surge);
        tag.putBoolean("isOverloaded", isOverloaded);
        return tag;
    }

    void deserialize(CompoundTag tag) {
        this.stable = Math.max(tag.getDouble("stable"), 0.0);
        this.surge = Math.max(tag.getDouble("surge"), 0.0);
        this.isOverloaded = tag.getBoolean("isOverloaded");
    }

}