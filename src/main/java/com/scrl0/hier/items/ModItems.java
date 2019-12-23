package com.scrl0.hier.items;

import com.scrl0.hier.HiER;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {
    @ObjectHolder("hier:copper_ingot")
    public static Item copper_ingot = new Item(new Item.Properties().group(HiER.setup.itemGroup)).setRegistryName("copper_ingot");
    @ObjectHolder("hier:tin_ingot")
    public static Item tin_ingot = new Item(new Item.Properties().group(HiER.setup.itemGroup)).setRegistryName("tin_ingot");
    @ObjectHolder("hier:aluminium_ingot")
    public static Item aluminium_ingot = new Item(new Item.Properties().group(HiER.setup.itemGroup)).setRegistryName("aluminium_ingot");
}
