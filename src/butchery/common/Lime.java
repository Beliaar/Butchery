package butchery.common;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class Lime extends Block {
	
	public Lime(int block_id, int texture_id) {
		super(block_id, texture_id, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public String getTextureFile(){
		return CommonProxy.BLOCKS_PNG;
	}
	
    public int idDropped(int par1, Random par2Random, int par3) {
    	return Butchery.Limestone.shiftedIndex;
    }
    
    public int quantityDropped(Random par1Random) {
    	return 4;
    }
	
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
        {
            int var3 = par2Random.nextInt(par1 + 2) - 1;

            if (var3 < 0)
            {
                var3 = 0;
            }

            return this.quantityDropped(par2Random) * (var3 + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }
    
    public void dropBlockAsItemWithChance(
    		World par1World, int par2, int par3, int par4, int par5,
    		float par6, int par7) {
    	super.dropBlockAsItemWithChance(
    			par1World, par2, par3, par4, par5, par6, par7);
    	this.dropXpOnBlockBreak(par1World, par2, par3, par4, 1);
    }

}