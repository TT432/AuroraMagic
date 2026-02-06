package net.teamaurorisla.auroramagic.gui.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.teamaurorisla.auroramagic.capability.mana.ManaProvider;

public class ManaDataOverlay implements IGuiOverlay {

    @Override
    public void render(ForgeGui gui, GuiGraphics graphics, float partialTick, int width, int height) {
        Minecraft mc = gui.getMinecraft();
        Player player = mc.player;
        Font font = mc.font;
        if (player != null) {
            player.getCapability(ManaProvider.MANA_CAPABILITY).ifPresent(manaData -> {
                graphics.drawString(font, "" + manaData.getStable(), 0, 0, 1, false);
            });
        }
    }

}
