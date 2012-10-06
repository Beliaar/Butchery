package butchery.common.items;

import butchery.common.CommonProxy;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class Hide extends Item {

	public Hide(int itemID) {
		super(itemID);
		this.maxStackSize = 64;
		setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}
}
