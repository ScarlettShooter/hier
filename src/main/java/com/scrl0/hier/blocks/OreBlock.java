package com.scrl0.hier.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OreBlock extends Block {
    public OreBlock(int harvestLevel, float hardness, float resistance) {
        super(Properties.create(Material.ROCK)
        .sound(SoundType.STONE)
        .harvestTool(ToolType.PICKAXE)
        .harvestLevel(harvestLevel)
        .hardnessAndResistance(hardness, resistance));

    }
}
