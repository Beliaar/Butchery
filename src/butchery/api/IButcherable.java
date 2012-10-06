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
 * Interface for items that can be butchered with the Hunting Knife.
 * 
 * @author Beliar
 * 
 */
public interface IButcherable {

	/**
	 * The primary output. This is the ItemStack that is visible in the crafting
	 * gui.
	 * 
	 * @return The ItemStack that will be the primary craft result.
	 */
	public ItemStack getPrimaryOutput();

	/**
	 * The secondary outputs. These will be the ItemStacks that will be put in
	 * the players inventory, or dropped at the players position if the
	 * inventory is full.
	 * 
	 * @return An Array of ItemStack objects that will be created as secondary
	 *         outputs.
	 */
	public ItemStack[] getSecondaryOutputs();
}
