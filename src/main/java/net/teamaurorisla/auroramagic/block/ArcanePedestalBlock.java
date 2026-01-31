package net.teamaurorisla.auroramagic.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.teamaurorisla.auroramagic.block.entity.ArcanePedestalBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ArcanePedestalBlock extends Block implements EntityBlock {

    public ArcanePedestalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ArcanePedestalBlockEntity pedestal) {
            ItemStack itemInHand = player.getItemInHand(hand);

            if (!itemInHand.isEmpty()) {
                ItemStack displayItem = pedestal.getDisplayItem();
                if (displayItem.isEmpty()) { //放置物品
                    ItemStack toPlace = itemInHand.copy();
                    toPlace.setCount(1);
                    pedestal.setDisplayItem(toPlace);
                    itemInHand.shrink(1);
                    return InteractionResult.SUCCESS;
                }
            } else { //取回物品
                ItemStack displayItem = pedestal.getDisplayItem();
                if (!displayItem.isEmpty()) {
                    pedestal.clearItem();
                    if (!player.addItem(displayItem.copy())) {
                        player.drop(displayItem.copy(), false);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ArcanePedestalBlockEntity(pos, state);
    }
}
