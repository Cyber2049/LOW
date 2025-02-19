package com.nameless.theforcelawtweaks.gameasset.animation;

import com.mojang.datafixers.util.Pair;
import com.nameless.theforcelawtweaks.api.StopAttackAnimations;
import com.nameless.theforcelawtweaks.client.keymappings.TFLKeyMappings;
import com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch.CowDevilArmature;
import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.client.input.EpicFightKeyMappings;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.skill.BasicAttack;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;
import yesman.epicfight.world.entity.eventlistener.ComboCounterHandleEvent;

import java.util.List;
import java.util.Set;

public class TFLAnimations {
    public static StaticAnimation HANDHALFSWORD_AUTO1;
    public static StaticAnimation HANDHALFSWORD_AUTO2;
    public static StaticAnimation HANDHALFSWORD_AUTO3;
    public static StaticAnimation HANDHALFSWORD_AUTO4;
    public static StaticAnimation HANDHALFSWORD_AUTO5;
    public static StaticAnimation HANDHALFSWORD_DASH;
    public static StaticAnimation HANDHALFSWORD_HEAVY_ATTACK1;
    public static StaticAnimation HANDHALFSWORD_HEAVY_ATTACK2;
    public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK1;
    public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK1_L;
    public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK1_R;
    public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK2;
    public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK2_L;
    public static StaticAnimation HANDHALFSWORD_DODGE_ATTACK2_R;
    public static StaticAnimation PURSUIT_LIGHT;
    public static StaticAnimation PURSUIT_HEAVY;
    public static StaticAnimation PURSUIT;
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

    //new
    public static StaticAnimation IDEL0;
    public static StaticAnimation IDEL1;
    public static StaticAnimation RUN;
    public static StaticAnimation WALK;
    public static StaticAnimation SHIELD;
    public static StaticAnimation SHIELD_BOKEN;
    public static StaticAnimation SHIELD_HIT1;
    public static StaticAnimation SHIELD_HIT2;
    public static StaticAnimation SHIELD_HIT3;
    public static StaticAnimation SHIELD_HIT4;
    public static StaticAnimation SLASH_SHIELD;
    public static StaticAnimation SLASH_SPEAR;
    public static StaticAnimation SPEAR_AUTO1;
    public static StaticAnimation SPEAR_AUTO2;
    public static StaticAnimation SPEAR_AUTO3;
    public static StaticAnimation SPEAR_SPECIAL;
    public static StaticAnimation SPEAR_SWEEP;
    public static StaticAnimation COLOSSALSWORD_IDLE;
    public static StaticAnimation COLOSSALSWORD_AUTO1;
    public static StaticAnimation COLOSSALSWORD_AUTO2;
    public static StaticAnimation COLOSSALSWORD_AUTO3;
    public static StaticAnimation COLOSSALSWORD_AUTO4;
    public static StaticAnimation COLOSSALSWORD_AUTO5;
    public static StaticAnimation COLOSSALSWORD_HEAVY_ATTACK1;
    public static StaticAnimation COLOSSALSWORD_HEAVY_ATTACK2;
    public static StaticAnimation EXECUTE;
    public static StaticAnimation EXECUTEED;
    //yullian
    public static StaticAnimation YULLIAN_COMBOA1;
    public static StaticAnimation YULLIAN_COMBOA2;
    public static StaticAnimation YULLIAN_COMBOA3;
    public static StaticAnimation YULLIAN_COMBOB1;
    public static StaticAnimation YULLIAN_COMBOC1;
    public static StaticAnimation YULLIAN_COMBOC2;
    public static StaticAnimation YULLIAN_DODGEATTACK;

    public static StaticAnimation YULLIAN_IDLE;
    public static StaticAnimation YULLIAN_HURT;
    public static StaticAnimation YULLIAN_JUMP_HEAVYATTACK;
    public static StaticAnimation YULLIAN_JUMP1;
    public static StaticAnimation YULLIAN_JUMP1_1;
    public static StaticAnimation YULLIAN_JUMP1_2;
    public static StaticAnimation YULLIAN_JUMP1_3;
    public static StaticAnimation YULLIAN_JUMP2;
    public static StaticAnimation YULLIAN_JUMP3;
    public static StaticAnimation YULLIAN_JUMPPATTACK;
    public static StaticAnimation YULLIAN_RUN;
    public static StaticAnimation YULLIAN_SPECIALATTACK1_5;
    public static StaticAnimation YULLIAN_SPECIALATTACK1;
    public static StaticAnimation YULLIAN_SPECIALATTACK2;
    public static StaticAnimation YULLIAN_SPECIALATTACK3;
    public static StaticAnimation YULLIAN_SPECIALATTACK4;
    public static StaticAnimation YULLIAN_SPECIALATTACK5;
    public static StaticAnimation YULLIAN_WALK;
    public static StaticAnimation YULLIAN_DASHAHATTCK;
    public static StaticAnimation YULLIAN_GREATSPEACIAL1;
    public static StaticAnimation YULLIAN_GREATSPEACIAL2;
    public static StaticAnimation YULLIAN_SLOW0;
    public static StaticAnimation YULLIAN_SLOW1;
    public static StaticAnimation YULLIAN_SLOW2;
    public static StaticAnimation YULLIAN_SLOW3;

    public static StaticAnimation YULLIAN_SPECIALATTACK_LEFT_DASH_KNIFE;
    public static StaticAnimation YULLIAN_SPECIALATTACK_LEFT_DASH_SWORD;

    public static StaticAnimation YULLIAN_SPECIALATTACK_LEFT_DASH_BIG;
    public static StaticAnimation YULLIAN_SPECIALATTACK_LEFT_DASH_SMALL;
    public static StaticAnimation YULLIAN_SPECIALATTACK_RIGHT_DASH_BIG;
    public static StaticAnimation YULLIAN_SPECIALATTACK_RIGHT_DASH_SMALL;



    public static StaticAnimation SKILL_ROLL_FORWARD;
    public static StaticAnimation SKILL_ROLL_BACKWARD;


    public static StaticAnimation SKILL_ROLL_RIGHT;//闪避
    public static StaticAnimation SKILL_ROLL_LEFT;//闪避
    public static StaticAnimation SKILL_ROLL_AFTER;//闪避
    public static StaticAnimation SKILL_ROLL_FRONT;//闪避



    public static StaticAnimation SKILL_DODGE_RIGHT;//闪避
    public static StaticAnimation SKILL_DODGE_AFTER;
    public static StaticAnimation SKILL_DODGE_FRONT;
    public static StaticAnimation SKILL_DODGE_LEFT;

    public static StaticAnimation CWO_DEVIL_IDLE;
    public static StaticAnimation CWO_DEVIL_ATTACK;




    public static AnimationEvent.AnimationEventConsumer PURSUIT_EVENT = ((livingEntityPatch, staticAnimation, objects) -> {
//        if(TFLKeyMappings.BASIC_ATTACK.isRelease()){
//            livingEntityPatch.playAnimationSynchronized(PURSUIT, 0.0F);
//        }
//        if (EpicFightKeyMappings.ATTACK.isDown()) {
//            livingEntityPatch.playAnimationSynchronized(PURSUIT, 0.0F);
//        }
    });

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(TheForceLawTweaks.MODID, TFLAnimations::build);
    }

    public static void build() {
        HumanoidArmature biped = Armatures.BIPED;
        CowDevilArmature bipex=com.nameless.theforcelawtweaks.gameasset.Armatures.cowDevilArmature;

        //hand half sword
        //one hand
        CWO_DEVIL_ATTACK = new AttackAnimation(0F, 2.36F,  2.56F, 4.86F,1F,  null,bipex.toolR, "biped/devil/cow_devil_attack", bipex);
        CWO_DEVIL_IDLE = new AttackAnimation(0F, 2.36F,  2.56F, 4.86F,1F,  null, bipex.toolR, "biped/devil/cow_devil_idle", bipex);



        //one hand更新s
        SKILL_ROLL_RIGHT = new DodgeAnimation(0.1F, 1.1F, "biped/skill/roll_right", 0.6F, 1.65F, biped)
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .newTimePair(0.3F, Float.MAX_VALUE)
                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                .newTimePair(0.0F, 1.0F)
                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
        SKILL_ROLL_LEFT = new DodgeAnimation(0.1F, 1.1F, "biped/skill/roll_left", 0.6F, 1.65F, biped)
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .newTimePair(0.667F, Float.MAX_VALUE)
                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                .newTimePair(0.0F, 1.0F)
                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
        SKILL_ROLL_AFTER = new DodgeAnimation(0.1F, 1.1F, "biped/skill/roll_after", 0.6F, 1.65F, biped)
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .newTimePair(0.667F, Float.MAX_VALUE)
                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                .newTimePair(0.0F, 1.0F)
                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
        SKILL_ROLL_FRONT = new DodgeAnimation(0.1F, 1.1F, "biped/skill/roll_front", 0.6F, 1.65F, biped)
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .newTimePair(0.667F, Float.MAX_VALUE)
                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                .newTimePair(0.0F, 1.0F)
                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);




        SKILL_DODGE_RIGHT = new DodgeAnimation(0.1F, 0.5F, "biped/skill/slidingstep_right", 0.6F, 1.65F, biped)
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .newTimePair(0.0F, 0.667F)
                .addState(EntityState.CAN_SKILL_EXECUTION, true)
                .newTimePair(0.0F, 1.0F)
                .addStateRemoveOld(EntityState.CAN_BASIC_ATTACK, false);
        SKILL_DODGE_AFTER = new BasicAttackAnimation(0.067F, 0F, 0F, 0.25F, null, biped.toolR, "biped/skill/slidingstep_after", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v,v1, v2) -> 1.5F));

        SKILL_DODGE_FRONT = new BasicAttackAnimation(0.067F, 0F, 0F,  0.25F, null, biped.toolR, "biped/skill/slidingstep_front", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        SKILL_DODGE_LEFT = new BasicAttackAnimation(0.067F, 0F, 0F,  0.25F, null, biped.toolR, "biped/skill/slidingstep_left", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));


        //yullian
        YULLIAN_SPECIALATTACK_LEFT_DASH_KNIFE = new BasicAttackAnimation(0.1F, 0.8F, 1F, 2F, null, biped.toolR, "biped/yullian/yullian_specialattack_left_dash_knife", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.2F));;
        YULLIAN_SPECIALATTACK_LEFT_DASH_SWORD = new BasicAttackAnimation(0.1F, 0F, 1F, 2F, null, biped.toolR, "biped/yullian/yullian_specialattack_left_dash_sword", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.2F));;

        YULLIAN_SPECIALATTACK_LEFT_DASH_BIG = new StaticAnimation(true, "biped/yullian/yullian_specialattack_left_dash_big", biped);
        YULLIAN_SPECIALATTACK_LEFT_DASH_SMALL = new StaticAnimation(true, "biped/yullian/yullian_specialattack_left_dash_small", biped);
        YULLIAN_SPECIALATTACK_RIGHT_DASH_BIG = new StaticAnimation(true, "biped/yullian/yullian_specialattack_right_dash_big", biped);
        YULLIAN_SPECIALATTACK_RIGHT_DASH_SMALL = new StaticAnimation(true, "biped/yullian/yullian_specialattack_right_dash_small", biped);

//indestructible @p play "theforcelawtweaks:biped/yullian/yullian_specialattack_left_dash_knife" 0 1
////indestructible @p play "theforcelawtweaks:biped/yullian/yullian_specialattack_left_dash_sword" 0 1


        YULLIAN_GREATSPEACIAL1 = new BasicAttackAnimation(0.1F, 0.533F,  1.933F, 3.3F, null, biped.toolR, "biped/yullian/yullian_greatspeacial1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_GREATSPEACIAL2 = new BasicAttackAnimation(0.1F, 0.733F,  0.9F, 4.1F, null, biped.toolR, "biped/yullian/yullian_greatspeacial2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));

        YULLIAN_SLOW0 = new BasicAttackAnimation(0.1F, 0.333F,  1.533F, 3F, null, biped.toolR, "biped/yullian/yullian_slow0", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_SLOW1 = new BasicAttackAnimation(0.1F, 0.333F,  1.533F, 3F, null, biped.toolR, "biped/yullian/yullian_slow1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_SLOW2 = new BasicAttackAnimation(0.1F, 0.6F,  0.767F, 2F, null, biped.toolR, "biped/yullian/yullian_slow2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_SLOW3 = new BasicAttackAnimation(0.1F, 1F,  1.167F, 2.2F, null, biped.toolR, "biped/yullian/yullian_slow3", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));


        YULLIAN_COMBOA1 = new BasicAttackAnimation(0.1F, 0.8F,  0.93F, 1F, null, biped.toolR, "biped/yullian/yullian_comboa1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_COMBOA2 = new BasicAttackAnimation(0.1F, 1.63F, 0.83F, 1F, null, biped.toolR, "biped/yullian/yullian_comboa2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_COMBOA3 = new BasicAttackAnimation(0.1F, 0.467F,  0.6F, 2.43F, null, biped.toolR,"biped/yullian/yullian_comboa3", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));

        YULLIAN_COMBOB1 = new BasicAttackAnimation(0.1F, "biped/yullian/yullian_combob1", biped,
                new AttackAnimation.Phase(0F, 0.63F, 0.76F, 3.23F, 0.76F, InteractionHand.MAIN_HAND, biped.toolR, null),
                new AttackAnimation.Phase(0.76F, 1.36F, 1.53F, 3.23F,3.23F, InteractionHand.MAIN_HAND, biped.toolR, null)
        ) .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));


        YULLIAN_COMBOC1 = new BasicAttackAnimation(0.1F, 0.4F, 0.5F, 0.73F,  null, biped.toolR, "biped/yullian/yullian_comboc1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_COMBOC2 = new BasicAttackAnimation(0.1F, "biped/yullian/yullian_comboc2", biped,
                new AttackAnimation.Phase(0F, 0.6F, 0.7F, 1F, 0.7F, InteractionHand.MAIN_HAND, biped.toolR, null),
                new AttackAnimation.Phase(0.7F, 0.9F, 1.03F, 233.0F,233.0F, InteractionHand.MAIN_HAND, biped.toolR, null)
        ) .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.0F));
        YULLIAN_DODGEATTACK = new BasicAttackAnimation(0.1F, 0.4F,  0.5F, 0.73F, null, biped.toolR, "biped/yullian/yullian_dodgeattack", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMP_HEAVYATTACK = new BasicAttackAnimation(0.1F, 0.967F, 1.06F, 4.267F, null, biped.toolR,"biped/yullian/yullian_jump_heavyattack", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMP1 = new BasicAttackAnimation(0.1F, 0.967F, 1.06F, 4.267F, null, biped.toolR,"biped/yullian/yullian_jump_heavyattack", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMP1_1 = new BasicAttackAnimation(0.1F, 0.677F, 0.833F, 2.267F, null, biped.toolR,"biped/yullian/yullian_jump1_1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMP1_2 = new BasicAttackAnimation(0.1F, 0.677F, 0.833F, 2.267F, null, biped.toolR,"biped/yullian/yullian_jump1_2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMP1_3 = new BasicAttackAnimation(0.1F, 0.677F, 0.833F, 2.267F, null, biped.toolR,"biped/yullian/yullian_jump1_3", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMP2 = new BasicAttackAnimation(0.1F, 1F, 1.267F, 2.267F, null, biped.toolR,"biped/yullian/yullian_jump2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMP3 = new BasicAttackAnimation(0.1F, 1F, 1.267F, 2.267F, null, biped.toolR,"biped/yullian/yullian_jump3", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_JUMPPATTACK = new BasicAttackAnimation(0.1F, 0.67F,  0.76F, 2.83F,  null, biped.toolR,"biped/yullian/yullian_jumpattack", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_DASHAHATTCK= new BasicAttackAnimation(0.1F, 0.67F,  0.76F, 2.83F, null, biped.toolR,"biped/yullian/yullian_dashattack", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));

        YULLIAN_SPECIALATTACK1_5 = new BasicAttackAnimation(0.1F, 1.43F, 1.8F, 4.2F, null, biped.toolR, "biped/yullian/yullian_specialattack1_5", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_SPECIALATTACK1 = new BasicAttackAnimation(0.1F, 1.43F, 1.8F, 4.2F, null, biped.toolR, "biped/yullian/yullian_specialattack1", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_SPECIALATTACK2 = new BasicAttackAnimation(0.1F, 1.23F,  1.56F, 4.167F,  null, biped.toolR, "biped/yullian/yullian_specialattack2", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_SPECIALATTACK3 = new BasicAttackAnimation(0.1F, 1.567F,  2.0F, 3.8F,  null, biped.toolR,"biped/yullian/yullian_specialattack3", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_SPECIALATTACK4 = new BasicAttackAnimation(0.1F, 0.7F,  1.067F, 2.667F,  null, biped.toolR, "biped/yullian/yullian_specialattack4", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));
        YULLIAN_SPECIALATTACK5 = new BasicAttackAnimation(0.1F, 0.833F,  1F, 2.333F,  null, biped.toolR,"biped/yullian/yullian_specialattack5", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1,v2) -> 1.5F));


        YULLIAN_WALK = new StaticAnimation(true, "biped/yullian/yullian_walk", biped);
        YULLIAN_RUN = new StaticAnimation(true, "biped/yullian/yullian_run", biped);
        YULLIAN_IDLE = new StaticAnimation(true, "biped/yullian/yullian_idle", biped);
        YULLIAN_HURT = new StaticAnimation(true, "biped/yullian/yullian_hurt", biped);


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
                    if (entitypatch instanceof ServerPlayerPatch playerPatch) {
                        BasicAttack.setComboCounterWithEvent(ComboCounterHandleEvent.Causal.TIME_EXPIRED, playerPatch, playerPatch.getSkill(SkillSlots.BASIC_ATTACK), null, 1);
                    }
                }, AnimationEvent.Side.SERVER));
        HANDHALFSWORD_DASH = new DashAttackAnimation(0.1F, 0.53F, 0.54F, 0.73F, 1.26F, null, biped.toolR, "biped/combat/handhalfsword_dash", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F));
        HANDHALFSWORD_AIRSLASH = new AirSlashAnimation(0.22F, 0.53F, 0.73F, 1.26F, null, biped.toolR, "biped/combat/handhalfsword_airslash", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.3F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false);

        HANDHALFSWORD_DODGE_ATTACK1 = new TFLDodgeAttackAnimation(0.15F, 0.133F, 0.133F, 0.3F, 1F, null, biped.toolR, "biped/combat/handhalfsword_dodge_attack_1", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F))
                .addEvents(AnimationEvent.TimePeriodEvent.create(1F, 2.0F, PURSUIT_EVENT, AnimationEvent.Side.CLIENT))
                .newTimePair(1F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true);

        HANDHALFSWORD_DODGE_ATTACK1_L = new TFLDodgeAttackAnimation(0.15F, 0.133F, 0.133F, 0.3F, 1F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_dodge_attack_1_left", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F))
                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT, AnimationEvent.Side.CLIENT))
                .newTimePair(1F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true);

        HANDHALFSWORD_DODGE_ATTACK1_R = new TFLDodgeAttackAnimation(0.15F, 0.133F, 0.133F, 0.3F, 1F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_dodge_attack_1_right", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F))
                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT, AnimationEvent.Side.CLIENT))
                .newTimePair(1F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true);

        HANDHALFSWORD_DODGE_ATTACK2 = new TFLDodgeAttackAnimation(0.15F, 0.067F, 0.067F, 0.2F, 1F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_dodge_attack_2", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F))
                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT, AnimationEvent.Side.CLIENT))
                .newTimePair(1F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true);

        HANDHALFSWORD_DODGE_ATTACK2_L = new TFLDodgeAttackAnimation(0.15F, 0.067F, 0.067F, 0.2F, 1F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_dodge_attack_2_left", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F))
                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT, AnimationEvent.Side.CLIENT))
                .newTimePair(1F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true);

        HANDHALFSWORD_DODGE_ATTACK2_R = new TFLDodgeAttackAnimation(0.15F, 0.067F, 0.067F, 0.2F, 1F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_dodge_attack_2_right", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.8F))
                .addEvents(AnimationEvent.TimePeriodEvent.create(0.5F, 2.0F, PURSUIT_EVENT, AnimationEvent.Side.CLIENT))
                .newTimePair(1F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true);

        PURSUIT_LIGHT = new AttackAnimation(0.1F, 0.36F, 0.5F, 0.16F, 0.75F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_dodge_pursuit_light", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.25F));

        PURSUIT_HEAVY = new AttackAnimation(0.1F, 0.56F, 0.57F, 0.67F, 1.20F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_dodge_pursuit_heavy", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F));

        PURSUIT = new AttackAnimation(0.1F, 0.53F, 0.53F, 0.63F, 1.23F, null, biped.toolR, "biped/combat/handhalfsword_dodge_pursuit", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.5F));

        HANDHALFSWORD_HEAVY_ATTACK1 = new AttackAnimation(0.5F, 0.6F, 0.61F, 1.05F, 1.5F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_heavyattack_1", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.75F))
                .newTimePair(1.5F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                .addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.54F, ((livingEntityPatch, staticAnimation, objects) -> {
//                    if (EpicFightKeyMappings.DODGE.isDown() && Minecraft.getInstance().player != null) {
//                        if (TFLKeyMappings.A.isDown()) {
//                            livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1_L, 0.0F);
//                        } else if(TFLKeyMappings.D.isDown()){
//                            livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1_R, 0.0F);
//                        } else {
//                            livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1, 0.0F);
//                        }
//                    }
                    if(TFLKeyMappings.D.isDown() && EpicFightKeyMappings.DODGE.isDown()){
                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1_R, 0.0F);
                    } else if (TFLKeyMappings.A.isDown() && EpicFightKeyMappings.DODGE.isDown()){
                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1_L, 0.0F);
                    } else if (EpicFightKeyMappings.DODGE.isDown()){
                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1, 0.0F);
                    }
                }), AnimationEvent.Side.CLIENT));
        HANDHALFSWORD_HEAVY_ATTACK2 = new AttackAnimation(0.5F, 0.6F, 0.61F, 1.0F, 1.5F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/handhalfsword_heavyattack_2", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.75F)).addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.61F, ((livingEntityPatch, staticAnimation, objects) -> {
                    if(TFLKeyMappings.D.isDown() && EpicFightKeyMappings.DODGE.isDown()){
                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK2_R, 0.0F);
                    } else if (TFLKeyMappings.A.isDown() && EpicFightKeyMappings.DODGE.isDown()){
                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK2_L, 0.0F);
                    } else if (EpicFightKeyMappings.DODGE.isDown()){
                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK2, 0.0F);
                    }
                }), AnimationEvent.Side.CLIENT));


        //dual
        HANDHALFSWORD_DUAL_AUTO1 = new BasicAttackAnimation(0.1F, "biped/combat/handhalfsword_dual_auto1", biped,
                new AttackAnimation.Phase(0F, 0.4F, 0.41F, 0.67F, 0.80F, Float.MAX_VALUE, false, InteractionHand.MAIN_HAND,biped.toolR, null))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F));
        HANDHALFSWORD_DUAL_AUTO2 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto2", biped,
                new AttackAnimation.Phase(0F, 0.3F, 0.31F, 0.43F, 0.5F, Float.MAX_VALUE, false, InteractionHand.MAIN_HAND,biped.toolR, null))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_DUAL_AUTO3 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto3", biped,
                new AttackAnimation.Phase(0F, 0.6F, 0.61F, 0.73F, 0.83F, Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, biped.toolR, null))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_DUAL_AUTO4 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto4", biped,
                new AttackAnimation.Phase(0F, 0.33F, 0.34F, 0.57F, 0.73F, Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, biped.toolR, null),
                new AttackAnimation.Phase(0F, 0.43F, 0.45F, 0.7F, 0.8F, Float.MAX_VALUE, false, InteractionHand.OFF_HAND,biped.toolL, null))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F);
        HANDHALFSWORD_DUAL_AUTO5 = new BasicAttackAnimation(0.05F, "biped/combat/handhalfsword_dual_auto5", biped,
                new AttackAnimation.Phase(0F, 0.33F, 0.34F, 0.6F, 0.83F, Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, biped.toolR, null))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.1F))
                .addEvents(AnimationEvent.TimeStampedEvent.create(0.0F, (entitypatch, animation, params) -> {
                    if (entitypatch instanceof ServerPlayerPatch playerPatch) {
                        BasicAttack.setComboCounterWithEvent(ComboCounterHandleEvent.Causal.TIME_EXPIRED, playerPatch, playerPatch.getSkill(SkillSlots.BASIC_ATTACK), null, 1);
                    }
                }, AnimationEvent.Side.SERVER));
        HANDHALFSWORD_DUAL_DASH = new DashAttackAnimation(0.1F, "biped/combat/handhalfsword_dual_dash", biped,
                new AttackAnimation.Phase(0F, 0.6F, 0.61F, 1.67F, 2F, Float.MAX_VALUE, false, InteractionHand.MAIN_HAND, biped.toolR, null))
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1F));
        HANDHALFSWORD_DUAL_AIRSLASH = new AirSlashAnimation(0F, 0.36F, 0.6F, 1.33F, null, biped.toolR, "biped/combat/handhalfsword_dual_airslash", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.3F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0F, 1.33F));


        //Skill
        SQUAREOFF_ON = new ActionAnimation(0.05F, "biped/skill/squareoff_on", biped);
        SQUAREOFF_OFF = new ActionAnimation(0.05F, "biped/skill/squareoff_off", biped);
        SQUAREOFF_LOOP = new StaticAnimation(true, "biped/skill/squareoff_loop", biped);
        SQUAREOFF_WALK = new MovementAnimation(true, "biped/skill/squareoff_walk", biped);


        //new
        WALK = new StaticAnimation(true, "biped/monster/walk", biped);
        IDEL0 = new StaticAnimation(true, "biped/monster/idle0", biped);
        IDEL1 = new StaticAnimation(true, "biped/monster/idle1", biped);
        RUN = new StaticAnimation(true, "biped/monster/run", biped);
        SHIELD = new MirrorAnimation(0.25F, true, "biped/monster/shield","biped/monster/shield", "biped/monster/shield", biped);
        SHIELD_BOKEN = new LongHitAnimation(0.05F, "biped/monster/shield-broken", biped);
        SHIELD_HIT1 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-1", biped);
        SHIELD_HIT2 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-2", biped);
        SHIELD_HIT3 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-3", biped);
        SHIELD_HIT4 = new LongHitAnimation(0.05F, "biped/monster/shield-hit-4", biped);

        SLASH_SHIELD = new AttackAnimation(0.1F, 1.967F, 1.15F, 2.216F, 5F, ColliderPreset.SPEAR, biped.rootJoint, "biped/monster/slash-shield", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(-0.2F))
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(0.5F))
                .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);

        SLASH_SPEAR = new AttackAnimation(0.1F, 0.55F, 0.95F, 1.06F, 3F, null, biped.toolR, "biped/monster/slash-spear", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(-0.2F))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(0.5F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);

        SPEAR_SPECIAL = new AttackAnimation(0.1F, "biped/monster/spear-special", biped,
                new AttackAnimation.Phase(0.0F, 1.25F, 1.416F, 1.42F, 1.42F, biped.toolR, null),
                new AttackAnimation.Phase(0.4F, 1.95F, 2.116F, 2.22F, 2.5F, biped.toolR, null),
                new AttackAnimation.Phase(0.6F, 2.591F, 2.758F, 5.16F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);

        SPEAR_SWEEP = new AttackAnimation(0.1F, 0.616F, 0.801F, 0.942F, 4.16F, null, biped.toolR, "biped/monster/spear-sweep", biped)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);

        SPEAR_AUTO1 = new BasicAttackAnimation(0.1F, "biped/monster/spear-auto1", biped,
                new AttackAnimation.Phase(0F, 0.975F, 0.55F, 1.15F, 2.708F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);
        SPEAR_AUTO2 = new BasicAttackAnimation(0.1F, "biped/monster/spear-auto2", biped,
                new AttackAnimation.Phase(0F, 0.95F, 1.035F, 1.191F, 3.041F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);


        SPEAR_AUTO3 = new BasicAttackAnimation(0.1F, "biped/monster/spear-auto3", biped,
                new AttackAnimation.Phase(0F, 0.967F, 1.0F, 1.191F, 7.291F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);

        COLOSSALSWORD_IDLE = new StaticAnimation(true, "biped/combat/colossalsword/colossalsword_idle", biped);
        COLOSSALSWORD_AUTO1 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword1", biped,
                new AttackAnimation.Phase(0F, 0.7F, 0.75F, 0.8F, 1.13F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(0.1F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
                .addEvents(AnimationEvent.TimeStampedEvent.create(0.95F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.rootJoint, 1.1D, 0.55F));
        COLOSSALSWORD_AUTO2 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword2", biped,
                new AttackAnimation.Phase(0F, 0.76F, 0.70F, 1.23F, 1.5F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
                .addEvents(AnimationEvent.TimeStampedEvent.create(1.25F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.toolR, 1.1D, 0.55F));
        COLOSSALSWORD_AUTO3 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword3", biped,
                new AttackAnimation.Phase(0F, 0.67F, 0.70F, 0.75F, 1F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(0.25F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);
        COLOSSALSWORD_AUTO4 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword4", biped,
                new AttackAnimation.Phase(0F, 0.63F, 0.75F, 1.83F, 1.3F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(0.5F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
                .addEvents(AnimationEvent.TimeStampedEvent.create(0.95F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.rootJoint, 1.1D, 0.55F));
        COLOSSALSWORD_AUTO5 = new BasicAttackAnimation(0.1F, "biped/combat/colossalsword/greatsword5", biped,
                new AttackAnimation.Phase(0F, 0.7F, 0.75F, 1.13F, 1.43F, Float.MAX_VALUE, biped.toolR, null))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE)
                .addEvents(AnimationEvent.TimeStampedEvent.create(1.25F, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.toolR, 1.1D, 0.55F));
        EXECUTE = new StopAttackAnimations(0.0F, 0.0F, 2.65F, 1.3F, 1.75F, 0.7F, 2.65F, 0.0F, 0.0F, "biped/hit/execute", biped,
                new AttackAnimation.Phase(0.0F, 0.75F, 0.51F, 0.95F, 3F, biped.toolR, null)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                        .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(5F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.EVISCERATE.get()),
                new AttackAnimation.Phase(1.05F, 2.95F, 3.15F, 6.0F, Float.MAX_VALUE, biped.rootJoint, ColliderPreset.BIPED_BODY_COLLIDER)
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_RUSH_FINISHER.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.EVISCERATE)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.TARGET_LOST_HEALTH.create(0.2F))))
                .addProperty(AnimationProperty.ActionAnimationProperty.STOP_MOVEMENT, true)
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_ON_LINK, false)
                .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_LOCROT_TARGET)
                .addProperty(AnimationProperty.ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_LOCROT_TARGET)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, Animations.ReusableSources.CONSTANT_ONE);
        EXECUTEED = new LongHitAnimation(0.05F, "biped/hit/guard_break1", biped);

        COLOSSALSWORD_HEAVY_ATTACK1 = new AttackAnimation(0.1F, 1.167F, 1.167F, 1.567F, 2.167F, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/colossalsword/colossalsword_heavy1", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.75F))
                .newTimePair(1.567F, Float.MAX_VALUE)
                .addStateRemoveOld(EntityState.CAN_SKILL_EXECUTION, true)
                .addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.54F, ((livingEntityPatch, staticAnimation, objects) -> {
//                    if(EpicFightKeyMappings.DODGE.isDown()){
//                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK1, 0.0F);
//                    }
                }), AnimationEvent.Side.CLIENT));
        COLOSSALSWORD_HEAVY_ATTACK2 = new AttackAnimation(0.1F, 1, 1, 1.4F, 2, InteractionHand.MAIN_HAND, null, biped.toolR, "biped/combat/colossalsword/colossalsword_heavy2", biped)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.75F)).addEvents(AnimationEvent.TimePeriodEvent.create(0.01F, 0.61F, ((livingEntityPatch, staticAnimation, objects) -> {
//                    if(EpicFightKeyMappings.DODGE.isDown()){
//                        livingEntityPatch.playAnimationSynchronized(HANDHALFSWORD_DODGE_ATTACK2, 0.0F);
//                    }
                }), AnimationEvent.Side.CLIENT));


    }
}
