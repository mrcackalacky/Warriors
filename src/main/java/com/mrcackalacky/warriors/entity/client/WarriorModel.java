package com.mrcackalacky.warriors.entity.client;

import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.entity.biped.WWarriorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WarriorModel extends AnimatedGeoModel<WWarriorEntity> {

    @Override
    public ResourceLocation getModelLocation(WWarriorEntity object) {
        return new ResourceLocation(Warriors.MOD_ID, "geo/the_warrior.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WWarriorEntity object) {
        return new ResourceLocation(Warriors.MOD_ID, "textures/entity/warrior/the_warrior.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WWarriorEntity animatable) {
        return new ResourceLocation(Warriors.MOD_ID, "animations/the_warrior.animation.json");
    }
}
