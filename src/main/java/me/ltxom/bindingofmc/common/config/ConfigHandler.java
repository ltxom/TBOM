package me.ltxom.bindingofmc.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import me.ltxom.bindingofmc.TBOMMain;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ConfigHandler {

    public static final ForgeConfigSpec COMMON_CONFIG;
    private static final ForgeConfigSpec.Builder COMMON_BUILDER =
            new ForgeConfigSpec.Builder();

    static {
        init(COMMON_BUILDER);
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static ForgeConfigSpec.ConfigValue<String> generationSettings;
    public static ForgeConfigSpec.IntValue seaHeight;
    public static ForgeConfigSpec.BooleanValue disablePortalCreation;
    public static ForgeConfigSpec.ConfigValue<String> originDimension;
    public static ForgeConfigSpec.ConfigValue<String> worldTBOMID;

    public static void init(ForgeConfigSpec.Builder builder) {
        generationSettings = builder.comment("A",
                "B")
                .define("world.surface-settings", "minecraft:bedrock,2*minecraft:dirt," +
                        "minecraft:grass_block", String.class::isInstance);
        seaHeight = builder.comment("C [default: 63]")
                .defineInRange("world.sea-level", 63, 0, 256);
        disablePortalCreation = builder.comment("Should server disable portal creation? [default: false]")
                .define("world.disable-portal-creation", false);
        originDimension = builder.
                comment("The dimension you can always travel to the Twilight Forest from, as well as the dimension you will return to. Defaults to the overworld. (domain:regname).").
                define("originDimension", "minecraft:overworld");
        worldTBOMID = builder.
                comment("Destination dimension for TBOM Portals").
                define("worldTBOMID", "tbom:thebindingofminecraft");
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        TBOMMain.LOGGER.debug("Loading config file {}", path);
        final CommentedFileConfig configData =
                CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }

}
