package com.periodiccraft.pcm.core.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.tile.TileDiskManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDiskManager extends PeriodicElectricBlock {

	public static IIcon sideIcon;
	
	public BlockDiskManager() {
		super(Material.rock);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public final void registerBlockIcons(IIconRegister par1) {
		sideIcon = par1.registerIcon(PeriodicCraft.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return sideIcon;
	}
	
	@Override
	public final TileEntity createNewTileEntity(World par1, int par2) {
		return new TileDiskManager(par1, par2);
	}
	
}
