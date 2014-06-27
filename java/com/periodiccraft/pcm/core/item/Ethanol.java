package com.periodiccraft.pcm.core.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.periodiccraft.pcm.PeriodicCraft;

public class Ethanol extends ItemFood
{
	public Ethanol(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation , isWolfFood);
		this.setTextureName(PeriodicCraft.MODID + ":ethanol");
		this.setMaxStackSize(8);
		
	}

	public void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 4));
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 600, 4));
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 4));
	}
}
