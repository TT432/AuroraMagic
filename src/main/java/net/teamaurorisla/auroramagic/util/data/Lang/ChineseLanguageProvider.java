package net.teamaurorisla.auroramagic.util.data.Lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.registry.AMAttribute;

public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output) {
        super(output, AuroraMagic.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        this.add("block.auroramagic.arcane_pedestal", "基座");

        this.add(String.valueOf(AMAttribute.MANA_EFFICIENCY.get()), "魔导效能");
        this.add(String.valueOf(AMAttribute.SPELL_POWER.get()), "法术强度");
        this.add(String.valueOf(AMAttribute.FROST_AFFINITY.get()), "寒冰亲和");
        this.add(String.valueOf(AMAttribute.GALE_AFFINITY.get()), "疾风亲和");
        this.add(String.valueOf(AMAttribute.BLAZE_AFFINITY.get()), "炽焰亲和");
        this.add(String.valueOf(AMAttribute.DIVINE_AFFINITY.get()), "神圣亲和");
        this.add(String.valueOf(AMAttribute.EARTH_AFFINITY.get()), "磐石亲和");
        this.add(String.valueOf(AMAttribute.LIGHTNING_AFFINITY.get()), "雷电亲和");
        this.add(String.valueOf(AMAttribute.SPELL_RESISTANCE.get()), "法术抗性");
        this.add(String.valueOf(AMAttribute.BLAZE_RESISTANCE.get()), "炽焰抗性");
        this.add(String.valueOf(AMAttribute.FROST_RESISTANCE.get()), "寒冰抗性");
        this.add(String.valueOf(AMAttribute.EARTH_RESISTANCE.get()), "磐石抗性");
        this.add(String.valueOf(AMAttribute.GALE_RESISTANCE.get()), "疾风抗性");
        this.add(String.valueOf(AMAttribute.LIGHTNING_RESISTANCE.get()), "雷电抗性");
        this.add(String.valueOf(AMAttribute.DIVINE_RESISTANCE.get()), "神圣抗性");
    }
}
