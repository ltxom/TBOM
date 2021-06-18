package me.ltxom.bindingofmc.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class TBOMEntity extends MonsterEntity implements IEntityAdditionalSpawnData {

    private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(),
            BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS);

    protected TBOMEntity(EntityType<? extends TBOMEntity> entity, World world) {
        super(entity, world);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public void readSpawnData(PacketBuffer buf) {
        prevRotationYaw = rotationYaw;
        prevRenderYawOffset = renderYawOffset = prevRotationYawHead = rotationYawHead;
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn,
                                            DifficultyInstance difficultyIn,
                                            SpawnReason reason,
                                            ILivingEntityData spawnDataIn,
                                            CompoundNBT dataTag) {
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    @Override
    public void setCustomName(ITextComponent name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {

    }

}
