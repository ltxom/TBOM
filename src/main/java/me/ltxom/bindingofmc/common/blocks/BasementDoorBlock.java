package me.ltxom.bindingofmc.common.blocks;

import me.ltxom.bindingofmc.core.init.BlockInit;
import me.ltxom.bindingofmc.core.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BasementDoorBlock extends CarpetBlock {

    public BasementDoorBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState blockState, World world,
                                             BlockPos blockPos, PlayerEntity playerEntity,
                                             Hand hand,
                                             BlockRayTraceResult blockRayTraceResult) {
        ActionResultType resultType = super.onBlockActivated(blockState, world, blockPos,
                playerEntity, hand, blockRayTraceResult);
        if (!world.isRemote()) {
            ItemStack item = playerEntity.getHeldItem(hand);
            if (item.getItem().equals(ItemInit.KEY_TO_BASEMENT_ITEM.get().asItem())) {
                item.setCount(item.getCount() - 1);
                world.setBlockState(blockPos,
                        BlockInit.OPENED_BASEMENT_DOOR_BLOCK_REGISTRY_OBJECT.get().getDefaultState());
            } else {
                playerEntity.sendMessage(new TranslationTextComponent("message" +
                                ".bindingofminecraft.cannot_open_basement_door"),
                        playerEntity.getUniqueID());
            }
        }
        return resultType;
    }
}
