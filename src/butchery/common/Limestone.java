package butchery.common;

import butchery.api.ITubWaterModifier;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class Limestone extends Item {

	public Limestone(int item_id) {
		super(item_id);
		maxStackSize = 64;
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}


}
