package net.ND1712.techmod.registeration;

import net.ND1712.techmod.technology_mod;
import net.ND1712.techmod.fluids.FluidRegistryContainer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, technology_mod.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, technology_mod.MOD_ID);
    
    public static final FluidRegistryContainer GREEN_LAVA = new FluidRegistryContainer("green_lava", FluidType.Properties.create().canSwim(false).canDrown(false).temperature(100),
    		() -> FluidRegistryContainer.createExtension(new FluidRegistryContainer.ClientExtensions(technology_mod.MOD_ID, "green_lava").overlay("green_lava").flowing("green_lava_flowing").still("green_lava_still")),
    		BlockBehaviour.Properties.copy(Blocks.LAVA),new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS).stacksTo(1));
}