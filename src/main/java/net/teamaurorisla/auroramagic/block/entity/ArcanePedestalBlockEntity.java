package net.teamaurorisla.auroramagic.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.teamaurorisla.auroramagic.registry.AMBlockEntity;
import net.teamaurorisla.auroramagic.util.IItemContainer;

public class ArcanePedestalBlockEntity extends BlockEntity implements IItemContainer {
    private ItemStack displayItem = ItemStack.EMPTY;

    public ArcanePedestalBlockEntity(BlockPos pos, BlockState blockState) {
        super(AMBlockEntity.ARCANE_PEDESTAL.get(), pos, blockState);
    }

    @Override
    public ItemStack getDisplayItem() {
        return displayItem;
    }

    @Override
    public void setDisplayItem(ItemStack item) {
        this.displayItem = item.copy();
        this.setChanged();
        this.sendUpdates();
    }

    @Override
    public void clearItem() {
        this.displayItem = ItemStack.EMPTY;
        this.setChanged();
        this.sendUpdates();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("DisplayItem", displayItem.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("DisplayItem")) {
            displayItem = ItemStack.of(tag.getCompound("DisplayItem"));
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    private void sendUpdates() {
        if (this.level != null && !this.level.isClientSide) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }
}
