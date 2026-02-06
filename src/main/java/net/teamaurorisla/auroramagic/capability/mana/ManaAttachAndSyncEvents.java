package net.teamaurorisla.auroramagic.capability.mana;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamaurorisla.auroramagic.AuroraMagic;

@Mod.EventBusSubscriber(modid = AuroraMagic.MODID)
public class ManaAttachAndSyncEvents {

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
        if (!level.isClientSide) {
            ManaManager manager = ManaManager.of(player);
            if (event.getItemStack().getItem().equals(Items.ACACIA_BOAT)) {
                manager.consume(ManaType.STABLE, 1.5, false);
            } else {
                manager.set(ManaType.STABLE, manager.get(ManaType.MAX_STABLE));
            }
        }
    }

}