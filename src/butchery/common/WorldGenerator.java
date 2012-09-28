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
		switch(world.provider.worldType){
			case 0: generateSurface(world, random, chunkX*16, chunkZ*16); break;
			case -1: generateNether(world, random, chunkX*16, chunkZ*16); break;
		}	
	}

	private void generateNether(
			World world, Random random, int blockX, int blockZ) {
	}

	private void generateBlocks(World world, Random random, int blockX,
			int blockZ) {
		for (int i=0; i < 20; ++i) {
            int coordX = blockX + random.nextInt(16);
            int coordY = random.nextInt(128);
            int coordZ = blockZ + random.nextInt(16);
			WorldGenMinable limeBlock = new WorldGenMinable(
					Butchery.Lime.blockID, 10);
			limeBlock.generate(world, random, coordX, coordY, coordZ);
        }
	}

	private void generateSurface(
			World world, Random random, int blockX, int blockZ) {
        generateBlocks(world, random, blockX, blockZ);
	}

}
