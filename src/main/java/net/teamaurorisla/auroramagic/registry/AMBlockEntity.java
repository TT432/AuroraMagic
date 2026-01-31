package net.teamaurorisla.auroramagic.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.block.entity.ArcanePedestalBlockEntity;

public final class AMBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AuroraMagic.MODID);

    public static final RegistryObject<BlockEntityType<ArcanePedestalBlockEntity>> ARCANE_PEDESTAL = BLOCK_ENTITY.register("arcane_pedestal",
            () -> BlockEntityType.Builder.of(ArcanePedestalBlockEntity::new,
                    AMBlock.ARCANE_PEDESTAL.get()).build(null));
}
