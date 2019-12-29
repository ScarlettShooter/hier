package com.scrl0.hier.world.features;

import com.scrl0.hier.utility.MaterialType;
import net.minecraft.block.Block;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeManager;

public class OreGen {
	public void setupOreGen(Block block, int size, int count, int bottomOffset, int topOffset, int maximum) {
		final CountRangeConfig blockConfig = new CountRangeConfig(count, bottomOffset, topOffset, maximum);
		BiomeManager.getBiomes(BiomeManager.BiomeType.WARM).forEach((BiomeManager.BiomeEntry biomeEntry) -> biomeEntry.biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
				new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MaterialType.COPPER.getOre().getDefaultState(), size)).func_227228_a_( Placement.COUNT_RANGE.func_227446_a_(blockConfig))));
	}
}
