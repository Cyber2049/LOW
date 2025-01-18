package com.nameless.theforcelawtweaks.main;

import com.mojang.logging.LogUtils;
import com.nameless.theforcelawtweaks.client.mobs.cowdevil.oringal.CowDevilEntityRenderer;
import com.nameless.theforcelawtweaks.gameasset.Armatures;
import com.nameless.theforcelawtweaks.gameasset.animation.TFLAnimations;
import com.nameless.theforcelawtweaks.world.capabilities.WeaponCapabilityPresents;
import com.nameless.theforcelawtweaks.world.entity.BossEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;

@Mod(TheForceLawTweaks.MODID)
public class TheForceLawTweaks
{
    public static final String MODID = "theforcelawtweaks";
    public static final Logger TFLLOGGER = LogUtils.getLogger();

    public TheForceLawTweaks()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BossEntities.ENTITIES.register(bus);
        bus.addListener(this::rendererRegister);
        bus.addListener(BossEntities::registerAttributes);
        bus.addListener(TFLAnimations::registerAnimations);
        bus.addListener(WeaponCapabilityPresents::register);
        bus.addListener(Armatures::build);
    }

    @OnlyIn(Dist.CLIENT)
    public void rendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BossEntities.COWDEVIL.get(), CowDevilEntityRenderer::new);
    }


}
