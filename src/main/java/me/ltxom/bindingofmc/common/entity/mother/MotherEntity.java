package me.ltxom.bindingofmc.common.entity.mother;

import me.ltxom.bindingofmc.common.entity.TBOMEntity;
import me.ltxom.bindingofmc.core.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class MotherEntity extends TBOMEntity implements IMob {

    public MotherEntity(EntityType<? extends TBOMEntity> entity, World world) {
        super(entity, world);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return TBOMEntity.createAttributes().createMutableAttribute(Attributes.ATTACK_DAMAGE
                , 8)
                .createMutableAttribute(Attributes.MAX_HEALTH, 20)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {

        playSound(SoundInit.ENTITY_MOTHER_HURT.get(rand.nextInt(3)).get(), 2, 1);
        return null;
    }
}
