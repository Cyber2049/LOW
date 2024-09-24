package com.nameless.theforcelawtweaks.world.capabilities;

import com.nameless.theforcelawtweaks.gameasset.TFLAnimations;
import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

import static com.nameless.theforcelawtweaks.main.TheForceLawTweaks.TFLLOGGER;

public class WeaponCapabilityPresents {
    public static final Function<Item, CapabilityItem.Builder> HANDHALFSWORD = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(CapabilityItem.WeaponCategories.SWORD)
                .styleProvider((playerpatch) -> playerpatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD ? CapabilityItem.Styles.TWO_HAND : CapabilityItem.Styles.ONE_HAND)
                .collider(ColliderPreset.SWORD)
                .newStyleCombo(CapabilityItem.Styles.ONE_HAND, TFLAnimations.HANDHALFSWORD_AUTO1, TFLAnimations.HANDHALFSWORD_AUTO2, TFLAnimations.HANDHALFSWORD_AUTO3, TFLAnimations.HANDHALFSWORD_AUTO4, TFLAnimations.HANDHALFSWORD_AUTO5, TFLAnimations.HANDHALFSWORD_DASH, TFLAnimations.HANDHALFSWORD_AIRSLASH)
                .newStyleCombo(CapabilityItem.Styles.TWO_HAND, TFLAnimations.HANDHALFSWORD_DUAL_AUTO1, TFLAnimations.HANDHALFSWORD_DUAL_AUTO2, TFLAnimations.HANDHALFSWORD_DUAL_AUTO3, TFLAnimations.HANDHALFSWORD_DUAL_AUTO4, TFLAnimations.HANDHALFSWORD_DUAL_AUTO5, TFLAnimations.HANDHALFSWORD_DUAL_DASH, TFLAnimations.HANDHALFSWORD_DUAL_AIRSLASH)
                .newStyleCombo(CapabilityItem.Styles.MOUNT, Animations.SWORD_MOUNT_ATTACK)
                .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.BLOCK, Animations.SWORD_GUARD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_HOLD_DUAL_WEAPON)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_HOLD_DUAL_WEAPON)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_DUAL)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_HOLD_DUAL_WEAPON)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_DUAL_WEAPON)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FLOAT, Animations.BIPED_HOLD_DUAL_WEAPON)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FALL, Animations.BIPED_HOLD_DUAL_WEAPON)
                .weaponCombinationPredicator((entitypatch) -> EpicFightCapabilities.getItemStackCapability(entitypatch.getOriginal().getOffhandItem()).getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD);

        return builder;
    };

    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation(TheForceLawTweaks.MODID,"handhalfsword"), HANDHALFSWORD);
        TFLLOGGER.info("register weapon type");
    }
}
