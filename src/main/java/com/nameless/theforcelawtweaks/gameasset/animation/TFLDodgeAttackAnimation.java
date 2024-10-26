package com.nameless.theforcelawtweaks.gameasset.animation;

import net.minecraft.world.InteractionHand;
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.model.Armature;

public class TFLDodgeAttackAnimation extends AttackAnimation {
    public TFLDodgeAttackAnimation(float convertTime, float antic, float preDelay, float contact, float recovery, @Nullable Collider collider, Joint colliderJoint, String path, Armature armature) {
        super(convertTime, antic, preDelay, contact, recovery, collider, colliderJoint, path, armature);
    }

    public TFLDodgeAttackAnimation(float convertTime, float antic, float preDelay, float contact, float recovery, InteractionHand hand, @Nullable Collider collider, Joint colliderJoint, String path, Armature armature) {
        super(convertTime, antic, preDelay, contact, recovery, hand, collider, colliderJoint, path, armature);
    }

    public TFLDodgeAttackAnimation(float convertTime, String path, Armature armature, Phase... phases) {
        super(convertTime, path, armature, phases);
    }
}
