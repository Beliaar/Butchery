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

public class HuntingKnife extends Item {

	public HuntingKnife(int itemID, int maxDamage) {
		super(itemID);
		setMaxDamage(maxDamage);
		this.maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}
}
