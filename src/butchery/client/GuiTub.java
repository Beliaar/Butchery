/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.client;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import butchery.common.blocks.ContainerTub;
import butchery.common.blocks.TileEntityTub;

/**
 * The Handler for drawing the tub inventory gui
 * 
 * @author Beliar
 * 
 */
public class GuiTub extends GuiContainer {

	private TileEntityTub tubEntity;

	public GuiTub(InventoryPlayer inventoryPlayer, TileEntityTub tubEntity) {
		// the container is instantiated and passed to the superclass for
		// handling
		super(new ContainerTub(inventoryPlayer, tubEntity));
		this.tubEntity = tubEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		// draw text and stuff here
		// the parameters for drawString are: string, x, y, color
		fontRenderer.drawString("Tub", 8, 6, 4210752);
		// draws "Inventory" or your regional equivalent
		fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		int texture = mc.renderEngine.getTexture("/butchery/gui/tub.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		int waterLevel = this.tubEntity.getWaterLevelScaled(53);
		this.drawTexturedModalRect(x + 66, y + 53 + 17 - waterLevel, 176, 23,
				3, waterLevel);
		int soakProgress = this.tubEntity.getSoakProgressScaled(18);
		this.drawTexturedModalRect(x + 75, y + 18 + 35 - soakProgress, 176,
				4 + 18 - soakProgress, 18, soakProgress);
	}

}
