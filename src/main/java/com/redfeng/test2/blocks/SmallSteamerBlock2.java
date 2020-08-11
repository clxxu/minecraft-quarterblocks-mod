package com.redfeng.test2.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class SmallSteamerBlock2 extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(3, 1.25, 3.5, 13, 1.5, 4.359999999999999),
            Block.makeCuboidShape(3, 1.25, 4.859999999999999, 13, 1.5, 5.710000000000001),
            Block.makeCuboidShape(3, 1.25, 6.219999999999999, 13, 1.5, 7.08),
            Block.makeCuboidShape(3, 1.25, 7.58, 13, 1.5, 8.44),
            Block.makeCuboidShape(3, 1.25, 11.66, 13, 1.5, 12.52),
            Block.makeCuboidShape(3, 1.25, 8.94, 13, 1.5, 9.79),
            Block.makeCuboidShape(3, 1.25, 10.3, 13, 1.5, 11.16),
            Block.makeCuboidShape(4.5, 1.3, 3, 6.5, 1.55, 13),
            Block.makeCuboidShape(9.5, 1.3, 3, 11.5, 1.55, 13),
            Block.makeCuboidShape(13, 0, 3, 14, 4, 13),
            Block.makeCuboidShape(2, 0, 3, 3, 4, 13),
            Block.makeCuboidShape(2, 0, 2, 14, 4, 3),
            Block.makeCuboidShape(2, 0, 13, 14, 4, 14)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(3, 1.25, 11.64, 13, 1.5, 12.5),
            Block.makeCuboidShape(3, 1.25, 10.29, 13, 1.5, 11.14),
            Block.makeCuboidShape(3, 1.25, 8.92, 13, 1.5, 9.780000000000001),
            Block.makeCuboidShape(3, 1.25, 7.5600000000000005, 13, 1.5, 8.42),
            Block.makeCuboidShape(3, 1.25, 3.4800000000000004, 13, 1.5, 4.34),
            Block.makeCuboidShape(3, 1.25, 6.210000000000001, 13, 1.5, 7.0600000000000005),
            Block.makeCuboidShape(3, 1.25, 4.84, 13, 1.5, 5.699999999999999),
            Block.makeCuboidShape(9.5, 1.3, 3, 11.5, 1.55, 13),
            Block.makeCuboidShape(4.5, 1.3, 3, 6.5, 1.55, 13),
            Block.makeCuboidShape(2, 0, 3, 3, 4, 13),
            Block.makeCuboidShape(13, 0, 3, 14, 4, 13),
            Block.makeCuboidShape(2, 0, 13, 14, 4, 14),
            Block.makeCuboidShape(2, 0, 2, 14, 4, 3)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(11.64, 1.25, 3, 12.5, 1.5, 13),
            Block.makeCuboidShape(10.29, 1.25, 3, 11.14, 1.5, 13),
            Block.makeCuboidShape(8.92, 1.25, 3, 9.780000000000001, 1.5, 13),
            Block.makeCuboidShape(7.5600000000000005, 1.25, 3, 8.42, 1.5, 13),
            Block.makeCuboidShape(3.4800000000000004, 1.25, 3, 4.34, 1.5, 13),
            Block.makeCuboidShape(6.210000000000001, 1.25, 3, 7.0600000000000005, 1.5, 13),
            Block.makeCuboidShape(4.84, 1.25, 3, 5.699999999999999, 1.5, 13),
            Block.makeCuboidShape(3, 1.3, 4.5, 13, 1.55, 6.5),
            Block.makeCuboidShape(3, 1.3, 9.5, 13, 1.55, 11.5),
            Block.makeCuboidShape(3, 0, 13, 13, 4, 14),
            Block.makeCuboidShape(3, 0, 2, 13, 4, 3),
            Block.makeCuboidShape(13, 0, 2, 14, 4, 14),
            Block.makeCuboidShape(2, 0, 2, 3, 4, 14)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(3.5, 1.25, 3, 4.359999999999999, 1.5, 13),
            Block.makeCuboidShape(4.859999999999999, 1.25, 3, 5.710000000000001, 1.5, 13),
            Block.makeCuboidShape(6.219999999999999, 1.25, 3, 7.08, 1.5, 13),
            Block.makeCuboidShape(7.58, 1.25, 3, 8.44, 1.5, 13),
            Block.makeCuboidShape(11.66, 1.25, 3, 12.52, 1.5, 13),
            Block.makeCuboidShape(8.94, 1.25, 3, 9.79, 1.5, 13),
            Block.makeCuboidShape(10.3, 1.25, 3, 11.16, 1.5, 13),
            Block.makeCuboidShape(3, 1.3, 9.5, 13, 1.55, 11.5),
            Block.makeCuboidShape(3, 1.3, 4.5, 13, 1.55, 6.5),
            Block.makeCuboidShape(3, 0, 2, 13, 4, 3),
            Block.makeCuboidShape(3, 0, 13, 13, 4, 14),
            Block.makeCuboidShape(2, 0, 2, 3, 4, 14),
            Block.makeCuboidShape(13, 0, 2, 14, 4, 14)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public SmallSteamerBlock2(Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
