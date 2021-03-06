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
import net.minecraft.item.ItemStack;
import butchery.api.IButcherable;
import butchery.common.Butchery;
import butchery.common.CommonProxy;

public class DeadCow extends Item implements IButcherable {

	public DeadCow(int item_id) {
		super(item_id);
		this.maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}

	@Override
	public ItemStack getPrimaryOutput() {
		return new ItemStack(Butchery.Hide, 2);
	}

	@Override
	public ItemStack[] getSecondaryOutputs() {
		return new ItemStack[] { new ItemStack(Item.beefRaw, 3) };
	}

}
