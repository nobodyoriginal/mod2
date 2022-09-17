package net.ND1712.techmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Battery_block extends BaseHorizontalBlock{
	
	public Battery_block(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(CHARGE_LEVEL, Integer.valueOf(0)));

	}
	
	




	private static VoxelShape makeShape() {
	VoxelShape shape = Shapes.empty();
	shape = Shapes.join(shape, box(1, 0, 1, 15, 15, 12),BooleanOp.OR);
	shape = Shapes.join(shape, box(1, 0, 0, 15, 15, 1), BooleanOp.OR);
	shape = Shapes.join(shape, box(12, 0, 12, 16, 15, 16), BooleanOp.OR);
	shape = Shapes.join(shape, box(0, 0, 12, 4, 15, 16), BooleanOp.OR);
	shape = Shapes.join(shape, box(15, 0, 0, 16, 15, 12), BooleanOp.OR);
	return shape;
}
    public static final IntegerProperty CHARGE_LEVEL = Blockstates.CHARGE;

	
	
	
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
    	super.fillStateContainer(builder);
    	builder.add(CHARGE_LEVEL);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return makeShape();
	}

}