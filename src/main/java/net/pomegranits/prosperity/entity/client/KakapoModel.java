package net.pomegranits.prosperity.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.pomegranits.prosperity.prosperity;
import net.pomegranits.prosperity.entity.custom.KakapoEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KakapoModel extends AnimatedGeoModel<KakapoEntity> {
    @Override
    public ResourceLocation getModelResource(KakapoEntity object) {
        return new ResourceLocation(prosperity.MOD_ID, "geo/kakapo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KakapoEntity object) {
        return new ResourceLocation(prosperity.MOD_ID, "textures/entity/kakapo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KakapoEntity animatable) {
        return new ResourceLocation(prosperity.MOD_ID, "animations/kakapo.animation.json");
    }
}

