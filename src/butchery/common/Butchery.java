/**
* Copyright (c) Beliar, 2012
* https://github.com/Beliaar/Butchery
*
* Butchery is distributed under the terms of the Minecraft Mod Public
* License 1.0, or MMPL. Please check the contents of the license located in
* https://github.com/Beliaar/Butchery/wiki/License
*/
package butchery.common;

import java.util.ArrayList;
import java.util.Iterator;

import butchery.api.IButcherable;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityList;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.SpawnListEntry;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Beliar-Butchery", name="Butchery", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class Butchery {

	@Instance("Beliar-Butchery")
	public static Butchery instance;
	
	@SidedProxy(clientSide="butchery.client.ClientProxy", 
			serverSide="butchery.common.CommonProxy")	

	public static CommonProxy proxy;
	
	int StoneHuntingKnifeID;
	int IronHuntingKnifeID;
	int HuntingKnifeUsesStone;
	int HuntingKnifeUsesIron;
	int DeadCowID;
	int DeadPigID;
	int DeadSheepID;
	
	
	public static Item StoneHuntingKnife;
	public static Item IronHuntingKnife;
	public static Item DeadCow;
	public static Item DeadPig;
	public static Item DeadSheep;

	@PreInit
	public void preload(FMLPreInitializationEvent event){
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		
		config.load();
		
		StoneHuntingKnifeID = config.getOrCreateIntProperty(
				"StoneHuntingKnifeID", Configuration.CATEGORY_ITEM, 12000).getInt();
		IronHuntingKnifeID = config.getOrCreateIntProperty(
				"IronHuntingKnifeID", Configuration.CATEGORY_ITEM, 12001).getInt();
		HuntingKnifeUsesStone = config.getOrCreateIntProperty(
				"HuntingKnifeUsesStone", Configuration.CATEGORY_ITEM, 10).getInt();
		HuntingKnifeUsesIron = config.getOrCreateIntProperty(
				"HuntingKnifeUsesIron", Configuration.CATEGORY_ITEM, 25).getInt();
		DeadCowID = config.getOrCreateIntProperty(
				"DeadCowID", Configuration.CATEGORY_ITEM, 12002).getInt();
		DeadPigID = config.getOrCreateIntProperty(
				"DeadPigID", Configuration.CATEGORY_ITEM, 12003).getInt();
		DeadSheepID = config.getOrCreateIntProperty(
				"DeadSheepID", Configuration.CATEGORY_ITEM, 12004).getInt();
		
		config.save();
	}

	@Init	
	public void load(FMLInitializationEvent event){
		StoneHuntingKnife = new HuntingKnife(StoneHuntingKnifeID, HuntingKnifeUsesStone);
		StoneHuntingKnife.setItemName("ButcheryStoneHuntingKnife");
		StoneHuntingKnife.setIconIndex(0);
		IronHuntingKnife = new HuntingKnife(IronHuntingKnifeID, HuntingKnifeUsesIron);
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

		LanguageRegistry.addName(StoneHuntingKnife, "Stone Hunting Knife");
		LanguageRegistry.addName(IronHuntingKnife, "Iron Hunting Knife");
		LanguageRegistry.addName(DeadCow, "Dead Cow");
		LanguageRegistry.addName(DeadPig, "Dead Pig");
		LanguageRegistry.addName(DeadSheep, "Dead Sheep");
		
		GameRegistry.addRecipe(new ItemStack(StoneHuntingKnife, 1),new Object[]{
			"F",
			"S",
			'F', Item.flint,
			'S', Item.stick
		});
		GameRegistry.addRecipe(new ItemStack(IronHuntingKnife, 1),new Object[]{
			"I",
			"S",
			'I', Item.ingotIron,
			'S', Item.stick
		});

		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadCow));	
		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadPig));	
		GameRegistry.addRecipe(new ButcherRecipe((IButcherable) DeadSheep));	
		
		GameRegistry.registerCraftingHandler(new CraftingHandler());
				
		proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new EventHooks());
	}
	
}
