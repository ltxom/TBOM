package me.ltxom.bindingofmc;

import me.ltxom.bindingofmc.common.config.LibXConfigHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
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

        if (!world.isRemote && !LibXConfigHandler.World.disablePortalCreation && event
                .phase == TickEvent.Phase.END) {
            checkForPortalCreation(player, world);
        }
    }

    private static void checkForPortalCreation(PlayerEntity player, World world) {
        if (world.getDimensionKey().getLocation().equals(new ResourceLocation(LibXConfigHandler.World.originDimension))
                || world.getDimensionKey().getLocation().toString().equals(LibXConfigHandler.World.worldTBOMID)) {


        }
    }

}
