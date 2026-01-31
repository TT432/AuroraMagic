package net.teamaurorisla.auroramagic.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.block.ArcanePedestalBlock;

public final class AMBlock {
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, AuroraMagic.MODID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCK.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<Block> ARCANE_PEDESTAL = BLOCK.register("arcane_pedestal", () -> new ArcanePedestalBlock(
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 9.0F)
                    .sound(SoundType.STONE)
                    .noOcclusion()
    ));
}
