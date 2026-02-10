package net.teamaurorisla.auroramagic.capability.mana;

import com.dark2932.darklib.util.PlayerUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
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
    public static void onPlayerClone(PlayerEvent.Clone event) {
        Player oldPlayer = event.getOriginal();
        Player newPlayer = event.getEntity();
        if (!newPlayer.level().isClientSide()) {
            oldPlayer.reviveCaps();
            ManaManager oldManager = ManaManager.of(oldPlayer);
            ManaManager newManager = ManaManager.of(newPlayer);
            if (event.isWasDeath()) oldManager.set(ManaType.STABLE, 0.0).set(ManaType.SURGE, 0.0);
            newManager.getManaData().setSelf(oldManager.getManaData()); //没调用newManager.setManaData()是因为这个地方给客户端发包没用，必须在Respawn和ChangedDimension事件里调用客户端发包。
            oldPlayer.invalidateCaps();
        }
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide()) ManaManager.of(player).sendToPlayerClient();
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide()) ManaManager.of(player).sendToPlayerClient();
    }

    @SubscribeEvent
    public static void onPlayerChangeDim(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide()) ManaManager.of(player).sendToPlayerClient();
    }

    @SubscribeEvent
    public static void onManaTest(PlayerInteractEvent.RightClickItem event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        if (!level.isClientSide) {
            ManaManager manager = ManaManager.of(player);
            if (event.getItemStack().getItem().equals(Items.STICK)) {
                if (manager.getCurrentMana() < 1.5) {
                    if (!manager.isOverloaded()) {
                        manager.consume(1.5).setOverloaded(true, 4.0);
                        player.sendSystemMessage(Component.literal("超载释放魔力！").withStyle(ChatFormatting.YELLOW));
                        PlayerUtil.sendSoundPacket(player, SoundEvents.ENDERMAN_TELEPORT, 1.0f, 0.5f);
                    } else {
                        player.sendSystemMessage(Component.literal("你已超载，无法再次超载释放魔力！").withStyle(ChatFormatting.RED));
                        PlayerUtil.sendSoundPacket(player, SoundEvents.VILLAGER_NO);
                    }
                } else {
                    manager.consume(1.5);
                    player.sendSystemMessage(Component.literal("释放魔力！").withStyle(ChatFormatting.GREEN));
                    PlayerUtil.sendSoundPacket(player, SoundEvents.PLAYER_LEVELUP);
                }
            } else {
                if (manager.isOverloaded()) manager.setOverloaded(false, -4.0);
                manager.set(ManaType.STABLE, manager.get(ManaType.MAX_STABLE));
                manager.set(ManaType.SURGE, manager.get(ManaType.MAX_SURGE));
            }
        }
    }

}