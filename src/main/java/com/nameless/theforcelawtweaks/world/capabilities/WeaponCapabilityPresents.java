package com.nameless.theforcelawtweaks.world.capabilities;

import com.nameless.theforcelawtweaks.gameasset.LOWSkills;
import com.nameless.theforcelawtweaks.gameasset.animation.TFLAnimations;
import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

import static com.nameless.theforcelawtweaks.main.TheForceLawTweaks.TFLLOGGER;

public class WeaponCapabilityPresents {
    public static final Function<Item, CapabilityItem.Builder> HANDHALFSWORD = (item) -> WeaponCapability.builder()
            .category(CapabilityItem.WeaponCategories.SWORD)
            .styleProvider((playerpatch) -> playerpatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.SWORD ? CapabilityItem.Styles.TWO_HAND : CapabilityItem.Styles.ONE_HAND)
            .collider(ColliderPreset.SWORD)
            .newStyleCombo(CapabilityItem.Styles.ONE_HAND,
                    TFLAnimations.HANDHALFSWORD_AUTO1,
                    TFLAnimations.HANDHALFSWORD_AUTO2,
                    TFLAnimations.HANDHALFSWORD_AUTO3,
                    TFLAnimations.HANDHALFSWORD_AUTO4,
                    TFLAnimations.HANDHALFSWORD_AUTO5,
                    TFLAnimations.HANDHALFSWORD_AUTO3,
                    TFLAnimations.HANDHALFSWORD_AUTO4,
                    TFLAnimations.HANDHALFSWORD_AUTO5,
                    TFLAnimations.HANDHALFSWORD_AUTO3,
                    TFLAnimations.HANDHALFSWORD_AUTO4,
                    TFLAnimations.HANDHALFSWORD_AUTO5,
                    TFLAnimations.HANDHALFSWORD_AUTO3,
                    TFLAnimations.HANDHALFSWORD_AUTO4,
                    TFLAnimations.HANDHALFSWORD_AUTO5,
                    TFLAnimations.HANDHALFSWORD_AUTO3,
                    TFLAnimations.HANDHALFSWORD_AUTO4,
                    TFLAnimations.HANDHALFSWORD_AUTO5,
                    TFLAnimations.HANDHALFSWORD_AUTO3,
                    TFLAnimations.HANDHALFSWORD_AUTO4,
                    TFLAnimations.HANDHALFSWORD_AUTO5,
                    TFLAnimations.HANDHALFSWORD_AUTO3,
                    TFLAnimations.HANDHALFSWORD_DASH,
                    TFLAnimations.HANDHALFSWORD_AIRSLASH)
            .innateSkill(CapabilityItem.Styles.ONE_HAND, itemStack -> LOWSkills.HAND_HALF_SWORD_HEAVY_ATTACK)
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

    public static final Function<Item, CapabilityItem.Builder> COLOSSALSWORD = (item) ->
            WeaponCapability.builder()
                    .category(CapabilityItem.WeaponCategories.GREATSWORD)
                    .styleProvider((playerpatch) -> CapabilityItem.Styles.TWO_HAND)
                    .collider(ColliderPreset.GREATSWORD)
                    .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND,
                            TFLAnimations.COLOSSALSWORD_AUTO1,
                            TFLAnimations.COLOSSALSWORD_AUTO2,
                            TFLAnimations.COLOSSALSWORD_AUTO3,
                            TFLAnimations.COLOSSALSWORD_AUTO4,
                            TFLAnimations.COLOSSALSWORD_AUTO5,
                            Animations.GREATSWORD_DASH,
                            Animations.GREATSWORD_AIR_SLASH)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, (itemstack) -> LOWSkills.COLOSSALSWORD_HEAVY_ATTACK)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, TFLAnimations.COLOSSALSWORD_IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_WALK_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_WALK_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.JUMP, Animations.BIPED_HOLD_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_HOLD_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_HOLD_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FLY, Animations.BIPED_HOLD_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CREATIVE_FLY, Animations.BIPED_HOLD_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CREATIVE_IDLE, Animations.BIPED_HOLD_GREATSWORD)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.GREATSWORD_GUARD);



    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation(TheForceLawTweaks.MODID,"handhalfsword"), HANDHALFSWORD);
        event.getTypeEntry().put(new ResourceLocation(TheForceLawTweaks.MODID,"colossalsword"), COLOSSALSWORD);
        TFLLOGGER.info("register weapon type");
    }
}
