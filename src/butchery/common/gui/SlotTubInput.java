/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common.gui;

import java.util.List;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import butchery.api.TubRecipeManager;

public class SlotTubInput extends Slot {
	public SlotTubInput(IInventory par2IInventory, int par3, int par4, int par5) {
		super(par2IInventory, par3, par4, par5);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		ItemStack modifierStack = inventory.getStackInSlot(0);
		if (modifierStack == null) {
			return false;
		}
		List inputs = TubRecipeManager.getInstance().getInputsForModifier(
				modifierStack.getItem());

		return (inputs.contains(itemStack.getItem()));
	}
}
