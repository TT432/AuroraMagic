package net.teamaurorisla.auroramagic.registry;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamaurorisla.auroramagic.AuroraMagic;

public class AMAttribute {
    public static final DeferredRegister<Attribute> ATTRIBUTE = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, AuroraMagic.MODID);

    //魔导效能
    public static final RegistryObject<Attribute> MANA_EFFICIENCY = ATTRIBUTE.register("mana_efficiency",
            () -> new RangedAttribute(
                    "attribute.auroramagic.mana_efficiency",
                    1.0,
                    0.0,
                    1024.0
            ).setSyncable(true)
    );

    //法术强度
    public static final RegistryObject<Attribute> SPELL_POWER = ATTRIBUTE.register("spell_power",
            () -> new RangedAttribute(
                    "attribute.auroramagic.spell_power",
                    1.0,
                    0.0,
                    1024.0
            ).setSyncable(true)
    );

    //流派亲和
    public static final RegistryObject<Attribute> BLAZE_AFFINITY = ATTRIBUTE.register("blaze_affinity",
            () -> new RangedAttribute(
                    "attribute.auroramagic.blaze_affinity",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> FROST_AFFINITY = ATTRIBUTE.register("frost_affinity",
            () -> new RangedAttribute(
                    "attribute.auroramagic.frost_affinity",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> EARTH_AFFINITY = ATTRIBUTE.register("earth_affinity",
            () -> new RangedAttribute(
                    "attribute.auroramagic.earth_affinity",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> GALE_AFFINITY = ATTRIBUTE.register("gale_affinity",
            () -> new RangedAttribute(
                    "attribute.auroramagic.gale_affinity",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> LIGHTNING_AFFINITY = ATTRIBUTE.register("lightning_affinity",
            () -> new RangedAttribute(
                    "attribute.auroramagic.lightning_affinity",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> DIVINE_AFFINITY = ATTRIBUTE.register("divine_affinity",
            () -> new RangedAttribute(
                    "attribute.auroramagic.divine_affinity",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );

    //法术抗性
    public static final RegistryObject<Attribute> SPELL_RESISTANCE = ATTRIBUTE.register("spell_resistance",
        () -> new RangedAttribute(
                "attribute.auroramagic.spell_resistance",
                0.0,
                -1024.0,
                1024.0
        ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> BLAZE_RESISTANCE = ATTRIBUTE.register("blaze_resistance",
            () -> new RangedAttribute(
                    "attribute.auroramagic.blaze_resistance",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> FROST_RESISTANCE = ATTRIBUTE.register("frost_resistance",
            () -> new RangedAttribute(
                    "attribute.auroramagic.frost_resistance",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> EARTH_RESISTANCE = ATTRIBUTE.register("earth_resistance",
            () -> new RangedAttribute(
                    "attribute.auroramagic.earth_resistance",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> GALE_RESISTANCE = ATTRIBUTE.register("gale_resistance",
            () -> new RangedAttribute(
                    "attribute.auroramagic.gale_resistance",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> LIGHTNING_RESISTANCE = ATTRIBUTE.register("lightning_resistance",
            () -> new RangedAttribute(
                    "attribute.auroramagic.lightning_resistance",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );
    public static final RegistryObject<Attribute> DIVINE_RESISTANCE = ATTRIBUTE.register("divine_resistance",
            () -> new RangedAttribute(
                    "attribute.auroramagic.divine_resistance",
                    0.0,
                    -1024.0,
                    1024.0
            ).setSyncable(true)
    );

}
