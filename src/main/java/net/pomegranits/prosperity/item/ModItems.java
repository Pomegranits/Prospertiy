package net.pomegranits.prosperity.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pomegranits.prosperity.prosperity;
import net.pomegranits.prosperity.entity.ModEntityTypes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, prosperity.MOD_ID);

    public static final RegistryObject<Item> KAKAPO_FEATHER = ITEMS.register("kakapo_feather",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> KAKAPO_SPAWN_EGG = ITEMS.register("kakapo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KAKAPO, 0x4f7824, 0x947d2f,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
