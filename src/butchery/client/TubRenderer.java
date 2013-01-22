/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import butchery.common.blocks.TileEntityTub;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TubRenderer extends TileEntitySpecialRenderer {

	public static String TUB_TEXTURE = "/butchery/tub.png";
	private ModelTub Model;

	public TubRenderer() {
		Model = new ModelTub();
	}

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y,
			double z, float var8) {
		renderTubModelAt((TileEntityTub) entity, x, y, z, var8);

	}

	public void renderTubModelAt(TileEntityTub entity, double x, double y,
			double z, float var8) {
		GL11.glPushMatrix();
		GL11.glTranslated(x - 0.5, y - 0.3125F, z - 0.44);
		GL11.glPushMatrix();
		bindTextureByName(TUB_TEXTURE);
		Model.renderModel(0.0625F);
		Model.renderWater(entity, 0.0625F, x, y, z);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
