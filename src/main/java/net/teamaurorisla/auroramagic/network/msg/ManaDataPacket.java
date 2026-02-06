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

public class ManaDataPacket {

    public final double stable;
    public final double surge;
    public final double stableMax;
    public final double surgeMax;
    public final boolean isOverloaded;

    public ManaDataPacket(ManaData manaData) {
        this(manaData.getStable(), manaData.getSurge(), manaData.getMaxStable(), manaData.getMaxSurge(), manaData.isOverloaded());
    }

    public ManaDataPacket(double stable, double surge, double stableMax, double surgeMax, boolean isOverloaded) {
        this.stable = stable;
        this.surge = surge;
        this.stableMax = stableMax;
        this.surgeMax = surgeMax;
        this.isOverloaded = isOverloaded;
    }

    public static void encode(ManaDataPacket msg, FriendlyByteBuf buffer) {
        buffer.writeDouble(msg.stable);
        buffer.writeDouble(msg.surge);
        buffer.writeDouble(msg.stableMax);
        buffer.writeDouble(msg.surgeMax);
        buffer.writeBoolean(msg.isOverloaded);
    }

    public static ManaDataPacket decode(FriendlyByteBuf buffer) {
        return new ManaDataPacket(buffer.readDouble(), buffer.readDouble(), buffer.readDouble(), buffer.readDouble(), buffer.readBoolean());
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
            player.getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(manaData -> {
                manaData.setStable(msg.stable).setSurge(msg.surge).setMaxStable(msg.stableMax).setMaxSurge(msg.surgeMax).setOverloaded(msg.isOverloaded);
            });
        }
    }

}