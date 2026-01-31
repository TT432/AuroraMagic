package net.teamaurorisla.auroramagic.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamaurorisla.auroramagic.AuroraMagic;

import static net.teamaurorisla.auroramagic.registry.AMBlock.*;

public final class AMBlockItem {
    public static final DeferredRegister<Item> BLOCK_ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, AuroraMagic.MODID);

    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = BLOCK_ITEM.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ARCANE_PEDESTAL_ITEM = BLOCK_ITEM.register("arcane_pedestal", () -> new BlockItem(ARCANE_PEDESTAL.get(), new Item.Properties()));
}
