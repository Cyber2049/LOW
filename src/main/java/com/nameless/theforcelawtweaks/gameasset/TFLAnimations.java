package com.nameless.theforcelawtweaks.gameasset;

import com.mojang.datafixers.util.Pair;
import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.skill.BasicAttack;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.ComboCounterHandleEvent;

import java.util.List;

public class TFLAnimations {
    public static StaticAnimation HANDHALFSWORD_AUTO1;
    public static StaticAnimation HANDHALFSWORD_AUTO2;
    public static StaticAnimation HANDHALFSWORD_AUTO3;
    public static StaticAnimation HANDHALFSWORD_AUTO4;
    public static StaticAnimation HANDHALFSWORD_AUTO5;
    public static StaticAnimation HANDHALFSWORD_DASH;
    public static StaticAnimation HANDHALFSWORD_HEAVY_ATTACK1;
    public static StaticAnimation HANDHALFSWORD_HEAVY_ATTACK2;
    public static StaticAnimation HANDHALFSWORD_AIRSLASH;
    public static StaticAnimation HANDHALFSWORD_DUAL_AUTO1;
    public static StaticAnimation HANDHALFSWORD_DUAL_AUTO2;
    public static StaticAnimation HANDHALFSWORD_DUAL_AUTO3;
    public static StaticAnimation HANDHALFSWORD_DUAL_AUTO4;
    public static StaticAnimation HANDHALFSWORD_DUAL_AUTO5;
    public static StaticAnimation HANDHALFSWORD_DUAL_DASH;
    public static StaticAnimation HANDHALFSWORD_DUAL_AIRSLASH;
    public static StaticAnimation SQUAREOFF_ON;
    public static StaticAnimation SQUAREOFF_OFF;

    public static StaticAnimation SQUAREOFF_LOOP;
    public static StaticAnimation SQUAREOFF_WALK;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(TheForceLawTweaks.MODID, TFLAnimations::build);
    }

    public static void build(){
        HumanoidArmature biped = Armatures.BIPED;
        //hand half sword
        //one hand
        HANDHALFSWORD_AUTO1 = new BasicAttackAnimation(0.1F, 0.46F, 0.56F, 0.58F, null, biped.toolR, "biped/combat/handhalfsword_auto1", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F));
        HANDHALFSWORD_AUTO2 = new BasicAttackAnimation(0.05F, 0.4F, 0.6F, 0.67F, null, biped.toolR, "biped/combat/handhalfsword_auto2", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_AUTO3 = new BasicAttackAnimation(0.05F, 0.4F, 0.6F, 0.67F, null, biped.toolR, "biped/combat/handhalfsword_auto3", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_AUTO4 = new BasicAttackAnimation(0.05F, 0.37F, 0.53F, 0.67F, null, biped.toolR, "biped/combat/handhalfsword_auto4", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_AUTO5 = new BasicAttackAnimation(0.05F, 0.53F, 0.76F, 0.86F, null, biped.toolR, "biped/combat/handhalfsword_auto5", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F))
                .addEvents(AnimationEvent.TimeStampedEvent.create(0.0F, (entitypatch, animation, params) -> {
                    if(entitypatch instanceof ServerPlayerPatch playerPatch){
                    BasicAttack.setComboCounterWithEvent(ComboCounterHandleEvent.Causal.TIME_EXPIRED_RESET, playerPatch, playerPatch.getSkill(SkillSlots.BASIC_ATTACK), null, 1);
                    }
                }, AnimationEvent.Side.SERVER));
        HANDHALFSWORD_DASH = new DashAttackAnimation(0.1F,0.53F, 0.54F,0.73F,1.26F,null,biped.toolR, "biped/combat/handhalfsword_dash",biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F));
        HANDHALFSWORD_AIRSLASH = new AirSlashAnimation(0.22F,0.53F,0.73F,1.26F,null,biped.toolR, "biped/combat/handhalfsword_airslash",biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.3F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false);
        HANDHALFSWORD_HEAVY_ATTACK1 = new AttackAnimation(0.5F,0.53F,0.54F,0.73F,1.16F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_heavyattack_1", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.75F));
        HANDHALFSWORD_HEAVY_ATTACK2 = new AttackAnimation(0.5F,0.53F,0.54F,0.73F,1.17F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_heavyattack_2", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.75F));


        //dual
        HANDHALFSWORD_DUAL_AUTO1 = new BasicAttackAnimation(0.1F, "biped/combat/handhalfsword_dual_auto1", biped,
                new AttackAnimation.Phase(0F,0.4F,0.41F,0.67F,0.80F,Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F));
        HANDHALFSWORD_DUAL_AUTO2 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto2", biped,
                new AttackAnimation.Phase(0F,0.3F,0.31F,0.43F,0.5F,Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_DUAL_AUTO3 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto3", biped,
                new AttackAnimation.Phase(0F,0.6F,0.61F,0.73F,0.83F,Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_DUAL_AUTO4 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto4", biped,
                new AttackAnimation.Phase(0F,0.33F,0.34F,0.57F,0.73F,Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_DUAL_AUTO5 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto5", biped,
                new AttackAnimation.Phase(0F,0.33F,0.34F,0.6F,0.83F,Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F))
                .addEvents(AnimationEvent.TimeStampedEvent.create(0.0F, (entitypatch, animation, params) -> {
                    if(entitypatch instanceof ServerPlayerPatch playerPatch){
                        BasicAttack.setComboCounterWithEvent(ComboCounterHandleEvent.Causal.TIME_EXPIRED_RESET, playerPatch, playerPatch.getSkill(SkillSlots.BASIC_ATTACK), null, 1);
                    }
                }, AnimationEvent.Side.SERVER));
        HANDHALFSWORD_DUAL_DASH = new DashAttackAnimation(0.1F, "biped/combat/handhalfsword_dual_dash", biped,
                new AttackAnimation.Phase(0F,0.6F,0.61F,1.67F,2F,Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, List.of(Pair.of(biped.toolR, null), Pair.of(biped.toolL, null))))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F));
        HANDHALFSWORD_DUAL_AIRSLASH = new AirSlashAnimation(0F,0.36F,0.6F,1.33F,null,biped.toolR, "biped/combat/handhalfsword_dual_airslash",biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.3F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.33F));




        //Skill
        SQUAREOFF_ON = new ActionAnimation(0.05F, "biped/skill/squareoff_on", biped);
        SQUAREOFF_OFF = new ActionAnimation(0.05F, "biped/skill/squareoff_off", biped);
        SQUAREOFF_LOOP = new StaticAnimation(true, "biped/skill/squareoff_loop", biped);
        SQUAREOFF_WALK = new MovementAnimation(true, "biped/skill/squareoff_walk", biped);


    }
}
