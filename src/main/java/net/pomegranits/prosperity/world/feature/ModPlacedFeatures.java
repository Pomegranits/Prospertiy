package net.pomegranits.prosperity.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.pomegranits.prosperity.prosperity;


public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, prosperity.MOD_ID);


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}