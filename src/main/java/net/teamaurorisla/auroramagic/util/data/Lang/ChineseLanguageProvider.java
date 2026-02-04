package net.teamaurorisla.auroramagic.util.data.Lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.teamaurorisla.auroramagic.AuroraMagic;

public class ChineseLanguageProvider extends LanguageProvider {

    public ChineseLanguageProvider(PackOutput output) {
        super(output, AuroraMagic.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        this.add("block.auroramagic.arcane_pedestal", "基座");

        this.add("attribute.auroramagic.mana_efficiency", "魔导效能");
        this.add("attribute.auroramagic.spell_power", "法术强度");
        this.add("attribute.auroramagic.frost_affinity", "寒冰亲和");
        this.add("attribute.auroramagic.gale_affinity", "疾风亲和");
        this.add("attribute.auroramagic.blaze_affinity", "炽焰亲和");
        this.add("attribute.auroramagic.divine_affinity", "神圣亲和");
        this.add("attribute.auroramagic.earth_affinity", "磐石亲和");
        this.add("attribute.auroramagic.lightning_affinity", "雷电亲和");
        this.add("attribute.auroramagic.spell_resistance", "法术抗性");
        this.add("attribute.auroramagic.blaze_resistance", "炽焰抗性");
        this.add("attribute.auroramagic.frost_resistance", "寒冰抗性");
        this.add("attribute.auroramagic.earth_resistance", "磐石抗性");
        this.add("attribute.auroramagic.gale_resistance", "疾风抗性");
        this.add("attribute.auroramagic.lightning_resistance", "雷电抗性");
        this.add("attribute.auroramagic.divine_resistance", "神圣抗性");

        this.add("death.attack.auroramagic.damage_type.blaze_spell", "%1$s 被炽焰法术灼烧了");
        this.add("death.attack.auroramagic.damage_type.blaze_spell.player", "%1$s 在与 %2$s 的战斗中被炽焰法术灼烧了");
        this.add("death.attack.auroramagic.damage_type.blaze_spell_magical", "%1$s 被炽焰法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.blaze_spell_magical.player", "%1$s 被 %2$s 的炽焰法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.frost_spell", "%1$s 被寒冰法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.frost_spell.player", "%1$s 被 %2$s 的寒冰法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.frost_spell_magical", "%1$s 被寒冰法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.frost_spell_magical.player", "%1$s 被 %2$s 的寒冰法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.earth_spell", "%1$s 被磐石法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.earth_spell.player", "%1$s 被 %2$s 的磐石法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.earth_spell_magical", "%1$s 被磐石法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.earth_spell_magical.player", "%1$s 被 %2$s 的磐石法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.gale_spell", "%1$s 被疾风法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.gale_spell.player", "%1$s 被 %2$s 的疾风法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.gale_spell_magical", "%1$s 被疾风法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.gale_spell_magical.player", "%1$s 被 %2$s 的疾风法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.lightning_spell", "%1$s 被雷电法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.lightning_spell.player", "%1$s 被 %2$s 的雷电法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.lightning_spell_magical", "%1$s 被雷电法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.lightning_spell_magical.player", "%1$s 被 %2$s 的雷电法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.divine_spell", "%1$s 被神圣法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.divine_spell.player", "%1$s 被 %2$s 的神圣法术伤害击杀");
        this.add("death.attack.auroramagic.damage_type.divine_spell_magical", "%1$s 被神圣法术魔法伤害击杀");
        this.add("death.attack.auroramagic.damage_type.divine_spell_magical.player", "%1$s 被 %2$s 的神圣法术魔法伤害击杀");
    }
}
