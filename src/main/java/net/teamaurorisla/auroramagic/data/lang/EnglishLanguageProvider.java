package net.teamaurorisla.auroramagic.data.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.registry.AMBlock;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, AuroraMagic.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(AMBlock.ARCANE_PEDESTAL.get(), "Arcane Pedestal");


        this.add("attribute.auroramagic.mana_efficiency", "Mana Efficiency");
        this.add("attribute.auroramagic.spell_power", "Spell Power");
        this.add("attribute.auroramagic.frost_affinity", "Frost Affinity");
        this.add("attribute.auroramagic.gale_affinity", "Gale Affinity");
        this.add("attribute.auroramagic.blaze_affinity", "Blaze Affinity");
        this.add("attribute.auroramagic.divine_affinity", "Divine Affinity");
        this.add("attribute.auroramagic.earth_affinity", "Earth Affinity");
        this.add("attribute.auroramagic.lightning_affinity", "Lightning Affinity");
        this.add("attribute.auroramagic.spell_resistance", "Spell Resistance");
        this.add("attribute.auroramagic.blaze_resistance", "Blaze Resistance");
        this.add("attribute.auroramagic.frost_resistance", "Frost Resistance");
        this.add("attribute.auroramagic.earth_resistance", "Earth Resistance");
        this.add("attribute.auroramagic.gale_resistance", "Gale Resistance");
        this.add("attribute.auroramagic.lightning_resistance", "Lightning Resistance");
        this.add("attribute.auroramagic.divine_resistance", "Divine Resistance");

        this.add("death.attack.auroramagic.damage_type.blaze_spell", "%1$s was killed by blaze spell damage");
        this.add("death.attack.auroramagic.damage_type.blaze_spell.player", "%1$s was killed by %2$s using blaze spell damage");
        this.add("death.attack.auroramagic.damage_type.blaze_spell_magical", "%1$s was killed by blaze spell magical damage");
        this.add("death.attack.auroramagic.damage_type.blaze_spell_magical.player", "%1$s was killed by %2$s using blaze spell magical damage");
        this.add("death.attack.auroramagic.damage_type.frost_spell", "%1$s was killed by frost spell damage");
        this.add("death.attack.auroramagic.damage_type.frost_spell.player", "%1$s was killed by %2$s using frost spell damage");
        this.add("death.attack.auroramagic.damage_type.frost_spell_magical", "%1$s was killed by frost spell magical damage");
        this.add("death.attack.auroramagic.damage_type.frost_spell_magical.player", "%1$s was killed by %2$s using frost spell magical damage");
        this.add("death.attack.auroramagic.damage_type.earth_spell", "%1$s was killed by earth spell damage");
        this.add("death.attack.auroramagic.damage_type.earth_spell.player", "%1$s was killed by %2$s using earth spell damage");
        this.add("death.attack.auroramagic.damage_type.earth_spell_magical", "%1$s was killed by earth spell magical damage");
        this.add("death.attack.auroramagic.damage_type.earth_spell_magical.player", "%1$s was killed by %2$s using earth spell magical damage");
        this.add("death.attack.auroramagic.damage_type.gale_spell", "%1$s was killed by gale spell damage");
        this.add("death.attack.auroramagic.damage_type.gale_spell.player", "%1$s was killed by %2$s using gale spell damage");
        this.add("death.attack.auroramagic.damage_type.gale_spell_magical", "%1$s was killed by gale spell magical damage");
        this.add("death.attack.auroramagic.damage_type.gale_spell_magical.player", "%1$s was killed by %2$s using gale spell magical damage");
        this.add("death.attack.auroramagic.damage_type.lightning_spell", "%1$s was killed by lightning spell damage");
        this.add("death.attack.auroramagic.damage_type.lightning_spell.player", "%1$s was killed by %2$s using lightning spell damage");
        this.add("death.attack.auroramagic.damage_type.lightning_spell_magical", "%1$s was killed by lightning spell magical damage");
        this.add("death.attack.auroramagic.damage_type.lightning_spell_magical.player", "%1$s was killed by %2$s using lightning spell magical damage");
        this.add("death.attack.auroramagic.damage_type.divine_spell", "%1$s was killed by divine spell damage");
        this.add("death.attack.auroramagic.damage_type.divine_spell.player", "%1$s was killed by %2$s using divine spell damage");
        this.add("death.attack.auroramagic.damage_type.divine_spell_magical", "%1$s was killed by divine spell magical damage");
        this.add("death.attack.auroramagic.damage_type.divine_spell_magical.player", "%1$s was killed by %2$s using divine spell magical damage");

    }
}
