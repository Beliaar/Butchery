/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common.crafting;

import butchery.api.IButcherable;
import butchery.common.Butchery;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

/**
 * The recipe for butchering with the HuntingKnife
 * 
 * The main logic for butchering is in the CraftingHandler
 * 
 * @author Beliar
 * 
 */
public class ButcherRecipe implements IRecipe {

	private IButcherable butcherable;

	public ButcherRecipe(IButcherable argButcherable) {
		this.butcherable = argButcherable;
	}

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		boolean foundKnife = false;
		boolean foundItem = false;
		int itemsfound = 0;
		for (int i = 0; i < var1.getSizeInventory(); ++i) {
			ItemStack stack = var1.getStackInSlot(i);
			if (stack != null) {
				++itemsfound;
				if (stack.itemID == Butchery.StoneHuntingKnife.shiftedIndex
						|| stack.itemID == Butchery.IronHuntingKnife.shiftedIndex) {
					foundKnife = true;
				}
				if (stack.getItem().getClass() == this.butcherable.getClass()) {
					foundItem = true;
				}
			}
		}
		return (foundKnife && foundItem && itemsfound <= 2);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		ItemStack recipeOutput = getRecipeOutput();
		return new ItemStack(recipeOutput.itemID, recipeOutput.stackSize,
				recipeOutput.getItemDamage());
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.butcherable.getPrimaryOutput();
	}

}
