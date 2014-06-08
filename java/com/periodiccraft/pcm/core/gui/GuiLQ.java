package com.periodiccraft.pcm.core.gui;

import com.periodiccraft.pcm.PeriodicCraft;
import com.periodiccraft.pcm.core.guiblocks.TileEntityLQ;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiLQ extends GuiContainer 
{
	private ResourceLocation texture = new ResourceLocation(PeriodicCraft.MODID + ":" + "LiquidGUI");
	private TileEntityLQ LQ;
	
	public GuiLQ(InventoryPlayer invPlayer, TileEntityLQ teLQ) {
		super(new ContainerLQ(invPlayer, teLQ));
		LQ = teLQ;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.LQ.hasCustomInventoryName() ? this.LQ.getInventoryName() : I18n.format(this.LQ.getInventoryName());
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210712);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

		
	}

}
