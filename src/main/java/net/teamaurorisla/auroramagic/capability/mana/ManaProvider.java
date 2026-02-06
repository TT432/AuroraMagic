package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.teamaurorisla.auroramagic.AuroraMagic;
import org.jetbrains.annotations.NotNull;

@AutoRegisterCapability
public class ManaProvider implements ICapabilitySerializable<CompoundTag> {

    public static final Capability<ManaData> MANA_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    public static final ResourceLocation LOCATION = ResourceLocation.tryBuild(AuroraMagic.MODID, "mana");
    private final ManaData manaData;

    public ManaProvider() {
        this.manaData = new ManaData();
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
        return cap == MANA_CAPABILITY ? LazyOptional.of(() -> manaData).cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        return manaData.serialize(new CompoundTag());
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        manaData.deserialize(tag);
    }

}
