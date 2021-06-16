package me.ltxom.bindingofmc.common.config;

import io.github.noeppi_noeppi.libx.config.Config;
import io.github.noeppi_noeppi.libx.config.validator.IntRange;

public class LibXConfigHandler {

    @Config("Setting this to false will disable the reminder to use the new config")
    public static boolean _reminder = true;

    public static class World {
        @Config({"A", "B"})
        public static String surfaceSettings = "minecraft:bedrock,2*minecraft:dirt," +
                "minecraft:grass_block";

        @Config("C")
        @IntRange(min = 0, max = 256)
        public static int seaHeight = 63;

        @Config
        public static boolean disablePortalCreation = false;

        @Config
        public static String originDimension = "minecraft:overworld";

        @Config
        public static String worldTBOMID = "tbom:thebindingofminecraft";
    }


}
