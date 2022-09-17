package net.ND1712.techmod.blocks;

import java.util.HashMap;
import java.util.Map;

import com.google.common.util.concurrent.Service.State;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.storage.WorldData;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseHorizontalBlock extends Block{
	protected static final Map<Direction, VoxelShape> SHAPES = new HashMap<Direction, VoxelShape>();
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	

	public BaseHorizontalBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH));
	}
	@Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
    	return state.rotate(mirrorIn.getRotation(state.getValue(HORIZONTAL_FACING)));
    	
    }	
    
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(HORIZONTAL_FACING, rotation.rotate(state.getValue(HORIZONTAL_FACING)));
     }
    
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
    	return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getNearestLookingDirection().getOpposite());
    }
    
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
    	super.createBlockStateDefinition(builder);
    	builder.add(HORIZONTAL_FACING);
    }
    
}
