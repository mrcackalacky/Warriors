package com.mrcackalacky.warriors.villager;

import com.google.common.collect.ImmutableSet;
import com.mrcackalacky.warriors.Warriors;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;
import org.spongepowered.tools.obfuscation.ObfuscationData;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class WVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Warriors.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.PROFESSIONS, Warriors.MOD_ID);

    public static final RegistryObject<PoiType> BANKER_POI = POI_TYPES.register("banker_poi",
            () -> new PoiType("banker_poi", PoiType.getBlockStates(Blocks.GOLD_BLOCK), 1, 1));

    public static final RegistryObject<VillagerProfession> BANKER =
            VILLAGER_PROFESSIONS.register("banker",
                    () -> new VillagerProfession("banker", BANKER_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CLERIC));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, BANKER_POI.get());
        }
        catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
