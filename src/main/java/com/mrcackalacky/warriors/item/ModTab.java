package com.mrcackalacky.warriors.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab {
    public static final CreativeModeTab WARRIORS = new CreativeModeTab("warriors") {
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FLEX_DOLLAR.get());
        }
    };
}
