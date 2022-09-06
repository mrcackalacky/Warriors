package com.mrcackalacky.warriors.entity;

import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.entity.biped.WWarriorEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Warriors.MOD_ID);

    public static final RegistryObject<EntityType<WWarriorEntity>> WARRIOR = ENTITY_TYPES.register("warrior",
            () -> EntityType.Builder.of(WWarriorEntity::new, MobCategory.CREATURE)
                    .sized(1.0F, 1.0F)
                    .build(new ResourceLocation(Warriors.MOD_ID, "warrior").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
