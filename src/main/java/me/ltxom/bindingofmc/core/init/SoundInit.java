package me.ltxom.bindingofmc.core.init;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import me.ltxom.bindingofmc.TBOMMain;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TBOMMain.MODID);

    public static final RegistryObject<SoundEvent> ENTITY_MOTHER_HURT_1 = create("mother.hurt1");
    public static final RegistryObject<SoundEvent> ENTITY_MOTHER_HURT_2 = create("mother.hurt2");
    public static final RegistryObject<SoundEvent> ENTITY_MOTHER_HURT_3 = create("mother.hurt3");
    public static final ImmutableList<Supplier<SoundEvent>> ENTITY_MOTHER_HURT = ImmutableList.of(
            ENTITY_MOTHER_HURT_1::get,
            ENTITY_MOTHER_HURT_2::get,
            ENTITY_MOTHER_HURT_3::get
    );
    private static RegistryObject<SoundEvent> create(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(TBOMMain.MODID, name)));
    }
}
