package com.mrcackalacky.warriors.item;

import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.entity.WEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
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

    public static final RegistryObject<Item> GOLDEN_STEAK = ITEMS.register("golden_steak",
            () -> new Item(new Item.Properties().tab(WTab.WARRIORS).rarity(Rarity.RARE).food(WFood.GOLDEN_STEAK)));

    public static final RegistryObject<Item> GOLDEN_ETERNAL_STEAK = ITEMS.register("golden_eternal_steak",
            () -> new Item(new Item.Properties().tab(WTab.WARRIORS).rarity(Rarity.EPIC).food(WFood.GOLDEN_ETERNAL_STEAK)));

    public static final RegistryObject<Item> WARRIOR_SPAWN_EGG = ITEMS.register("warrior_spawn_egg",
            () -> new ForgeSpawnEggItem(WEntityTypes.WARRIOR, 0x737787, 0x0037ff,
                    new Item.Properties().tab(WTab.WARRIORS)));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

}
