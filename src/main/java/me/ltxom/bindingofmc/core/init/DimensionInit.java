package me.ltxom.bindingofmc.core.init;

import me.ltxom.bindingofmc.TBOMMain;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class DimensionInit {
    public static final RegistryKey<DimensionType> TUTDIM_TYPE =
            RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY,
                    new ResourceLocation(TBOMMain.MODID, "tbomdim"));
    public static final RegistryKey<World> TUTDIM =
            RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
                    new ResourceLocation(TBOMMain.MODID, "tbomdim"));

}
