/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import butchery.common.CommonProxy;

public class Bark extends Item {

	public Bark(int itemID) {
		super(itemID);
		this.maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}
}
