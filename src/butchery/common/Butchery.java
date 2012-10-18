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
import butchery.api.TubRecipeManager;
import butchery.common.blocks.Lime;
import butchery.common.blocks.TileEntityTub;
import butchery.common.blocks.Tub;
import butchery.common.crafting.ButcherRecipe;
import butchery.common.crafting.CraftingHandler;
import butchery.common.gui.GuiHandler;
import butchery.common.items.Bark;
import butchery.common.items.DeadCow;
import butchery.common.items.DeadPig;
import butchery.common.items.DeadSheep;
import butchery.common.items.Hide;
import butchery.common.items.HuntingKnife;
import butchery.common.items.LimedHide;
import butchery.common.items.Limestone;
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
	int HideID;
	int BarkID;
	int LimedHideID;

	public static Item StoneHuntingKnife;
	public static Item IronHuntingKnife;
	public static Item DeadCow;
	public static Item DeadPig;
	public static Item DeadSheep;
	public static Item Limestone;
	public static Item TubItem;
	public static Item Hide;
	public static Item Bark;
	public static Item LimedHide;
	public static Block Lime;
	public static Block Tub;

	@PreInit
	public void preload(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());

		config.load();

		StoneHuntingKnifeID = config.get(Configuration.CATEGORY_ITEM,
				"StoneHuntingKnifeID", 6000).getInt();
		IronHuntingKnifeID = config.get(Configuration.CATEGORY_ITEM,
				"IronHuntingKnifeID", 6001).getInt();
		HuntingKnifeUsesStone = config.get(Configuration.CATEGORY_ITEM,
				"HuntingKnifeUsesStone", 10).getInt();
		HuntingKnifeUsesIron = config.get(Configuration.CATEGORY_ITEM,
				"HuntingKnifeUsesIron", 25).getInt();
		DeadCowID = config.get(Configuration.CATEGORY_ITEM, "DeadCowID", 6002)
				.getInt();
		DeadPigID = config.get(Configuration.CATEGORY_ITEM, "DeadPigID", 6003)
				.getInt();
		DeadSheepID = config.get(Configuration.CATEGORY_ITEM, "DeadSheepID",
				6004).getInt();
		LimestoneID = config.get(Configuration.CATEGORY_ITEM, "LimestoneID",
				6005).getInt();
		LimeID = config.get(Configuration.CATEGORY_BLOCK, "LimeID", 2700)
				.getInt();
		TubID = config.get(Configuration.CATEGORY_BLOCK, "TubID", 2701)
				.getInt();
		TubItemID = config.get(Configuration.CATEGORY_ITEM, "TubItemID", 6006)
				.getInt();
		HideID = config.get(Configuration.CATEGORY_ITEM, "HideID", 6007)
				.getInt();
		BarkID = config.get(Configuration.CATEGORY_ITEM, "BarkID", 6008)
				.getInt();
		LimedHideID = config.get(Configuration.CATEGORY_ITEM, "LimedHideID",
				6009).getInt();
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
		TubItem.setIconIndex(6).setCreativeTab(CreativeTabs.tabTools);
		TubItem.setItemName("cauldron");
		TubItem.setTextureFile(CommonProxy.ITEMS_PNG);
		Hide = new Hide(HideID);
		Hide.setIconIndex(7);
		Hide.setItemName("Hide");
		Bark = new Bark(BarkID);
		Bark.setIconIndex(9);
		Bark.setItemName("Bark");
		LimedHide = new LimedHide(LimedHideID);
		LimedHide.setIconIndex(8);
		LimedHide.setItemName("LimedHide");
		
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
		LanguageRegistry.addName(Hide, "Hide");
		LanguageRegistry.addName(Bark, "Bark");
		LanguageRegistry.addName(LimedHide, "Limed Hide");

		GameRegistry.addRecipe(new ItemStack(StoneHuntingKnife, 1),
				new Object[] { "F", "S", 'F', Item.flint, 'S', Item.stick });
		GameRegistry
				.addRecipe(new ItemStack(IronHuntingKnife, 1), new Object[] {
						"I", "S", 'I', Item.ingotIron, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(TubItem, 1), new Object[] { "W W",
				"W W", "WWW", 'W', Block.planks });

		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadCow));
		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadPig));
		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadSheep));

		GameRegistry.registerCraftingHandler(new CraftingHandler());

		TubRecipeManager.getInstance().addRecipe(new ItemStack(Item.leather),
				Hide, Limestone, 1, 10, 2400);

		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

		proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new EventHooks());
		GameRegistry.registerWorldGenerator(new WorldGenerator());
	}

}
