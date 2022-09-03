package com.mrcackalacky.warriors.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class WTab {
    public static final CreativeModeTab WARRIORS = new CreativeModeTab("warriors") {
        public ItemStack makeIcon() {
            return new ItemStack(WItems.FLEX_DOLLAR.get());
        }
    };
}
