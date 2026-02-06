package net.teamaurorisla.auroramagic.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.teamaurorisla.auroramagic.AuroraMagic;
import net.teamaurorisla.auroramagic.network.msg.ManaDataPacket;

public class AMNetworkHandler {

    private static int ID = 0;
    private static final String VERSION = "1.0";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            ResourceLocation.tryBuild(AuroraMagic.MODID, "network"),
            () -> VERSION,
            VERSION::equals,
            VERSION::equals
    );

    public static void register() {
        INSTANCE.registerMessage(ID++, ManaDataPacket.class, ManaDataPacket::encode, ManaDataPacket::decode, ManaDataPacket::handle);
    }

    public static <M> M sendToPlayerClient(M msg, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
        return msg;
    }

    public static <M> M sendToAllClient(M msg) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
        return msg;
    }

    public static <M> M sendToServer(M msg) {
        INSTANCE.sendToServer(msg);
        return msg;
    }

}
