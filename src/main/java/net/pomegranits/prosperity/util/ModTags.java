package net.pomegranits.prosperity.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pomegranits.prosperity.prosperity;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> RIMU_LOGS
                = tag("rimu_logs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(prosperity.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }

    public static class Items {
        public static final TagKey<Item> RIMU_LOGS
                = tag("rimu_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(prosperity.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }



    }
}
