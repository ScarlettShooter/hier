package com.scrl0.hier.setup;

import com.scrl0.hier.blocks.ModBlocks;
import com.scrl0.hier.utility.MaterialType;
import com.scrl0.hier.world.features.OreGen;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
    public ItemGroup itemGroup = new ItemGroup("hier") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(MaterialType.COPPER.getOre());
        }
    };

    public void init() {
        OreGen copper = new OreGen();
        copper.setupOreGen(MaterialType.COPPER.getOre(), 7, 5, 0, 0, 64);
        OreGen tin = new OreGen();
        tin.setupOreGen(MaterialType.TIN.getOre(), 7, 5, 0, 0, 64);
        OreGen aluminium = new OreGen();
        aluminium.setupOreGen(MaterialType.ALUMINIUM.getOre(), 7, 5, 0, 0, 64);
        OreGen silver = new OreGen();
        silver.setupOreGen(MaterialType.PLATINUM.getOre(), 7, 5, 0, 0, 64);
        OreGen titanium = new OreGen();
        titanium.setupOreGen(MaterialType.SILVER.getOre(), 7, 5, 0, 0, 64);
        OreGen platinum = new OreGen();
        platinum.setupOreGen(MaterialType.LEAD.getOre(), 7, 5, 0, 0, 64);
        OreGen zinc = new OreGen();
        zinc.setupOreGen(MaterialType.ZINC.getOre(), 7, 5, 0, 0, 64);
        OreGen nickel = new OreGen();
        nickel.setupOreGen(MaterialType.TITANIUM.getOre(), 7, 5, 0, 0, 64);
        OreGen chrome = new OreGen();
        chrome.setupOreGen(MaterialType.CHROME.getOre(), 7, 5, 0, 0, 64);
        OreGen lead = new OreGen();
        lead.setupOreGen(MaterialType.NICKEL.getOre(), 7, 5, 0, 0, 64);


    }
}

