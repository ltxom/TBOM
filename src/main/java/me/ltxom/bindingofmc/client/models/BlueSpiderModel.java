// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports
package me.ltxom.bindingofmc.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.ltxom.bindingofmc.common.entity.bluespider.BlueSpiderEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class BlueSpiderModel extends EntityModel<BlueSpiderEntity> {
    private final ModelRenderer body;
    private final ModelRenderer bothleg1;
    private final ModelRenderer leg1;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer leg2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer bothleg2;
    private final ModelRenderer leg3;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer leg4;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer smallleg;
    private final ModelRenderer smallleg1;
    private final ModelRenderer smallleg2;

    public BlueSpiderModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(body, 0.0F, -1.5708F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
        body.setTextureOffset(12, 9).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
        body.setTextureOffset(0, 8).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

        bothleg1 = new ModelRenderer(this);
        bothleg1.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(bothleg1, 0.0F, -0.3927F, 0.0F);


        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(0.0F, -6.7017F, 4.5F);
        bothleg1.addChild(leg1);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(2.6942F, 0.0F, -9.0F);
        leg1.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, -1.1781F);
        cube_r1.setTextureOffset(14, 16).addBox(-8.062F, -5.4782F, 3.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(2.6942F, 0.0F, -9.0F);
        leg1.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
        cube_r2.setTextureOffset(18, 4).addBox(-3.3482F, 2.6188F, 3.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(0.0F, -6.7017F, 4.5F);
        bothleg1.addChild(leg2);
        setRotationAngle(leg2, 0.0F, 3.1416F, 0.0F);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(4.0F, 6.2017F, 0.0F);
        leg2.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.0F, -1.1781F);
        cube_r3.setTextureOffset(0, 16).addBox(-2.8321F, -9.0579F, 3.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(4.0F, 6.2017F, 0.0F);
        leg2.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, 0.0F, 0.7854F);
        cube_r4.setTextureOffset(18, 2).addBox(-8.6569F, -0.8431F, 3.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        bothleg2 = new ModelRenderer(this);
        bothleg2.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(bothleg2, 0.0F, -2.8362F, 0.0F);


        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(0.0F, -6.7017F, 4.5F);
        bothleg2.addChild(leg3);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-4.0F, 6.2017F, 0.0F);
        leg3.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.0F, -1.1781F);
        cube_r5.setTextureOffset(14, 14).addBox(0.2294F, -1.6669F, -4.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-4.0F, 6.2017F, 0.0F);
        leg3.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, 0.0F, 0.7854F);
        cube_r6.setTextureOffset(18, 0).addBox(-3.0F, -6.5F, -4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(0.0F, -6.7017F, 4.5F);
        bothleg2.addChild(leg4);
        setRotationAngle(leg4, 0.0F, 3.1416F, 0.0F);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(4.0F, 6.2017F, 0.0F);
        leg4.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.0F, 0.0F, -1.1781F);
        cube_r7.setTextureOffset(0, 14).addBox(-2.8321F, -9.0579F, 4.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(4.0F, 6.2017F, 0.0F);
        leg4.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
        cube_r8.setTextureOffset(0, 18).addBox(-8.6569F, -0.8431F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        smallleg = new ModelRenderer(this);
        smallleg.setRotationPoint(0.0F, 24.0F, 0.0F);


        smallleg1 = new ModelRenderer(this);
        smallleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        smallleg.addChild(smallleg1);
        smallleg1.setTextureOffset(6, 18).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        smallleg1.setTextureOffset(12, 18).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        smallleg2 = new ModelRenderer(this);
        smallleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
        smallleg.addChild(smallleg2);
        smallleg2.setTextureOffset(0, 3).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        smallleg2.setTextureOffset(0, 0).addBox(1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
    }

    /**
     * Sets this entity's model rotation angles
     *
     * @param entityIn
     * @param limbSwing
     * @param limbSwingAmount
     * @param ageInTicks
     * @param netHeadYaw
     * @param headPitch
     */
    @Override
    public void setRotationAngles(BlueSpiderEntity entityIn, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        bothleg1.render(matrixStack, buffer, packedLight, packedOverlay);
        bothleg2.render(matrixStack, buffer, packedLight, packedOverlay);
        smallleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}