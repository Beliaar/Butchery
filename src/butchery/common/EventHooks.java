/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class EventHooks {

	@ForgeSubscribe
	public void entityDropped(LivingDropsEvent event) {
		processButcherableAnimals(event);
	}

	/**
	 * This function checks if a mob that was killed is a butcherable animal and
	 * changes the drops of those.
	 */
	private void processButcherableAnimals(LivingDropsEvent event) {
		if (event.entityLiving.getClass() == EntityCow.class) {
			if (event.entityLiving.isBurning())
				return;
			event.drops.clear();
			event.entityLiving.dropItem(Butchery.DeadCow.itemID, 1);
		} else if (event.entityLiving.getClass() == EntitySheep.class) {
			if (event.entityLiving.isBurning())
				return;
			event.drops.clear();
			EntitySheep sheep = (EntitySheep) event.entityLiving;
			if (!sheep.getSheared()) {
				sheep.entityDropItem(new ItemStack(Block.cloth.blockID, 1,
						sheep.getFleeceColor()), 0.0F);
			}
			event.entityLiving.dropItem(Butchery.DeadSheep.itemID, 1);
		} else if (event.entityLiving.getClass() == EntityPig.class) {
			if (event.entityLiving.isBurning())
				return;
			event.drops.clear();
			event.entityLiving.dropItem(Butchery.DeadPig.itemID, 1);
		}
	}
}
