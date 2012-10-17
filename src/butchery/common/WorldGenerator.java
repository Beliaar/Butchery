/**
 * Copyright (c) Beliar, 2012
 * https://github.com/Beliaar/Butchery
 *
 * Butchery is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://github.com/Beliaar/Butchery/wiki/License
 */
package butchery.common;

import java.util.Random;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.isHellWorld) {
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		} else {
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNether(World world, Random random, int blockX,
			int blockZ) {
	}

	private void generateBlocks(World world, Random random, int blockX,
			int blockZ) {
		for (int i = 0; i < 20; ++i) {
			int coordX = blockX + random.nextInt(16);
			int coordY = random.nextInt(128);
			int coordZ = blockZ + random.nextInt(16);
			WorldGenMinable limeBlock = new WorldGenMinable(
					Butchery.Lime.blockID, 10);
			limeBlock.generate(world, random, coordX, coordY, coordZ);
		}
	}

	private void generateSurface(World world, Random random, int blockX,
			int blockZ) {
		generateBlocks(world, random, blockX, blockZ);
	}

}
