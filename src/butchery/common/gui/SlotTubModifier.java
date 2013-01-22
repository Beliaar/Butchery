/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import butchery.api.TubRecipeManager;

public class SlotTubModifier extends Slot {
	public SlotTubModifier(IInventory par2IInventory, int par3, int par4,
			int par5) {
		super(par2IInventory, par3, par4, par5);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return TubRecipeManager.getInstance().getModifiers()
				.contains(itemStack.getItem());
	}
}
