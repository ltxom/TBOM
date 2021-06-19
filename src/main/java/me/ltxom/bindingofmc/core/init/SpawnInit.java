package me.ltxom.bindingofmc.core.init;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.spawner.WorldEntitySpawner;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class SpawnInit {
    public static void registerSpawnPlacementTypes() {
        EntitySpawnPlacementRegistry.PlacementType.create("TBOMSPAWN",
                (t, pos, entityType) -> {
                    BlockState block = t.getBlockState(pos.down());
                    if (block.getBlock() == Blocks.BEDROCK || block.getBlock() == Blocks.BARRIER || !block.getMaterial().blocksMovement())
                        return false;
                    BlockState iblockstateUp = t.getBlockState(pos);
                    BlockState iblockstateUp2 = t.getBlockState(pos.up());
                    return WorldEntitySpawner.func_234968_a_(t, pos, iblockstateUp,
                            iblockstateUp.getFluidState(), entityType) && WorldEntitySpawner.func_234968_a_(t, pos.up(), iblockstateUp2, iblockstateUp2.getFluidState(), entityType);
                });
        EntitySpawnPlacementRegistry.PlacementType tbomSpawn =
                EntitySpawnPlacementRegistry.PlacementType.valueOf("TBOMSPAWN");
        if (tbomSpawn != null) {
            EntitySpawnPlacementRegistry.register(EntityInit.MOTHER,
                    EntitySpawnPlacementRegistry.PlacementType.ON_GROUND
                    , Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    MonsterEntity::canMonsterSpawnInLight);
        }
    }

    private static void registerEntityWorldSpawn(EntityType<?> entity, int spawnRate,
                                                 int minGroupSize, int maxGroupSize,
                                                 EntityClassification classification,
                                                 BiomeLoadingEvent event) {
        event.getSpawns().getSpawner(classification).add(new MobSpawnInfo.Spawners(entity,
                spawnRate, minGroupSize, maxGroupSize));
    }


    public static void onBiomeLoading(BiomeLoadingEvent event) {
        ResourceLocation biomeName = event.getName();
        if (biomeName == null) return;
        registerEntityWorldSpawn(EntityInit.MOTHER, 100, 1, 2, EntityClassification.MONSTER,
                event);
    }
}
