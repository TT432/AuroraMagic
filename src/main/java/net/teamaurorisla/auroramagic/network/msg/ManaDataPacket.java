package net.teamaurorisla.auroramagic.network.msg;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import net.teamaurorisla.auroramagic.capability.mana.ManaData;
import net.teamaurorisla.auroramagic.capability.mana.ManaProvider;

import java.util.function.Supplier;

public record ManaDataPacket(ManaData manaData) {

    public static void encode(ManaDataPacket msg, FriendlyByteBuf buf) {
        msg.manaData.writeToNetwork(buf);
    }

    public static ManaDataPacket decode(FriendlyByteBuf buf) {
        return new ManaDataPacket(ManaData.readFromNetwork(buf));
    }

    public static void handle(ManaDataPacket msg, Supplier<NetworkEvent.Context> sup) {
        NetworkEvent.Context ctx = sup.get();
        if (ctx.getDirection().getReceptionSide().isClient()) {
            ctx.enqueueWork(() -> {
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ManaDataClientPacket.handleClient(msg, sup));
            });
        }
        ctx.setPacketHandled(true);
    }

}

@OnlyIn(Dist.CLIENT)
class ManaDataClientPacket {

    public static void handleClient(ManaDataPacket msg, Supplier<NetworkEvent.Context> sup) {
        Player player = Minecraft.getInstance().player;
        NetworkEvent.Context ctx = sup.get();
        if (ctx.getDirection().getReceptionSide().isClient() && player != null) {
            player.getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(manaData -> manaData.setSelf(msg.manaData()));
        }
    }

}