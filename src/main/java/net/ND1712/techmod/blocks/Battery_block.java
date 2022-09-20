package net.ND1712.techmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Battery_block extends BaseHorizontalBlock{
	ItemStack itemStack = new ItemStack(Items.DIAMOND, 7);
	
	
	public Battery_block(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(CHARGE, 0));
	}
	
	public static final IntegerProperty CHARGE = IntegerProperty.create("charge", 0, 4);
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {
		if (pPlayer.getMainHandItem().getItem() == Items.FIRE_CHARGE) {
			pPlayer.setItemInHand(pHand, itemStack);
			
		}
		return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
	}
	
	
	
	

           @Override
             protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
	            super.createBlockStateDefinition(builder);
                builder.add(CHARGE);
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

	
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return makeShape();
	}

}