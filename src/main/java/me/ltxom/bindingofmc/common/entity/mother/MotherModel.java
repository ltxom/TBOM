package me.ltxom.bindingofmc.common.entity.mother;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MotherModel extends EntityModel<MotherEntity> {
    public MotherModel() {
        textureWidth = 64;
        textureHeight = 64;
        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -15.0F, 0.0F);
        body.setTextureOffset(0, 34).addBox(-7.0F, 8.0F, -2.0F, 14.0F, 24.0F, 4.0F, 0.0F,
                false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -15.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

        headwear = new ModelRenderer(this);
        headwear.setRotationPoint(0.0F, -15.0F, 0.0F);
        headwear.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F,
                false);

        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(5.0F, -13.0F, 0.0F);
        right_arm.setTextureOffset(56, 13).addBox(-14.0F, 6.0F, -1.0F, 2.0F, 9.0F, 2.0F,
                0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(-5.0F, -13.0F, 0.0F);
        left_arm.setTextureOffset(56, 13).addBox(12.0F, 6.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F,
                true);

        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(2.0F, -6.0F, 0.0F);
        right_leg.setTextureOffset(56, 0).addBox(-5.0F, 23.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F
                , false);

        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(-2.0F, -6.0F, 0.0F);
        left_leg.setTextureOffset(56, 0).addBox(3.0F, 23.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F,
                true);
    }

    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer headwear;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_leg;

    @Override
    public void setRotationAngles(MotherEntity entity, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight,
                       int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        headwear.render(matrixStack, buffer, packedLight, packedOverlay);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}

