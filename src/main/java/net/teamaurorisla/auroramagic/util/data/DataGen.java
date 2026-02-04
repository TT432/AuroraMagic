package net.teamaurorisla.auroramagic.util.data;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.util.data.Lang.ChineseLanguageProvider;
import net.teamaurorisla.auroramagic.util.data.Lang.EnglishLanguageProvider;

@Mod.EventBusSubscriber(modid = AuroraMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {

        var Generator = event.getGenerator();
        var PackOutput = event.getGenerator().getPackOutput();

        Generator.addProvider(event.includeClient(), new EnglishLanguageProvider(PackOutput));
        Generator.addProvider(event.includeServer(), new ChineseLanguageProvider(PackOutput));

    }
}
