package net.pomegranits.prosperity.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pomegranits.prosperity.prosperity;
import net.pomegranits.prosperity.entity.ModEntityTypes;
import net.pomegranits.prosperity.entity.custom.KakapoEntity;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = prosperity.MOD_ID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = prosperity.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.KAKAPO.get(), KakapoEntity.setAttributes());
        }
    }
}