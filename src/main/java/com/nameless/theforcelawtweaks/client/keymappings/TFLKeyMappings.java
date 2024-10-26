package com.nameless.theforcelawtweaks.client.keymappings;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import yesman.epicfight.client.input.EpicFightKeyMappings;

@Mod.EventBusSubscriber(value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TFLKeyMappings {
    public static final TFLKeyMapping BASIC_ATTACK = new TFLKeyMapping("key.tfl.attack", EpicFightKeyMappings.ATTACK.getKey().getValue(), "key.tfl.category");
    public static final TFLKeyMapping A = new TFLKeyMapping("key.tfl.a", GLFW.GLFW_KEY_A, "key.tfl.category");
    public static final TFLKeyMapping D = new TFLKeyMapping("key.tfl.d", GLFW.GLFW_KEY_D, "key.tfl.category");
    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(BASIC_ATTACK);
    }
}
