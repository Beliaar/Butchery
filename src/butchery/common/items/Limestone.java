package butchery.common.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import butchery.api.ITubWaterModifier;
import butchery.common.Butchery;
import butchery.common.CommonProxy;

public class Limestone extends Item implements ITubWaterModifier{

	public Limestone(int item_id) {
		super(item_id);
		this.maxStackSize = 64;
		setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}

	@Override
	public ItemStack getOutput(ItemStack input) {
		if (input.getItem() == Butchery.Hide) {
			return new ItemStack(Item.leather);
		}
		return null;
	}

	@Override
	public int getMaxAmountTransformed(ItemStack input) {
		if (input.getItem() == Butchery.Hide) {
			return 1;
		}
		return 0;
	}

	@Override
	public int getWaterUsage(ItemStack input) {
		if (input.getItem() == Butchery.Hide) {
			return 10;
		}
		return 0;
	}

	@Override
	public int getTicksNeeded(ItemStack input) {
		if (input.getItem() == Butchery.Hide) {
			return 2400;
		}
		return 0;
	}


}
