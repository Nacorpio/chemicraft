package com.periodiccraft.pcm.core.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.periodiccraft.pcm.PeriodicCraft;



public class GuiMolecularTable extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(PeriodicCraft.MODID + ":" + "molecular_crafting_table");
	public GuiMolecularTable(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerMolecularTable(invPlayer, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Molecular Table"), 100, 5, 0x000000);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float i, int j, int k) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		
	}

}
