package com.mrcackalacky.warriors.item;

import com.mrcackalacky.warriors.Warriors;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Warriors.MOD_ID);

    public static final RegistryObject<Item> FLEX_DOLLAR = ITEMS.register("flexdollar",
            () -> new Item(new Item.Properties().tab(WTab.WARRIORS)));

    public static final RegistryObject<Item> FLEX_COIN = ITEMS.register("flexcoin",
            () -> new Item(new Item.Properties().tab(WTab.WARRIORS)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

}