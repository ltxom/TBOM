package me.ltxom.bindingofmc.client.renderers;

import me.ltxom.bindingofmc.TBOMMain;
import me.ltxom.bindingofmc.client.models.BlueSpiderModel;
import me.ltxom.bindingofmc.common.entity.bluespider.BlueSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class BlueSpiderRenderer extends MobRenderer<BlueSpiderEntity, BlueSpiderModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TBOMMain.MODID,
            "textures/entity/spider/bluespider.png");

    public BlueSpiderRenderer(EntityRendererManager manager) {
        super(manager, new BlueSpiderModel(), 0.5f);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(BlueSpiderEntity entity) {
        return TEXTURE;
    }

}