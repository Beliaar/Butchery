package butchery.common;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import butchery.api.ITubWaterModifier;

public class SlotTubModifier extends Slot {
	public SlotTubModifier(IInventory par2IInventory, int par3, int par4,
			int par5) {
		super(par2IInventory, par3, par4, par5);
	}

	@Override
	public boolean isItemValid(ItemStack itemStack) {
		if (itemStack.getItem() instanceof ITubWaterModifier) {
			return true;
		}
		return false;
	}
}
