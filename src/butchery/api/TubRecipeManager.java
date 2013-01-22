/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class TubRecipeManager {

	private static final TubRecipeManager instance = new TubRecipeManager();

	private List<TubRecipe> recipes = new ArrayList<TubRecipe>();

	public static final TubRecipeManager getInstance() {
		return instance;
	}

	private TubRecipeManager() {
	}

	/**
	 * Adds an recipe to the manager.
	 * 
	 * @param recipe
	 *            The TubRecipe to add
	 */
	public void addRecipe(TubRecipe recipe) {
		this.recipes.add(recipe);
	}

	/**
	 * Adds an recipe to the manager.
	 * 
	 * @param output
	 *            The ItemStack that is created
	 * @param input
	 *            The Block or Item that can be transformed into the output
	 * @param modifier
	 *            The Block or Item that is consumed to transform the input.
	 * @param maxAmountTransformed
	 *            The maximum amount that can be transformed.
	 * @param waterUsage
	 *            The amount of water that is used up.
	 * @param ticksNeeded
	 *            The ticks that need to pass for the transformation.
	 */
	public void addRecipe(ItemStack output, Object input, Object modifier,
			int maxAmountTransformed, int waterUsage, int ticksNeeded) {
		addRecipe(new TubRecipe(output, input, modifier, maxAmountTransformed,
				waterUsage, ticksNeeded));
	}

	/**
	 * @return The list of the recipes.
	 */
	public List getRecipeList() {
		return this.recipes;
	}

	/**
	 * Gathers the inputs for the passed modifier.
	 * 
	 * @param modifier
	 *            The modifier
	 * @return A list of the Items and Blocks that this modifier can transform.
	 */
	public List getInputsForModifier(Object modifier) {
		List inputs = new ArrayList();
		for (TubRecipe recipe : this.recipes) {
			if (recipe.modifier == modifier) {
				inputs.add(recipe.input);
			}
		}
		return inputs;
	}

	/**
	 * 
	 * @return A list of the modifiers that are registered.
	 */
	public List getModifiers() {
		List modifiers = new ArrayList();
		for (TubRecipe recipe : this.recipes) {
			if (!modifiers.contains(recipe.modifier)) {
				modifiers.add(recipe.modifier);
			}
		}
		return modifiers;
	}

	/**
	 * Gets the specific recipe for the modifier and input.
	 * 
	 * @param modifier
	 *            An Block or Item
	 * @param input
	 *            An Block or Item
	 * @return The recipe or null
	 */
	public TubRecipe getRecipe(Object modifier, Object input) {
		for (TubRecipe recipe : this.recipes) {
			if (recipe.modifier == modifier && recipe.input == input) {
				return recipe;
			}
		}
		return null;
	}
}
