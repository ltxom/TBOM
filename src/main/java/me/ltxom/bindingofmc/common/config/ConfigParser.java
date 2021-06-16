package me.ltxom.bindingofmc.common.config;

import me.ltxom.bindingofmc.TBOMMain;
import me.ltxom.bindingofmc.common.util.TBOMPaths;

import java.io.IOException;
import java.nio.file.Files;

// remove 1.17
public class ConfigParser {

    public static void checkConfig() {
        if (!LibXConfigHandler._reminder) {
            return;
        }

        if (!TBOMMain.oldConfig) {
            LibXConfigHandler._reminder = false;
        } else {
            applyOldConfig();
        }
        deleteOldConfigFile();
    }

    public static void deleteOldConfigFile() {
        try {
            Files.deleteIfExists(TBOMPaths.MOD_CONFIG.resolve("config.toml"));
        } catch (IOException e) {
            TBOMMain.LOGGER.error("config/skyblockbuilder/config.toml could not be deleted");
        }
    }

    public static void applyOldConfig() {
        LibXConfigHandler.World.surfaceSettings = ConfigHandler.generationSettings.get();
        LibXConfigHandler.World.seaHeight = ConfigHandler.seaHeight.get();
        LibXConfigHandler.World.disablePortalCreation = ConfigHandler.disablePortalCreation.get();
        LibXConfigHandler.World.originDimension = ConfigHandler.originDimension.get();
        LibXConfigHandler.World.worldTBOMID = ConfigHandler.worldTBOMID.get();

    }

}
