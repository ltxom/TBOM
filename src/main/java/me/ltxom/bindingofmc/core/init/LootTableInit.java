package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.TBOMMain;
import net.minecraft.util.ResourceLocation;

public class LootTableInit {
    public static final ResourceLocation MOTHER = register("entities/mother");
    private static ResourceLocation register(String id) {
        return new ResourceLocation(TBOMMain.MODID, id);
    }
}
