package com.nameless.theforcelawtweaks.world.capabilities.entity;

import com.nameless.theforcelawtweaks.world.entity.CowDevilEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.client.animation.ClientAnimator;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
import yesman.epicfight.world.damagesource.StunType;

public class CowDevilPatch extends MobPatch<CowDevilEntity> {
	public CowDevilPatch() {
		super(Faction.NEUTRAL);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void initAnimator(ClientAnimator clientAnimator) {
		clientAnimator.addLivingAnimation(LivingMotions.IDLE, Animations.BIPED_IDLE);
		clientAnimator.addLivingAnimation(LivingMotions.WALK, Animations.BIPED_WALK);
		clientAnimator.setCurrentMotionsAsDefault();
	}

	@Override
	public void updateMotion(boolean considerInaction) {
		if (this.state.inaction() && considerInaction) {
			this.currentLivingMotion = LivingMotions.IDLE;
		} else if (!(this.original.getDeltaMovement().y < -0.550000011920929) && !this.isAirborneState()) {
			if (this.original.walkAnimation.speed() > 0.08F) {
				this.currentLivingMotion = LivingMotions.WALK;
			} else {
				this.currentLivingMotion = LivingMotions.IDLE;
			}
		}
	}
	
	@Override
	public StaticAnimation getHitAnimation(StunType stunType) {
		return null;
	}
	
	@Override
	public OpenMatrix4f getModelMatrix(float partialTicks) {
		return super.getModelMatrix(partialTicks).scale(0.4F, 0.4F, 0.4F);
	}
}