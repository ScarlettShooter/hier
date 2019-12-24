package com.scrl0.hier.blocks;

import com.scrl0.hier.HiER;
import com.scrl0.hier.utility.MaterialType;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.scrl0.hier.HiER.setup;

public class ModBlocks {
    static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();
    /*Ores*/
    @ObjectHolder(HiER.MOD_ID + ":copper_ore")
    public static Block copper_ore = new OreBlock("copper_ore", 0, 2, 2);
    /*@ObjectHolder(HiER.MOD_ID + ":tin_ore")
    public static Block tin_ore = new OreBlock("tin_ore", 0, 2, 2);
    @ObjectHolder(HiER.MOD_ID + ":silver_ore")
    public static Block silver_ore = new OreBlock("silver_ore", 1, 3, 2);
    @ObjectHolder(HiER.MOD_ID + ":zinc_ore")
    public static Block zinc_ore = new OreBlock("zinc_ore", 1, 3, 2);
    @ObjectHolder(HiER.MOD_ID + ":aluminium_ore")
    public static Block aluminium_ore = new OreBlock("aluminium_ore", 1, 3, 3);
    @ObjectHolder(HiER.MOD_ID + ":chrome_ore")
    public static Block chrome_ore = new OreBlock("chrome_ore", 1, 3, 2);
    @ObjectHolder(HiER.MOD_ID + ":lead_ore")
    public static Block lead_ore = new OreBlock("lead_ore", 2, 4, 7);
    @ObjectHolder(HiER.MOD_ID + ":nickel_ore")
    public static Block nickel_ore = new OreBlock("nickel_ore", 2, 3, 2);
    @ObjectHolder(HiER.MOD_ID + ":platinum_ore")
    public static Block platinum_ore = new OreBlock("platinum_ore", 2, 3, 3);
    @ObjectHolder(HiER.MOD_ID + ":titanium_ore")
    public static Block titanium_ore = new OreBlock("titanium_ore", 2, 3, 2);
     */
    /*Generators*/
    @ObjectHolder(HiER.MOD_ID + ":generator")
    public static Block generator = new Generator("generator", 1, 4, 4);

    private void registerAll() {
        register("copper_ore", copper_ore);
        register("generator", generator);

    }

    private void register(String name, Block block)  {
        Item.Properties properties = new Item.Properties().group(setup.itemGroup);
        BLOCKS_TO_REGISTER.put(name, new BlockItem(block, properties));
    }

    foreach(MaterialType.getOre()) {
        BLOCKS_TO_REGISTER.put(MaterialType.getType() + "_ore", new BlockItem(block, properties));
    }

}
