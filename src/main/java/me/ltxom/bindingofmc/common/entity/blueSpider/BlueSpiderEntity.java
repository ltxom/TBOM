package me.ltxom.bindingofmc.common.entity.blueSpider;
import me.ltxom.bindingofmc.common.entity.TBOMEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class BlueSpiderEntity extends TBOMEntity {

  public BlueSpiderEntity(
      EntityType<? extends TBOMEntity> entity, World world) {
    super(entity, world);
  }

  public static AttributeModifierMap.MutableAttribute createAttributes() {
    return TBOMEntity.createAttributes().createMutableAttribute(Attributes.ATTACK_DAMAGE
        , 8)
        .createMutableAttribute(Attributes.MAX_HEALTH, 6.5)
        .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
  }
}
