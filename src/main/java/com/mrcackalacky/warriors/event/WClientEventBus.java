package com.mrcackalacky.warriors.event;

import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.entity.WEntityTypes;
import com.mrcackalacky.warriors.entity.client.WarriorRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Warriors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WClientEventBus {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event){
        EntityRenderers.register(WEntityTypes.WARRIOR.get(), WarriorRenderer::new);
    }
}
