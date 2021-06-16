package me.ltxom.bindingofmc.common.util;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TBOMPaths {
    public static final Path MOD_CONFIG = FMLPaths.CONFIGDIR.get().resolve("TBOM");

    public static void createDirectories() {
        try {
            Files.createDirectories(MOD_CONFIG);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create default directories.", e);
        }
    }


}
