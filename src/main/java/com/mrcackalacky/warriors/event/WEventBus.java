package com.mrcackalacky.warriors.event;

import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.entity.WEntityTypes;
import com.mrcackalacky.warriors.entity.biped.WWarriorEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Warriors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WEventBus {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(WEntityTypes.WARRIOR.get(), WWarriorEntity.setAttributes());
    }
}
