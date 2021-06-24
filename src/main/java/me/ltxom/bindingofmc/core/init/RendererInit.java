package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.client.renderers.BlueSpiderRenderer;
import me.ltxom.bindingofmc.client.renderers.MotherRenderer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RendererInit {
    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOTHER,
                MotherRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BLUE_SPIDER,
                BlueSpiderRenderer::new);
    }
}
