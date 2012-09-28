package butchery.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class Limestone extends Item {
	
	public Limestone(int item_id){
		super(item_id);
		maxStackSize = 64;
		this.setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	public String getTextureFile(){
		return CommonProxy.ITEMS_PNG;
	}	
	
}
