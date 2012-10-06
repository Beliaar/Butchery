package butchery.common;

import butchery.api.ITubWaterModifier;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class Limestone extends Item implements ITubWaterModifier {

	public Limestone(int item_id) {
		super(item_id);
		maxStackSize = 64;
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}

	@Override
	public ItemStack getOutput(ItemStack input) {
		if (input.getItem().getClass() == DeadCow.class) {
			return new ItemStack(Item.leather, 1);
		}
		return null;
	}

	@Override
	public int getMaxAmountTransformed(ItemStack input) {
		if (input.getItem().getClass() == DeadCow.class) {
			return Math.min(2, input.stackSize);
		}
		return 0;
	}

	@Override
	public int getTicksNeeded(ItemStack input) {
		return 100;
	}

	@Override
	public int getWaterUsage(ItemStack input) {
		if (input.getItem().getClass() == DeadCow.class) {
			return 10;
		}
		return 0;
	}

}
