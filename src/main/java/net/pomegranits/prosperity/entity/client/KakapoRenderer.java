package net.pomegranits.prosperity.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.pomegranits.prosperity.prosperity;
import net.pomegranits.prosperity.entity.custom.KakapoEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KakapoRenderer extends GeoEntityRenderer<KakapoEntity> {

    public KakapoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KakapoModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(KakapoEntity instance) {
        return new ResourceLocation(prosperity.MOD_ID, "textures/entity/kakapo.png");
    }

    @Override
    public RenderType getRenderType(KakapoEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}