package net.teamaurorisla.auroramagic.registry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.effects.EffectManaOverflow;

public final class AMEffect {
    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AuroraMagic.MODID);

    public static final RegistryObject<MobEffect> MANA_OVERFLOW = EFFECT.register("mana_overflow",
            () -> new EffectManaOverflow(MobEffectCategory.BENEFICIAL, 0xBA55D3));
}
