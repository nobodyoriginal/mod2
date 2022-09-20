package net.ND1712.techmod.registeration;

import net.ND1712.techmod.technology_mod;
import net.ND1712.techmod.blocks.Battery_block;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {	
	public static final DeferredRegister<net.minecraft.world.level.block.Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			technology_mod.MOD_ID);
	
	public static final RegistryObject<Battery_block> BATTERY_BLOCK = BLOCKS.register("battery_block",
			() -> new Battery_block(BlockBehaviour.Properties.of(Material.METAL)
			    .strength(1.8F)
			    .sound(SoundType.STONE)
			    .noOcclusion()
			    .requiresCorrectToolForDrops()));
	
}
