/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class HuntingKnife extends Item {

	public HuntingKnife(int itemID, int maxDamage) {
		super(itemID);
		this.setMaxDamage(maxDamage);
		this.maxStackSize = 1;
		this.setTabToDisplayOn(CreativeTabs.tabTools);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}
}
