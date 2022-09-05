package com.mrcackalacky.warriors.event;


import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.item.WItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Warriors.MOD_ID)
public class WTrade {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getTrades() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            
        }

        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.WHEAT, 16), 15, 1, 0.02F));

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.CARROT, 20), 15, 1, 0.02F));

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.POTATO, 22), 15, 1, 0.02F));

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.BEETROOT, 15), 15, 1, 0.02F));

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.PUMPKIN, 6), 15, 1, 0.02F));

            trades.get(3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.MELON, 4), 15, 1, 0.02F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.BEETROOT_SOUP, 1), 15, 1, 0.02F));

            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_COIN.get(), 1),
                    new ItemStack(Items.MUSHROOM_STEW, 1), 15, 1, 0.02F));

            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_DOLLAR.get(), 16),
                    new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1), 10, 8, 0.02F));

            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(WItems.FLEX_DOLLAR.get(), 1),
                    new ItemStack(Items.GOLDEN_APPLE, 4), 10, 8, 0.02F));
        }
    }

}
