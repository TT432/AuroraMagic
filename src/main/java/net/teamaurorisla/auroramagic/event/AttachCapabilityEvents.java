package net.teamaurorisla.auroramagic.event;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.capability.mana.ManaProvider;
import net.teamaurorisla.auroramagic.network.AMNetworkHandler;
import net.teamaurorisla.auroramagic.network.msg.ManaDataPacket;

@Mod.EventBusSubscriber(modid = AuroraMagic.MODID)
public class AttachCapabilityEvents {

    @SubscribeEvent
    public static void onAttachMana(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player) {
            if (!(player.getCapability(ManaProvider.MANA_CAPABILITY).isPresent())) {
                event.addCapability(ManaProvider.LOCATION, new ManaProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onManaTest(PlayerInteractEvent.RightClickItem event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        player.getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(manaData -> {
            if (!level.isClientSide) {
                manaData.consumeStable(1.0);
                AMNetworkHandler.sendToPlayerClient(new ManaDataPacket(manaData), (ServerPlayer) player);
            }
        });
    }

}