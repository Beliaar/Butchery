package butchery.common.gui;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import butchery.api.ITubWaterModifier;

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
		ITubWaterModifier modifierItem = (ITubWaterModifier) modifierStack
				.getItem();
		return (modifierItem.getOutput(itemStack) != null);
	}
}
