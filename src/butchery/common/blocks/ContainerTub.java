/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common.blocks;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import butchery.common.gui.SlotTubInput;
import butchery.common.gui.SlotTubModifier;
import butchery.common.gui.SlotTubOutput;

public class ContainerTub extends Container {

	protected TileEntityTub tubEntity;

	public ContainerTub(InventoryPlayer inventoryPlayer, TileEntityTub entity) {
		this.tubEntity = entity;
		addSlotToContainer(new SlotTubModifier(entity, 0, 76, 54));
		addSlotToContainer(new SlotTubInput(entity, 1, 76, 18));
		addSlotToContainer(new SlotTubOutput(entity, 2, 114, 37));
		bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tubEntity.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack()) {
			SlotTubModifier modifierSlot;
			modifierSlot = (SlotTubModifier) inventorySlots.get(0);
			SlotTubInput inputSlot = (SlotTubInput) inventorySlots.get(1);
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			if (slot != 0 && slot != 1 && slot != 2) {
				if (modifierSlot != null && modifierSlot.isItemValid(stack)) {
					if (!mergeItemStack(stackInSlot, 0, 1, true)) {
						return null;
					}
				} else if (inputSlot != null && inputSlot.isItemValid(stack)) {
					if (!mergeItemStack(stackInSlot, 1, 2, true)) {
						return null;
					}
				} else {
					return null;
				}

			} else if (!mergeItemStack(stackInSlot, 3, 39, false)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}
		}

		return stack;
	}
}
