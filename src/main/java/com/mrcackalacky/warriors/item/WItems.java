package com.mrcackalacky.warriors.item;

import com.mrcackalacky.warriors.Warriors;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Warriors.MOD_ID);

    public static final RegistryObject<Item> FLEX_DOLLAR = ITEMS.register("flexdollar",
            () -> new Item(new Item.Properties().tab(WTab.WARRIORS).stacksTo(1024)));

    public static final RegistryObject<Item> FLEX_COIN = ITEMS.register("flexcoin",
            () -> new Item(new Item.Properties().tab(WTab.WARRIORS).stacksTo(1024)));

    public static final RegistryObject<Item> GOLDEN_STEAK = ITEMS.register("goldensteak",
            () -> new Item(new Item.Properties().tab(WTab.WARRIORS).rarity(Rarity.EPIC).food(WFood.GOLDEN_STEAK)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

}
