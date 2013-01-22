/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Recipe for tub transformations.
 * 
 * @author Beliar
 * 
 */
public class TubRecipe {

	public final ItemStack output;
	public final Object input;
	public final Object modifier;
	public final int maxAmountTransformed;
	public final int waterUsage;
	public final int ticksNeeded;

	public TubRecipe(ItemStack output, Object input, Object modifier,
			int maxAmountTransformed, int waterUsage, int ticksNeeded) {
		if ((!(input instanceof Item) && !(input instanceof Block))
				|| (!(modifier instanceof Item) && !(modifier instanceof Block))) {
			throw new RuntimeException("Invalid Tub Recipe");
		}
		this.output = output;
		this.input = input;
		this.modifier = modifier;
		this.maxAmountTransformed = maxAmountTransformed;
		this.waterUsage = waterUsage;
		this.ticksNeeded = ticksNeeded;
	}
}
