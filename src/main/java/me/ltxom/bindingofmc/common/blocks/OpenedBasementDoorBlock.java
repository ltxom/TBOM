package me.ltxom.bindingofmc.common.blocks;

import me.ltxom.bindingofmc.common.dimension.TBOMTeleporter;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/*
 * Part of this class is from twilightforest
 * https://github.com/TeamTwilight/twilightforest
 * */
public class OpenedBasementDoorBlock extends CarpetBlock {

    public OpenedBasementDoorBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos,
                                  Entity entity) {
        attemptSendPlayer(entity);
    }

    public static void attemptSendPlayer(Entity entity) {
        if (!entity.isAlive() || entity.world.isRemote) {
            return;
        }

        if (entity.isPassenger() || entity.isBeingRidden() || !entity.canChangeDimension()) {
            return;
        }

        RegistryKey<World> destination = getDestination(entity);
        ServerWorld serverWorld = entity.getEntityWorld().getServer().getWorld(destination);

        if (serverWorld == null)
            return;

        if (entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;
            int x = player.getPosition().getX();
            int z = player.getPosition().getZ();
            TBOMTeleporter.teleport(player, serverWorld, new BlockPos(x, 200, z));
        }
    }

    private static RegistryKey<World> getDestination(Entity entity) {
        RegistryKey<World> tbomWorld = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
                new ResourceLocation("bindingofminecraft:tbomdim"));
        return !entity.getEntityWorld().getDimensionKey().getLocation().equals(tbomWorld.getLocation())
                ? tbomWorld : RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
                new ResourceLocation("minecraft:overworld"));
    }


}
