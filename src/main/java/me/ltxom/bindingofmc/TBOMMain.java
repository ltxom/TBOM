package me.ltxom.bindingofmc;

import io.github.noeppi_noeppi.libx.mod.registration.ModXRegistration;
import me.ltxom.bindingofmc.common.config.ConfigHandler;
import me.ltxom.bindingofmc.common.config.ConfigParser;
import me.ltxom.bindingofmc.common.entity.mother.MotherRenderer;
import me.ltxom.bindingofmc.common.util.TBOMPaths;
import me.ltxom.bindingofmc.core.init.BlockInit;
import me.ltxom.bindingofmc.core.init.EntityInit;
import me.ltxom.bindingofmc.core.init.ItemInit;
import me.ltxom.bindingofmc.core.init.SoundInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;

@Mod(TBOMMain.MODID)
public class TBOMMain extends ModXRegistration {
    public static TBOMMain instance;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "bindingofminecraft";
    public static final ItemGroup ITEM_GROUP = new TheBindingOfMinecraftGroup(
            "bindingofminecraft");
    public static boolean oldConfig;

    public TBOMMain() {
        super(MODID, null);
        instance = this;
        // config
        oldConfig = Files.exists(TBOMPaths.MOD_CONFIG.resolve("config.toml"));
        TBOMPaths.createDirectories();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON,
                ConfigHandler.COMMON_CONFIG, "TBOM/config.toml");
        ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG,
                FMLPaths.CONFIGDIR.get().resolve("TBOM/config.toml"));

        ConfigParser.checkConfig();

        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        iEventBus.addListener(this::setup);

        ItemInit.ITEMS.register(iEventBus);
        BlockInit.BLOCKS.register(iEventBus);
        SoundInit.SOUNDS.register(iEventBus);
        EntityInit.register();

        iEventBus.<FMLCommonSetupEvent>addListener(this::init);
        iEventBus.<FMLClientSetupEvent>addListener(this::init);
        iEventBus.<FMLLoadCompleteEvent>addListener(this::init);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void init(final FMLCommonSetupEvent event) {

    }

    private void init(FMLLoadCompleteEvent event) {
        EntityInit.initializeAttributes();
        ItemInit.initializeDispenserBehaviors();
    }

    private void init(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOTHER,
                MotherRenderer::new);
    }

    protected void setup(final FMLCommonSetupEvent event) {

    }

    @Override
    protected void clientSetup(FMLClientSetupEvent fmlClientSetupEvent) {

    }

    public static class TheBindingOfMinecraftGroup extends ItemGroup {
        public TheBindingOfMinecraftGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack createIcon() {
            return ItemInit.KEY_TO_BASEMENT_ITEM.get().getDefaultInstance();
        }
    }

}
