/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common;

import butchery.api.IButcherable;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class DeadPig extends Item implements IButcherable {

	public DeadPig(int item_id) {
		super(item_id);
		maxStackSize = 64;
		this.setTabToDisplayOn(CreativeTabs.tabMisc);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}

	@Override
	public ItemStack getPrimaryOutput() {
		return new ItemStack(Item.leather, 1);
	}

	@Override
	public ItemStack[] getSecondaryOutputs() {
		return new ItemStack[] { new ItemStack(Item.porkRaw, 2) };
	}

}
