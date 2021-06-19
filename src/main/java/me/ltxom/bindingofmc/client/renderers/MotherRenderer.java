package me.ltxom.bindingofmc.client.renderers;

import me.ltxom.bindingofmc.TBOMMain;
import me.ltxom.bindingofmc.client.layers.MotherKnifeLayer;
import me.ltxom.bindingofmc.client.models.MotherModel;
import me.ltxom.bindingofmc.common.entity.mother.MotherEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MotherRenderer extends MobRenderer<MotherEntity, MotherModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TBOMMain.MODID,
            "textures/entity/mother/mother.png");

    public MotherRenderer(EntityRendererManager manager) {
        super(manager, new MotherModel(), 0.5f);
        this.addLayer(new MotherKnifeLayer(this));
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(MotherEntity entity) {
        return TEXTURE;
    }
}
