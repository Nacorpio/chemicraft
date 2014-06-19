package com.periodiccraft.pcm.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.periodiccraft.pcm.PeriodicCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class moleculartable extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon moleculartop;
	
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;
	
	
	public moleculartable() {
		super(Material.iron);
		this.setHardness(4.0F);
		this.setResistance(30.0F);
		this.setCreativeTab(PeriodicCraft.tabResearch);
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.moleculartop : this.blockIcon;
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(PeriodicCraft.MODID + ":molecularside");
		this.moleculartop = iconRegister.registerIcon(PeriodicCraft.MODID + ":moleculartop");
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c) {
		
		if(!player.isSneaking()) {
			player.openGui(PeriodicCraft.instance, PeriodicCraft.guiIDMolecularTable, world, x, y, z); 
			return true;
	    } else {
			return false;
		}
	}

}
