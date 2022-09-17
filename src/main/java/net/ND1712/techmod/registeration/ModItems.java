package net.ND1712.techmod.registeration;

import net.ND1712.techmod.technology_mod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			technology_mod.MOD_ID);
	
	public static final RegistryObject<BlockItem> BATTERY_BLOCK = ITEMS.register("battery_block",
			() -> new BlockItem(ModBlocks.BATTERY_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

}
