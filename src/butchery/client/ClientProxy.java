/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import butchery.common.CommonProxy;
import butchery.common.TileEntityTub;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCKS_PNG);
		MinecraftForgeClient.preloadTexture(TubRenderer.TUB_TEXTURE);

		TubRenderer renderer = new TubRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTub.class,
				renderer);

	}
}
