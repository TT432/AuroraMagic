package net.teamaurorisla.auroramagic;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.teamaurorisla.auroramagic.registry.*;
import org.slf4j.Logger;

@Mod(AuroraMagic.MODID)
public class AuroraMagic {

    public static final String MODID = "auroramagic";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AuroraMagic() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        AMItem.ITEM.register(modEventBus);
        AMAttribute.ATTRIBUTE.register(modEventBus);
        AMEffect.EFFECT.register(modEventBus);
        AMBlock.BLOCK.register(modEventBus);
        AMBlockItem.BLOCK_ITEM.register(modEventBus);
        AMBlockEntity.BLOCK_ENTITY.register(modEventBus);
        AMCreativeModeTab.CREATIVE_MODE_TAB.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register attribute modification event
        modEventBus.addListener(this::onEntityAttributeModification);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) event.accept(AMBlockItem.EXAMPLE_BLOCK_ITEM.get());
    }

    // Add custom attributes to player
    private void onEntityAttributeModification(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, AMAttribute.MANA_EFFICIENCY.get());
        event.add(EntityType.PLAYER, AMAttribute.SPELL_POWER.get());
        event.add(EntityType.PLAYER, AMAttribute.BLAZE_AFFINITY.get());
        event.add(EntityType.PLAYER, AMAttribute.FROST_AFFINITY.get());
        event.add(EntityType.PLAYER, AMAttribute.EARTH_AFFINITY.get());
        event.add(EntityType.PLAYER, AMAttribute.GALE_AFFINITY.get());
        event.add(EntityType.PLAYER, AMAttribute.LIGHTNING_AFFINITY.get());
        event.add(EntityType.PLAYER, AMAttribute.DIVINE_AFFINITY.get());
        event.add(EntityType.PLAYER, AMAttribute.SPELL_RESISTANCE.get());
        event.add(EntityType.PLAYER, AMAttribute.BLAZE_RESISTANCE.get());
        event.add(EntityType.PLAYER, AMAttribute.FROST_RESISTANCE.get());
        event.add(EntityType.PLAYER, AMAttribute.EARTH_RESISTANCE.get());
        event.add(EntityType.PLAYER, AMAttribute.GALE_RESISTANCE.get());
        event.add(EntityType.PLAYER, AMAttribute.LIGHTNING_RESISTANCE.get());
        event.add(EntityType.PLAYER, AMAttribute.DIVINE_RESISTANCE.get());
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
