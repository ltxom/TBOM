package me.ltxom.bindingofmc.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.ltxom.bindingofmc.common.entity.mother.MotherEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MotherModel extends SegmentedModel<MotherEntity> {
    public MotherModel() {
        super();
        textureWidth = 64;
        textureHeight = 64;
        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -15.0F, 0.0F);
        body.setTextureOffset(0, 34).addBox(-7.0F, 8.0F, -2.0F, 14.0F, 24.0F, 4.0F, 0.0F,
                false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -15.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

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
    private final ModelRenderer right_arm;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_leg;

    @Override
    public void setRotationAngles(MotherEntity entity, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.left_arm.rotateAngleX =
                -1.0F * MathHelper.func_233021_e_(limbSwing, 5.0F) * limbSwingAmount;
        this.right_arm.rotateAngleX =
                1.0F * MathHelper.func_233021_e_(limbSwing, 5.0F) * limbSwingAmount;
        this.left_arm.rotateAngleY = 0.0F;
        this.right_arm.rotateAngleY = 0.0F;
        this.left_leg.rotateAngleX =
                -1.0F * MathHelper.func_233021_e_(limbSwing, 5.0F) * limbSwingAmount;
        this.right_leg.rotateAngleX =
                1.0F * MathHelper.func_233021_e_(limbSwing, 5.0F) * limbSwingAmount;
        this.left_leg.rotateAngleY = 0.0F;
        this.right_leg.rotateAngleY = 0.0F;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight,
                       int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.head, this.body, this.left_arm, this.right_arm,
                this.left_leg, this.right_leg);
    }

    public ModelRenderer getRightArm() {
        return right_arm;
    }

}

