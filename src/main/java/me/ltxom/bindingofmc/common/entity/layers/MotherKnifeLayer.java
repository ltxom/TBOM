package me.ltxom.bindingofmc.common.entity.layers;


import com.mojang.blaze3d.matrix.MatrixStack;
import me.ltxom.bindingofmc.common.entity.mother.MotherEntity;
import me.ltxom.bindingofmc.common.entity.mother.MotherModel;
import me.ltxom.bindingofmc.core.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MotherKnifeLayer extends LayerRenderer<MotherEntity, MotherModel> {
    public MotherKnifeLayer(IEntityRenderer<MotherEntity, MotherModel> p_i50926_1_) {
        super(p_i50926_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
                       int packedLightIn, MotherEntity entitylivingbaseIn, float limbSwing,
                       float limbSwingAmount, float partialTicks, float ageInTicks,
                       float netHeadYaw, float headPitch) {
        matrixStackIn.push();
        ModelRenderer modelrenderer = this.getEntityModel().getRightArm();
        modelrenderer.translateRotate(matrixStackIn);
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180.0F));
        matrixStackIn.translate(-1.1875D, 1.0625D, -0.9375D);
        matrixStackIn.translate(0.5D, 0.5D, 0.5D);
        matrixStackIn.scale(0.5F, 0.5F, 0.5F);
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-90.0F));
        matrixStackIn.translate(-0.3D, -0.8D, -4.9D);
        renderHand(entitylivingbaseIn,
                ItemInit.MOTHER_KNIFE_ITEM.get().asItem().getDefaultInstance(),
                ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND,
                matrixStackIn, bufferIn, packedLightIn);

        matrixStackIn.pop();

    }

    private void renderHand(LivingEntity entity, ItemStack item,
                            ItemCameraTransforms.TransformType transformType,
                            MatrixStack matrixStack,
                            IRenderTypeBuffer iRenderTypeBuffer, int i) {
        Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(entity, item,
                transformType, false, matrixStack, iRenderTypeBuffer, i);

    }
}
