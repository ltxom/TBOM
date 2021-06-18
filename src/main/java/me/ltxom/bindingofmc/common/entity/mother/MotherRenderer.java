package me.ltxom.bindingofmc.common.entity.mother;

import me.ltxom.bindingofmc.TBOMMain;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class MotherRenderer extends MobRenderer<MotherEntity, MotherModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TBOMMain.MODID,
            "textures/entity/mother/mother.png");

    public MotherRenderer(EntityRendererManager manager) {
        super(manager, new MotherModel(), 0.5f);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(MotherEntity entity) {
        return TEXTURE;
    }
}
