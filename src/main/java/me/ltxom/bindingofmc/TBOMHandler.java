package me.ltxom.bindingofmc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TBOMMain.MODID)
public class TBOMHandler {

	@SubscribeEvent
	public static void playerTick(TickEvent.PlayerTickEvent event) {
		PlayerEntity player = event.player;

		if (!(player.world instanceof ServerWorld))
			return;

		ServerWorld world = (ServerWorld) player.world;
		/* TODO
		if (!world.isRemote && !TBOMConfig.COMMON_CONFIG.disablePortalCreation.get() && event.phase == TickEvent.Phase.END ) {

			if (TBOMConfig.COMMON_CONFIG.adminOnlyPortals.get()) {
				if (world.getServer().getPermissionLevel(player.getGameProfile()) != 0) {

				}
			} else {

			}
		}

		 */
	}
}
