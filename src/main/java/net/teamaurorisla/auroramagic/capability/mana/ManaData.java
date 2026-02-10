package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;

public class ManaData {

    private double stable;
    private double surge;
    private double stableMax;
    private double surgeMax;
    private boolean isOverloaded;

    public ManaData() {
        this(10.0, 10.0, 10.0, 10.0, false);
    }

    public ManaData(double stable, double surge, double stableMax, double surgeMax, boolean isOverloaded) {
        this.stable = stable;
        this.surge = surge;
        this.stableMax = stableMax;
        this.surgeMax = surgeMax;
        this.isOverloaded = isOverloaded;
    }

    public double getStable() {
        return stable;
    }

    public double getSurge() {
        return surge;
    }

    public double getMaxStable() {
        return stableMax;
    }

    public double getMaxSurge() {
        return surgeMax;
    }

    public boolean isOverloaded() {
        return isOverloaded;
    }

    public ManaData setStable(double mana) {
        this.stable = fix(mana, true);
        return this;
    }

    public ManaData setSurge(double mana) {
        this.surge = fix(mana, false);
        return this;
    }

    public ManaData setMaxStable(double max) {
        this.stableMax = Math.max(max, 0.0);
        this.stable = fix(stable, true);
        return this;
    }

    public ManaData setMaxSurge(double max) {
        this.surgeMax = Math.max(max, 0.0);
        this.surge = fix(surge, false);
        return this;
    }

    public ManaData setOverloaded(boolean b) {
        this.isOverloaded = b;
        return this;
    }

    public ManaData setSelf(ManaData manaData) {
        this.stable = manaData.getStable();
        this.surge = manaData.getSurge();
        this.stableMax = manaData.getMaxStable();
        this.surgeMax = manaData.getMaxSurge();
        this.isOverloaded = manaData.isOverloaded();
        return this;
    }

    private double fix(double mana, boolean isStableMax) {
        if (mana <= 0.0) {
            return 0.0; //如果魔力小于等于0，直接取0
        } else {
            return Math.min(isStableMax ? stableMax : surgeMax, mana); //如果魔力大于上限值，取上限值
        }
    }

    public void writeToNetwork(FriendlyByteBuf buf) {
        buf.writeDouble(stable);
        buf.writeDouble(surge);
        buf.writeDouble(stableMax);
        buf.writeDouble(surgeMax);
        buf.writeBoolean(isOverloaded);
    }

    public static ManaData readFromNetwork(FriendlyByteBuf buf) {
        return new ManaData(buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readBoolean());
    }

    CompoundTag serialize(CompoundTag tag) {
        tag.putDouble("stable", stable);
        tag.putDouble("surge", surge);
        tag.putDouble("maxStable", stableMax);
        tag.putDouble("maxSurge", surgeMax);
        tag.putBoolean("isOverloaded", isOverloaded);
        return tag;
    }

    void deserialize(CompoundTag tag) {
        this.stable = tag.getDouble("stable");
        this.surge = tag.getDouble("surge");
        this.stableMax = tag.getDouble("maxStable");
        this.surgeMax = tag.getDouble("maxSurge");
        this.isOverloaded = tag.getBoolean("isOverloaded");
    }

}