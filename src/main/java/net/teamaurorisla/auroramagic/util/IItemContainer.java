package net.teamaurorisla.auroramagic.util;

import net.minecraft.world.item.ItemStack;

// 基座的物品容器接口，AI写的，快说谢谢AI
public interface IItemContainer {
    /**
     * Get the displayed item
     * @return the displayed item, or empty item if none
     */
    ItemStack getDisplayItem();

    /**
     * Set the displayed item
     * @param item the item to display
     */
    void setDisplayItem(ItemStack item);

    /**
     * Clear the displayed item
     */
    void clearItem();
}
