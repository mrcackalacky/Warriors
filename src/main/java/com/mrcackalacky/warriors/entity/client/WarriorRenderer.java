package com.mrcackalacky.warriors.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.mrcackalacky.warriors.Warriors;
import com.mrcackalacky.warriors.entity.biped.WWarriorEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.example.client.DefaultBipedBoneIdents;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;

public class WarriorRenderer extends ExtendedGeoEntityRenderer<WWarriorEntity> {
    public WarriorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WarriorModel());
        this.shadowRadius = 0.5f;
    }


    @Override
    public ResourceLocation getTextureLocation(WWarriorEntity instance) {
        return new ResourceLocation(Warriors.MOD_ID, "textures/entity/warrior/the_warrior.png");
    }
    private static final ResourceLocation TEXTURE = new ResourceLocation(Warriors.MOD_ID,
            "textures/entity/warrior/the_warrior.png");
    private static final ResourceLocation MODEL_RESLOC = new ResourceLocation(Warriors.MOD_ID,
            "geo/the_warrior.geo.json");

    @Override
    protected ItemStack getHeldItemForBone(String boneName, WWarriorEntity currentEntity) {
        switch (boneName) {
            case DefaultBipedBoneIdents.LEFT_HAND_BONE_IDENT:
                return currentEntity.isLeftHanded() ? mainHand : offHand;
            case DefaultBipedBoneIdents.RIGHT_HAND_BONE_IDENT:
                return currentEntity.isLeftHanded() ? offHand : mainHand;
            case DefaultBipedBoneIdents.POTION_BONE_IDENT:
                break;
        }
        return null;
    }

    @Override
    protected ItemTransforms.TransformType getCameraTransformForItemAtBone(ItemStack boneItem, String boneName) {
        switch (boneName) {
            case DefaultBipedBoneIdents.LEFT_HAND_BONE_IDENT:
                return ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND;
            case DefaultBipedBoneIdents.RIGHT_HAND_BONE_IDENT:
                return ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND;
            default:
                return ItemTransforms.TransformType.NONE;
        }
    }

    @Override
    protected void preRenderItem(PoseStack stack, ItemStack item, String boneName, WWarriorEntity currentEntity,
                                 IBone bone) {
        if (item == this.mainHand || item == this.offHand) {
            stack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
            boolean shieldFlag = item.getItem() instanceof ShieldItem;
            if (item == this.mainHand) {
                if (shieldFlag) {
                    stack.translate(0.0, 0.125, -0.25);
                } else {

                }
            } else {
                if (shieldFlag) {
                    stack.translate(0, 0.125, 0.25);
                    stack.mulPose(Vector3f.YP.rotationDegrees(180));
                } else {

                }

            }
             stack.mulPose(Vector3f.YP.rotationDegrees(180));

             stack.scale(0.75F, 0.75F, 0.75F);
        }
    }

    @Override
    protected void postRenderItem(PoseStack matrixStack, ItemStack item, String boneName,
                                  WWarriorEntity currentEntity, IBone bone) {

    }

    @Override
    protected ItemStack getArmorForBone(String boneName, WWarriorEntity currentEntity) {
        switch (boneName) {
            case "armorBipedLeftFoot":
            case "armorBipedRightFoot":
            case "armorBipedLeftFoot2":
            case "armorBipedRightFoot2":
                return boots;
            case "armorBipedLeftLeg":
            case "armorBipedRightLeg":
            case "armorBipedLeftLeg2":
            case "armorBipedRightLeg2":
                return leggings;
            case "armorBipedBody":
            case "armorBipedRightArm":
            case "armorBipedLeftArm":
                return chestplate;
            case "armorBipedHead":
                return helmet;
            default:
                return null;
        }
    }

    @Override
    protected EquipmentSlot getEquipmentSlotForArmorBone(String boneName, WWarriorEntity currentEntity) {
        switch (boneName) {
            case "armorBipedLeftFoot":
            case "armorBipedRightFoot":
            case "armorBipedLeftFoot2":
            case "armorBipedRightFoot2":
                return EquipmentSlot.FEET;
            case "armorBipedLeftLeg":
            case "armorBipedRightLeg":
            case "armorBipedLeftLeg2":
            case "armorBipedRightLeg2":
                return EquipmentSlot.LEGS;
            case "armorBipedRightArm":
                return !currentEntity.isLeftHanded() ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            case "armorBipedLeftArm":
                return currentEntity.isLeftHanded() ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            case "armorBipedBody":
                return EquipmentSlot.CHEST;
            case "armorBipedHead":
                return EquipmentSlot.HEAD;
            default:
                return null;
        }
    }

    @Override
    protected ModelPart getArmorPartForBone(String name, HumanoidModel<?> armorModel) {
        switch (name) {
            case "armorBipedLeftFoot":
            case "armorBipedLeftLeg":
            case "armorBipedLeftFoot2":
            case "armorBipedLeftLeg2":
                return armorModel.leftLeg;
            case "armorBipedRightFoot":
            case "armorBipedRightLeg":
            case "armorBipedRightFoot2":
            case "armorBipedRightLeg2":
                return armorModel.rightLeg;
            case "armorBipedRightArm":
                return armorModel.rightArm;
            case "armorBipedLeftArm":
                return armorModel.leftArm;
            case "armorBipedBody":
                return armorModel.body;
            case "armorBipedHead":
                return armorModel.head;
            default:
                return null;
        }
    }

    @Override
    protected BlockState getHeldBlockForBone(String boneName, WWarriorEntity currentEntity) {
        return null;
    }

    @Override
    protected void preRenderBlock(PoseStack stack, BlockState block, String boneName,
                                  WWarriorEntity currentEntity) {

    }

    @Override
    protected void postRenderBlock(PoseStack stack, BlockState block, String boneName,
                                   WWarriorEntity currentEntity) {
    }

    protected final ResourceLocation CAPE_TEXTURE = new ResourceLocation(Warriors.MOD_ID,
            "textures/entity/extendedrendererentity_cape.png");

    @Override
    protected ResourceLocation getTextureForBone(String boneName, WWarriorEntity currentEntity) {
        switch (boneName) {
            case "bipedCape":
                return CAPE_TEXTURE;
            default:
                return null;
        }
    }

    @Override
    protected boolean isArmorBone(GeoBone bone) {
        return bone.getName().startsWith("armor");
    }

    @Override
    public RenderType getRenderType(WWarriorEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.5F, 1.5F, 1.5F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
