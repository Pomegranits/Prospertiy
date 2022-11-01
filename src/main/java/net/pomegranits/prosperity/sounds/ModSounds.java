package net.pomegranits.prosperity.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pomegranits.prosperity.prosperity;

public class ModSounds{
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, prosperity.MOD_ID);

    public static final RegistryObject<SoundEvent> KAKAPO_AMBIENT =
            SOUNDS.register("kakapo_ambient", () -> new SoundEvent(new ResourceLocation(prosperity.MOD_ID, "kakapo_ambient")));
    public static final RegistryObject<SoundEvent> KAKAPO_HURT =
            SOUNDS.register("kakapo_hurt", () -> new SoundEvent(new ResourceLocation(prosperity.MOD_ID, "kakapo_hurt")));

    public static final RegistryObject<SoundEvent>  KAKAPO_DEATH =
            SOUNDS.register("kakapo_death", () -> new SoundEvent(new ResourceLocation(prosperity.MOD_ID, "kakapo_death")));


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(prosperity.MOD_ID)));
    }


    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
