package com.periodiccraft.pcm.research;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.periodiccraft.pcm.PeriodicCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiResearch extends Gui {

	private final ResourceLocation Picture = new ResourceLocation(PeriodicCraft.MODID + ":research__background");
    private Minecraft mine; //f
    private int i; //g
    private int j; //h
    private String string; //i
    private String string1; //j
    private Achievement achievement; //k
    private long k; //l
    private RenderItem renderItem; //m
    private boolean Boolean; //n
    private static final String string2 = "CL_00000721";
    
    public GuiResearch(Minecraft minecraft) {
    	this.mine = minecraft;
    	this.renderItem = new RenderItem();
    	
    	
    }
    
    public void getAchievement(Achievement achievement1) {
        this.string = achievement1.func_150951_e().getUnformattedText();
        this.string1 = achievement1.getDescription();
        this.k = Minecraft.getSystemTime() + 2500L;
        this.achievement = achievement1;
        this.Boolean = true;
    }
    
    public void AchievementBuffer()
    {
        GL11.glViewport(0, 0, this.mine.displayWidth, this.mine.displayHeight);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        this.i = this.mine.displayWidth;
        this.j = this.mine.displayHeight;
        ScaledResolution scaledresolution = new ScaledResolution(this.mine.gameSettings, this.mine.displayWidth, this.mine.displayHeight);
        this.i = scaledresolution.getScaledWidth();
        this.j = scaledresolution.getScaledHeight();
        GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, (double)this.i, (double)this.j, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
	
    }
    
    public void func_146254_a()
    {
        if (this.achievement != null && this.k != 0L && Minecraft.getMinecraft().thePlayer != null)
        {
            double d0 = (double)(Minecraft.getSystemTime() - this.k) / 3000.0D;

            if (!this.Boolean)
            {
                if (d0 < 0.0D || d0 > 1.0D)
                {
                    this.k = 0L;
                    return;
                }
            }
            else if (d0 > 0.5D)
            {
                d0 = 0.5D;
            }

            this.AchievementBuffer();
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glDepthMask(false);
            double d1 = d0 * 2.0D;

            if (d1 > 1.0D)
            {
                d1 = 2.0D - d1;
            }

            d1 *= 4.0D;
            d1 = 1.0D - d1;

            if (d1 < 0.0D)
            {
                d1 = 0.0D;
            }

            d1 *= d1;
            d1 *= d1;
            int i = this.i - 160;
            int j = 0 - (int)(d1 * 36.0D);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            this.mine.getTextureManager().bindTexture(Picture);
            GL11.glDisable(GL11.GL_LIGHTING);
            this.drawTexturedModalRect(i, j, 96, 202, 160, 32);

            if (this.Boolean)
            {
                this.mine.fontRenderer.drawSplitString(this.string1, i + 30, j + 7, 120, -1);
            }
            else
            {
                this.mine.fontRenderer.drawString(this.string, i + 30, j + 7, -256);
                this.mine.fontRenderer.drawString(this.string1, i + 30, j + 18, -1);
            }

            RenderHelper.enableGUIStandardItemLighting();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glEnable(GL11.GL_LIGHTING);
            this.renderItem.renderItemAndEffectIntoGUI(this.mine.fontRenderer, this.mine.getTextureManager(), this.achievement.theItemStack, i + 8, j + 8);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
        }
    }

    public void NewAchievement()
    {
        this.achievement = null;
        this.k = 0L;
    
    }
}
