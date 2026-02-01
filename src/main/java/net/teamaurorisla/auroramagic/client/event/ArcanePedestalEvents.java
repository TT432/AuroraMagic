package net.teamaurorisla.auroramagic.client.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.block.entity.ArcanePedestalBlockEntity;
import net.teamaurorisla.auroramagic.client.renderer.ArcanePedestalRenderer;
import net.teamaurorisla.auroramagic.registry.AMBlockEntity;

@Mod.EventBusSubscriber(modid = AuroraMagic.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArcanePedestalEvents {

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        LevelAccessor levelAccessor = event.getLevel();
        if (levelAccessor instanceof Level level && !level.isClientSide()) {
            BlockPos pos = event.getPos();
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof ArcanePedestalBlockEntity pedestal) {
                Vec3 posC = pos.getCenter();
                level.addFreshEntity(new ItemEntity(level, posC.x, posC.y + 1, posC.z, pedestal.getDisplayItem()));
            }
        }
    }

}

/**
 * 处理客户端事件
 */
@Mod.EventBusSubscriber(modid = AuroraMagic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
class ClientEvents {

    @SubscribeEvent
    public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AMBlockEntity.ARCANE_PEDESTAL.get(), ArcanePedestalRenderer::new);
    }

}