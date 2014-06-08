package com.periodiccraft.pcm.core.guiblocks;

import java.util.Random;

import com.periodiccraft.pcm.PeriodicCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LQClass extends BlockContainer {

	private Random rand;
	private final boolean isActive;
	private static boolean keepInventory = true;
	
	
	
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
		
	
	
	public LQClass(boolean blockState) {
		super(Material.iron);
		rand = new Random();
		isActive = blockState;
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(PeriodicCraft.MODID + ":LiquidDi_side");
		this.iconFront = iconRegister.registerIcon(PeriodicCraft.MODID + ":" + (this.isActive ? "LiquidDi_front_Active" : "LiquidDi_front_Idle"));
		
		
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
		
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	
	
	
	
	private void setDefaultDirection(World world, int x, int y, int z) {
		
		if(!world.isRemote) {
			Block block1 = world.getBlock(x, y, z - 1);
			Block block2 = world.getBlock(x, y, z + 1);
			Block block3 = world.getBlock(x - 1, y, z);
			Block block4 = world.getBlock(x + 1, y, z);
			
			byte b = 3;
			
			if(block1.func_149730_j() && !block2.func_149730_j()) {
				b = 3;
			}
			if(block2.func_149730_j() && !block1.func_149730_j()) {
				b = 2;
			}
			if(block3.func_149730_j() && !block4.func_149730_j()) {
				b = 5;
			}
			if(block4.func_149730_j() && !block3.func_149730_j()) {
				b = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b, 2);
		}
		
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityPlayer, ItemStack itemstack) {	
		int i = MathHelper.floor_double((double)(entityPlayer.rotationYaw * 4.0F / 360F) + 0.5D) & 3;
		
		if(i == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(i == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(i == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(i == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if(itemstack.hasDisplayName()) {
			//((TileEntityLQ)world.getTileEntity(x, y, z)).setCustomName(itemstack.getDisplayName());
		}
	}
	
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(world.isRemote) 
		{
			return true;
		}
		else if(!player.isSneaking()) 
		{
			TileEntityLQ entity = (TileEntityLQ) world.getTileEntity(x, y, z);
			if(entity != null) {
				FMLNetworkHandler.openGui(player, PeriodicCraft.instance, PeriodicCraft.guiIDLQ, world, x, y, z);
								
			}
			return true;
			
		}
		else
		{
			return false;
		}
	}
		
		

	


	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityLQ();
	}

}
