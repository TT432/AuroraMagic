package net.teamaurorisla.auroramagic.capability;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.capability.mana.ManaProvider;
import net.teamaurorisla.auroramagic.registry.AMItem;

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
    public static void onManaTestEvent(PlayerInteractEvent.RightClickItem event) {
        if (event.getItemStack().getItem() == AMItem.EXAMPLE_ITEM.item()) {
            event.getEntity().getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(manaData -> {
                event.getEntity().sendSystemMessage(Component.literal("" + manaData.getStable()));
            });
        }
    }

}