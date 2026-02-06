package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.nbt.CompoundTag;

public class ManaData {

    private double stable;
    private double surge;
    private double stableMax;
    private double surgeMax;
    private boolean isOverloaded;

    public ManaData() {
        this.stable = 10.0;
        this.surge = 10.0;
        this.stableMax = 10.0;
        this.surgeMax = 10.0;
        this.isOverloaded = false;
    }

    /**---------------- ↓↓↓ Getter ↓↓↓ ----------------**/

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

    public double getCurrentMana() {
        return stable + surge;
    }

    public double getMaxMana() {
        return stableMax + surgeMax;
    }

    /**---------------- ↓↓↓ Setter ↓↓↓ ----------------**/

    public ManaData setStable(double mana) {
        this.stable = fix(mana, true);
        return this;
    }

    public ManaData setSurge(double mana) {
        this.surge = fix(mana, false);
        return this;
    }

    public ManaData setMaxStable(double max) {
        this.stableMax = max;
        this.stable = fix(stable, true);
        return this;
    }

    public ManaData setMaxSurge(double max) {
        this.surgeMax = max;
        this.surge = fix(surge, false);
        return this;
    }

    public ManaData setOverloaded(boolean b) {
        this.isOverloaded = b;
        return this;
    }

//    public ManaData overload() {
//        if (isOverloaded()) return this;
//        else {
//            this.isOverloaded = true;
//            return lowerMaxStable(4.0);
//        }
//    }
//
//    public ManaData unOverload(int tick) {
//        if (isOverloaded()) {
//            this.isOverloaded = false;
//            return upperMaxStable(4.0);
//        } else return this;
//    }

    /**---------------- ↓↓↓ Adder ↓↓↓ ----------------**/

    public ManaData addStable(double mana) {
        return setStable(stable + mana);
    }

    public ManaData addSurge(double mana) {
        return setSurge(surge + mana);
    }

    public ManaData upperMaxStable(double max) {
        return setMaxStable(stableMax + max);
    }

    public ManaData upperMaxSurge(double max) {
        return setMaxSurge(surgeMax + max);
    }

    /**---------------- ↓↓↓ Subtracter ↓↓↓ ----------------**/

    public ManaData consumeStable(double mana) {
        return setStable(stable - mana);
    }

    public ManaData consumeSurge(double mana) {
        return setSurge(surge - mana);
    }

    public ManaData lowerMaxStable(double max) {
        return setMaxStable(stableMax - max);
    }

    public ManaData lowerMaxSurge(double max) {
        return setMaxSurge(surgeMax - max);
    }

    /**---------------- Other Method ----------------**/
    private double fix(double i, boolean isStableMax) {
        if (i <= 0.0) {
            return 0.0; //如果魔力小于等于0，直接取0
        } else {
            return Math.min(isStableMax ? stableMax : surgeMax, i); //如果魔力大于上限值，取上限
        }
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