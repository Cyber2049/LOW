package com.nameless.theforcelawtweaks.client.mobs.cowdevil.oringal;

import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import com.nameless.theforcelawtweaks.world.entity.CowDevilEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CowDevilEntityRenderer extends MobRenderer<CowDevilEntity, CowDevilModel<CowDevilEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(TheForceLawTweaks.MODID, "textures/entities/cow_devil.png");
    public CowDevilEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new CowDevilModel(), 1);
    }

    @Override
    public ResourceLocation getTextureLocation(CowDevilEntity p_114482_) {
        return TEXTURE;
    }
}
