package com.periodiccraft.pcm.core.fluids;

import com.periodiccraft.pcm.PeriodicCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PeriodicFluid extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
	
	
    
    /***
     * 
     * @param par1 is the fluid
     * @param par2 is the Material(Material.water)
     * @param par3 is the FluidBlock
     * @param par4 How dense is the fluid, the only effect is whether or not a fluid replaces another fluid when they flow into each other. Default: 1000, the density of water at 4 degrees Celsius in kg/m³
     * @param par5 How hot, or cold is the fluid
     * @param par6 How much light does the fluid emit. Default: 0, Lava uses 15
     * @param par7 The Thickness of the fluid. How fast you move in it.
     * 
     * Really Quick:
     * Temperature of the fluid - completely arbitrary; higher temperature indicates that the fluid is
     * hotter than air.
     * 
     * Default value is approximately the real-life room temperature of water in degrees Kelvin.
     * 
     */
	public PeriodicFluid(Fluid par1, Material par2, Block par3, int par4, int par5, int par6, int par7, String par8) {
		super(par1, par2);
		FluidRegistry.registerFluid(par1);
		GameRegistry.registerBlock(par3, par3 + this.getUnlocalizedName().substring(5));
		this.setDensity(par4);
		this.setTemperature(par5);
		this.setBlockName(par8);
		

	}
	
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    /***
     * the texture names will be the Unlocalized Name + "still", or in the case of flowing, "flowing".
     * 
     */
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
            stillIcon = register.registerIcon(PeriodicCraft.MODID + ":" + this.getUnlocalizedName().substring(5) + "still");
            flowingIcon = register.registerIcon(PeriodicCraft.MODID + ":" + this.getUnlocalizedName().substring(5) + "flowing");
    
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    
}
