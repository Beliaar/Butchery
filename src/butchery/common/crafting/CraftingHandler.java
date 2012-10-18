/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common.crafting;

import net.minecraft.src.AchievementList;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import butchery.api.IButcherable;
import butchery.common.Butchery;
import butchery.common.items.HuntingKnife;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		if (item.itemID == Block.planks.blockID) {
			boolean found_wood = false;
			for (int i = 0; i < craftMatrix.getSizeInventory(); ++i) {
				ItemStack stack = craftMatrix.getStackInSlot(i);
				if (stack != null) {
					if (stack.itemID == Block.wood.blockID) {
						found_wood = true;
						break;
					}
				}
			}
			if (found_wood) {
				ItemStack barkStack = new ItemStack(Butchery.Bark);
				if (!player.inventory.addItemStackToInventory(barkStack)) {
					player.dropPlayerItem(barkStack);
				}
				return;
			}
		}
		butcher(player, item, craftMatrix);
	}

	/**
	 * This function handles the butchering.
	 * 
	 * If there is a hunting knife and a butcherable item in the crafting matrix
	 * it will add the secondary output to the players inventory, or drop it on
	 * the ground.
	 * 
	 * The primary output is already handled by the normal crafting.
	 */
	private void butcher(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		if (item.itemID == Item.leather.shiftedIndex) {
			player.addStat(AchievementList.killCow, 1);
		}
		ItemStack knife = null;
		int knifeSlot = -1;
		IButcherable skinable = null;
		for (int i = 0; i < craftMatrix.getSizeInventory(); ++i) {
			ItemStack stack = craftMatrix.getStackInSlot(i);
			if (stack != null) {
				if (stack.getItem() instanceof HuntingKnife) {
					knife = stack;
					knifeSlot = i;
				}
				if (stack.getItem() instanceof IButcherable) {
					skinable = (IButcherable) stack.getItem();
				}
			}
		}
		if (knife != null && skinable != null) {

			for (ItemStack output : skinable.getSecondaryOutputs()) {
				if (!player.inventory.addItemStackToInventory(output)) {
					player.dropPlayerItem(output);
				}
			}
			ItemStack stack_copy = new ItemStack(knife.getItem(), 2);
			stack_copy.damageItem(knife.getItemDamage() + 1, player);
			craftMatrix.setInventorySlotContents(knifeSlot, stack_copy);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
	}

}
