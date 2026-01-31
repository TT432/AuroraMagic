package net.teamaurorisla.auroramagic.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.client.renderer.ArcanePedestalRenderer;
import net.teamaurorisla.auroramagic.registry.AMBlockEntity;

/**
 * 处理客户端事件
 */
@Mod.EventBusSubscriber(modid = AuroraMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AMBlockEntity.ARCANE_PEDESTAL.get(), ArcanePedestalRenderer::new);
    }
}
