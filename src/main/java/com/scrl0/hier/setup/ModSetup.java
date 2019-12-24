package com.scrl0.hier.setup;

import com.scrl0.hier.blocks.ModBlocks;
import com.scrl0.hier.utility.MaterialType;
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

    }
}

