package net.teamaurorisla.auroramagic.util.data.Lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.registry.AMAttribute;
import net.teamaurorisla.auroramagic.registry.AMBlock;
import org.checkerframework.checker.units.qual.A;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, AuroraMagic.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(AMBlock.ARCANE_PEDESTAL.get(), "Arcane Pedestal");

        this.add(String.valueOf(AMAttribute.MANA_EFFICIENCY.get()), "Mana Efficiency");
        this.add(String.valueOf(AMAttribute.SPELL_POWER.get()), "Spell Power");
        this.add(String.valueOf(AMAttribute.FROST_AFFINITY.get()), "Frost Affinity");
        this.add(String.valueOf(AMAttribute.GALE_AFFINITY.get()), "Gale Affinity");
        this.add(String.valueOf(AMAttribute.BLAZE_AFFINITY.get()), "Blaze Affinity");
        this.add(String.valueOf(AMAttribute.DIVINE_AFFINITY.get()), "Divine Affinity");
        this.add(String.valueOf(AMAttribute.EARTH_AFFINITY.get()), "Earth Affinity");
        this.add(String.valueOf(AMAttribute.LIGHTNING_AFFINITY.get()), "Lightning Affinity");
        this.add(String.valueOf(AMAttribute.SPELL_RESISTANCE.get()), "Spell Resistance");
        this.add(String.valueOf(AMAttribute.BLAZE_RESISTANCE.get()), "Blaze Resistance");
        this.add(String.valueOf(AMAttribute.FROST_RESISTANCE.get()), "Frost Resistance");
        this.add(String.valueOf(AMAttribute.EARTH_RESISTANCE.get()), "Earth Resistance");
        this.add(String.valueOf(AMAttribute.GALE_RESISTANCE.get()), "Gale Resistance");
        this.add(String.valueOf(AMAttribute.LIGHTNING_RESISTANCE.get()), "Lightning Resistance");
        this.add(String.valueOf(AMAttribute.DIVINE_RESISTANCE.get()), "Divine Resistance");
    }
}
