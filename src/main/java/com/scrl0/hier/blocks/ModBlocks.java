package com.scrl0.hier.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("hier:copper_ore")
    public static Block copper_ore = new OreBlock("copper_ore", 1, 2, 2);
   @ObjectHolder("hier:tin_ore")
    public static Block tin_ore = new OreBlock("tin_ore", 1, 2, 2);
    @ObjectHolder("hier:aluminium_ore")
    public static Block aluminium_ore = new OreBlock("aluminium_ore", 2, 3, 3);
    @ObjectHolder("hier:generator")
    public static Block generator = new Generator();
}
