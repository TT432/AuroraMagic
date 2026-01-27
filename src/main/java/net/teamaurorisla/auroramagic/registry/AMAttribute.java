package net.teamaurorisla.auroramagic.registry;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamaurorisla.auroramagic.AuroraMagic;

public class AMAttribute {
    public static final DeferredRegister<Attribute> ATTRIBUTE = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, AuroraMagic.MODID);

    public static final RegistryObject<Attribute> MANA_EFFICIENCY = ATTRIBUTE.register("mana_efficiency",
            () -> new RangedAttribute(
                    "attribute.auroramagic.mana_efficiency",
                    0.0,
                    0.0,
                    1024.0
            ).setSyncable(true)
    );
}
