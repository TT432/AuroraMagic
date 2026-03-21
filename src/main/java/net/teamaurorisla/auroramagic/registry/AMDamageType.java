package net.teamaurorisla.auroramagic.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.teamaurorisla.auroramagic.AuroraMagic;

public final class AMDamageType {
    public static final ResourceKey<DamageType> BLAZE_SPELL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "blaze_spell"));
    public static final ResourceKey<DamageType> FROST_SPELL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "frost_spell"));
    public static final ResourceKey<DamageType> EARTH_SPELL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "earth_spell"));
    public static final ResourceKey<DamageType> STORM_SPELL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "storm_spell"));
    public static final ResourceKey<DamageType> DIVINE_SPELL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "divine_spell"));
    public static final ResourceKey<DamageType> BLAZE_SPELL_MAGICAL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "blaze_spell_magical"));
    public static final ResourceKey<DamageType> FROST_SPELL_MAGICAL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "frost_spell_magical"));
    public static final ResourceKey<DamageType> EARTH_SPELL_MAGICAL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "earth_spell_magical"));
    public static final ResourceKey<DamageType> STORM_SPELL_MAGICAL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "storm_spell_magical"));
    public static final ResourceKey<DamageType> DIVINE_SPELL_MAGICAL=
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AuroraMagic.MODID, "divine_spell_magical"));
}
