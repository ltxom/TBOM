package me.ltxom.bindingofmc;

import me.ltxom.bindingofmc.core.init.BlockInit;
import me.ltxom.bindingofmc.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TBOMMain.MODID)
public class TBOMMain {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "bindingofminecraft";
	public static final ItemGroup ITEM_GROUP = new TheBindingOfMinecraftGroup("bindingofminecraft");

	public TBOMMain() {
		IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		iEventBus.addListener(this::setup);

		ItemInit.ITEMS.register(iEventBus);
		BlockInit.BLOCKS.register(iEventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	public static class TheBindingOfMinecraftGroup extends ItemGroup {
		public TheBindingOfMinecraftGroup(String label) {
			super(label);
		}

		@Override
		public ItemStack createIcon() {
			return ItemInit.TEST_ITEM.get().getDefaultInstance();
		}
	}

}
