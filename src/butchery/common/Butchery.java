/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemReed;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import butchery.api.IButcherable;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Beliar-Butchery", name = "Butchery", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Butchery {

	@Instance("Beliar-Butchery")
	public static Butchery instance;

	@SidedProxy(clientSide = "butchery.client.ClientProxy", serverSide = "butchery.common.CommonProxy")
	public static CommonProxy proxy;

	int StoneHuntingKnifeID;
	int IronHuntingKnifeID;
	int HuntingKnifeUsesStone;
	int HuntingKnifeUsesIron;
	int DeadCowID;
	int DeadPigID;
	int DeadSheepID;
	int LimestoneID;
	int LimeID;
	int TubID;
	int TubItemID;

	public static Item StoneHuntingKnife;
	public static Item IronHuntingKnife;
	public static Item DeadCow;
	public static Item DeadPig;
	public static Item DeadSheep;
	public static Item Limestone;
	public static Item TubItem;
	public static Block Lime;
	public static Block Tub;

	@PreInit
	public void preload(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());

		config.load();

		StoneHuntingKnifeID = config.getOrCreateIntProperty(
				"StoneHuntingKnifeID", Configuration.CATEGORY_ITEM, 6000)
				.getInt();
		IronHuntingKnifeID = config.getOrCreateIntProperty(
				"IronHuntingKnifeID", Configuration.CATEGORY_ITEM, 6001)
				.getInt();
		HuntingKnifeUsesStone = config.getOrCreateIntProperty(
				"HuntingKnifeUsesStone", Configuration.CATEGORY_ITEM, 10)
				.getInt();
		HuntingKnifeUsesIron = config.getOrCreateIntProperty(
				"HuntingKnifeUsesIron", Configuration.CATEGORY_ITEM, 25)
				.getInt();
		DeadCowID = config.getOrCreateIntProperty("DeadCowID",
				Configuration.CATEGORY_ITEM, 6002).getInt();
		DeadPigID = config.getOrCreateIntProperty("DeadPigID",
				Configuration.CATEGORY_ITEM, 6003).getInt();
		DeadSheepID = config.getOrCreateIntProperty("DeadSheepID",
				Configuration.CATEGORY_ITEM, 6004).getInt();
		LimestoneID = config.getOrCreateIntProperty("LimestoneID",
				Configuration.CATEGORY_ITEM, 6005).getInt();
		LimeID = config.getOrCreateBlockIdProperty("LimeID", 2700).getInt();
		TubID = config.getOrCreateBlockIdProperty("TubID", 2701).getInt();
		TubItemID = config.getOrCreateIntProperty("TubItemID",
				Configuration.CATEGORY_ITEM, 6006).getInt();
		config.save();
	}

	@Init
	public void load(FMLInitializationEvent event) {
		StoneHuntingKnife = new HuntingKnife(StoneHuntingKnifeID,
				HuntingKnifeUsesStone);
		StoneHuntingKnife.setItemName("ButcheryStoneHuntingKnife");
		StoneHuntingKnife.setIconIndex(0);
		IronHuntingKnife = new HuntingKnife(IronHuntingKnifeID,
				HuntingKnifeUsesIron);
		IronHuntingKnife.setItemName("ButcheryIronHuntingKnife");
		IronHuntingKnife.setIconIndex(1);
		DeadCow = new DeadCow(DeadCowID);
		DeadCow.setItemName("ButcheryDeadCow");
		DeadCow.setIconIndex(2);
		DeadPig = new DeadPig(DeadPigID);
		DeadPig.setItemName("ButcheryDeadPig");
		DeadPig.setIconIndex(3);
		DeadSheep = new DeadSheep(DeadSheepID);
		DeadSheep.setItemName("ButcheryDeadSheep");
		DeadSheep.setIconIndex(4);
		Limestone = new Limestone(LimestoneID);
		Limestone.setItemName("Limestone");
		Limestone.setIconIndex(5);
		Lime = new Lime(LimeID, 0);
		Lime.setBlockName("Lime");
		Lime.setHardness(3.0f).setResistance(5.0f);
		Lime.setStepSound(Block.soundStoneFootstep);
		Tub = new Tub(TubID, TileEntityTub.class);
		Tub.setBlockName("Tub");
		Tub.setHardness(0.5f).setResistance(0.5f);
		TubItem = new ItemReed(TubItemID, Tub);
		TubItem.setIconCoord(6, 0).setTabToDisplayOn(CreativeTabs.tabTools);
		TubItem.setItemName("cauldron");
		TubItem.setTextureFile(CommonProxy.ITEMS_PNG);
		GameRegistry.registerBlock(Lime);
		GameRegistry.registerBlock(Tub);
		GameRegistry.registerTileEntity(TileEntityTub.class, "Tub");

		LanguageRegistry.addName(StoneHuntingKnife, "Stone Hunting Knife");
		LanguageRegistry.addName(IronHuntingKnife, "Iron Hunting Knife");
		LanguageRegistry.addName(DeadCow, "Dead Cow");
		LanguageRegistry.addName(DeadPig, "Dead Pig");
		LanguageRegistry.addName(DeadSheep, "Dead Sheep");
		LanguageRegistry.addName(Limestone, "Limestone");
		LanguageRegistry.addName(Lime, "Lime");
		LanguageRegistry.addName(TubItem, "Tub");

		GameRegistry.addRecipe(new ItemStack(StoneHuntingKnife, 1),
				new Object[] { "F", "S", 'F', Item.flint, 'S', Item.stick });
		GameRegistry
				.addRecipe(new ItemStack(IronHuntingKnife, 1), new Object[] {
						"I", "S", 'I', Item.ingotIron, 'S', Item.stick });

		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadCow));
		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadPig));
		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadSheep));
		
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		
		 NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

		proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new EventHooks());
		GameRegistry.registerWorldGenerator(new WorldGenerator());
	}

}
