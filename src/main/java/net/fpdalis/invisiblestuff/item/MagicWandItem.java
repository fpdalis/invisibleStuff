package net.fpdalis.invisiblestuff.item;

import net.fpdalis.invisiblestuff.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MagicWandItem extends Item {
    public MagicWandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            BlockState state = pContext.getLevel().getBlockState(positionClicked);

            if(state.is(BlockTags.FENCES)) {
                if(state.is(BlockTags.FENCES)) {
                    pContext.getLevel().removeBlock(positionClicked, false);
                    pContext.getLevel().setBlock(positionClicked, ModBlocks.INVISIBLE_FENCE.get().defaultBlockState(), 1);
                }

            }if(!(state.is(BlockTags.FENCES) || state.is(BlockTags.BUTTONS) || state.is(BlockTags.DOORS) || state.is(BlockTags.PRESSURE_PLATES)))  {
                pContext.getLevel().removeBlock(positionClicked,false);
                pContext.getLevel().setBlock(positionClicked, ModBlocks.INVISIBLE_BLOCK.get().defaultBlockState(),1);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
