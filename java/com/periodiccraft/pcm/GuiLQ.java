package com.periodiccraft.pcm;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiLQ extends GuiContainer 
{
	private ResourceLocation texture = new ResourceLocation(PeriodicCraft.MODID + ":" + "LiquidGUI");
	private TileEntityLQ LQ;
	
	public GuiLQ(InventoryPlayer invPlayer, TileEntityLQ teLQ) {
		super(/* new ContainerLQ(invPlayer, teLQ) */null);
		LQ = teLQ;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

		
	}

}
