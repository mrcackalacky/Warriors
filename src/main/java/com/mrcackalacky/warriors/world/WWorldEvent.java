package com.mrcackalacky.warriors.world;

import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.world.gen.WEntityGen;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Warriors.MOD_ID)
public class WWorldEvent {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        WEntityGen.onEntitySpawn(event);
    }
}
