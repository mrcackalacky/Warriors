package com.mrcackalacky.warriors.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;

public class WFood {

    public static final FoodProperties GOLDEN_STEAK = new FoodProperties.Builder().nutrition(20).saturationMod(0.9f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 8000, 3), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 8000, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 2000, 4), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5000, 1), 1.0F)
            .build();
}
