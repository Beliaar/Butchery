/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.api;

import net.minecraft.src.ItemStack;

/**
 * Interface for items that can modify the water in a tub.
 * 
 * @author Beliar
 * 
 */

public interface ITubWaterModifier {

	/**
	 * Returns the ItemStack the input will be transformed to with this
	 * modifier.
	 * 
	 * @param input
	 *            The ItemStack that is in the input slot
	 * 
	 * @return The ItemStack the input will be transformed to.
	 */
	public ItemStack getOutput(ItemStack input);

	/**
	 * Returns the amount of items that can be transformed.
	 * 
	 * @param input
	 *            The ItemStack that is in the input slot
	 * @return
	 */
	public int getMaxAmountTransformed(ItemStack input);

	/**
	 * Returns the amount of water used to transform the input
	 * 
	 * @param input
	 *            The ItemStack that is in the input slot
	 * @return The amount of water used to transform the input
	 */
	public int getWaterUsage(ItemStack input);

	/**
	 * Returns the ticks needed to transform an input to the output.
	 * 
	 * @param input
	 *            The ItemStack that is in the input slot
	 * @return The ticks that the game has to advance by.
	 */
	public int getTicksNeeded(ItemStack input);

}
