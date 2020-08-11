package com.redfeng.test2.blocks;

import javax.annotation.Nullable;

import com.redfeng.test2.state.properties.BlockStateProperties2;
import com.redfeng.test2.state.properties.QSlabType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class QSlabBlock extends Block {
    public static final EnumProperty<QSlabType> TYPE = BlockStateProperties2.Q_SLAB_TYPE;
    protected static final VoxelShape FIRST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
    protected static final VoxelShape SECOND_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    protected static final VoxelShape THIRD_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    protected static final VoxelShape FOURTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape ALL_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public QSlabBlock(Block.Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(TYPE, QSlabType.FIRST));
    }

    public boolean func_220074_n(BlockState state) {
        return state.get(TYPE) != QSlabType.ALL;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        QSlabType qslabtype = state.get(TYPE);
        switch(qslabtype) {
            case ALL:
                return ALL_SHAPE;
            case SECOND:
                return SECOND_SHAPE;
            case THIRD:
                return THIRD_SHAPE;
            case FOURTH:
                return FOURTH_SHAPE;
            default:
                return FIRST_SHAPE;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        BlockState blockstate = context.getWorld().getBlockState(blockpos);
        BlockState blockstate1 = this.getDefaultState().with(TYPE, QSlabType.FIRST);
        BlockState blockstate2 = blockstate1.with(TYPE, QSlabType.SECOND);
        BlockState blockstate3 = blockstate2.with(TYPE, QSlabType.THIRD);
        BlockState blockstate4 = blockstate3.with(TYPE, QSlabType.ALL);
        if (blockstate == blockstate1) {
            return blockstate2;
        } else if (blockstate == blockstate2) {
            return blockstate3;
        } else if (blockstate == blockstate3) {
            return blockstate4;
        } else if (blockstate == blockstate4) {
            return blockstate4;
        } else {
            return blockstate1;
            /*Direction direction = context.getFace();
            boolean checkVar = direction != Direction.DOWN;
            boolean checkDir2 = (direction == Direction.UP);
            if (checkVar && (checkDir2 || !(context.getHitVec().y - (double)blockpos.getY() > 0.25D))) return blockstate1;
            else if (checkVar && (checkDir2 || !(context.getHitVec().y - (double)blockpos.getY() > 0.5D))) return blockstate2;
            else if (checkVar && (checkDir2 || !(context.getHitVec().y - (double)blockpos.getY() > 0.75D))) return blockstate3;
            else return blockstate4;*/
        }
    }

    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        ItemStack itemstack = useContext.getItem();
        QSlabType qslabtype = state.get(TYPE);
        if (qslabtype != QSlabType.ALL && itemstack.getItem() == this.asItem()) {
            return true;
            /*if (useContext.replacingClickedOnBlock()) {
                boolean flag = useContext.getHitVec().y - (double) useContext.getPos().getY() > 0.5D;
                Direction direction = useContext.getFace();
                if (qslabtype == QSlabType.SECOND) {
                    return direction == Direction.UP || flag && direction.getAxis().isHorizontal();
                } else {
                    return direction == Direction.DOWN || !flag && direction.getAxis().isHorizontal();
                }
            } else {
                return true;
            }*/
        } else {
            return false;
        }
    }

    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        BlockState blockstate1 = this.getDefaultState().with(TYPE, QSlabType.FIRST);
        BlockState blockstate2 = blockstate1.with(TYPE, QSlabType.SECOND);
        BlockState blockstate3 = blockstate2.with(TYPE, QSlabType.THIRD);
        BlockState blockstate4 = blockstate3.with(TYPE, QSlabType.ALL);
        if (state == blockstate2) {
            worldIn.setBlockState(pos, blockstate1);
        } else if (state == blockstate3) {
            worldIn.setBlockState(pos, blockstate2);
        } else if (state == blockstate4) {
            worldIn.setBlockState(pos, blockstate3);
        }
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        switch(type) {
            case LAND:
                return false;
            case WATER:
                return worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
            case AIR:
                return false;
            default:
                return false;
        }
    }
}