package net.pomegranits.prosperity.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pomegranits.prosperity.prosperity;
import net.pomegranits.prosperity.entity.custom.KakapoEntity;

public class ModEntityTypes {
   public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, prosperity.MOD_ID);

    public static final RegistryObject<EntityType<KakapoEntity>> KAKAPO =
            ENTITY_TYPES.register("kakapo",
                () -> EntityType.Builder.of(KakapoEntity::new, MobCategory.CREATURE)
                        .sized(1.2f, 1.2f)
                        .build(new ResourceLocation(prosperity.MOD_ID, "kakapo").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
