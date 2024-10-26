package com.nameless.theforcelawtweaks.skill.weaponinnateskill;

import com.nameless.theforcelawtweaks.gameasset.animation.TFLAnimations;
import com.nameless.theforcelawtweaks.gameasset.animation.TFLDodgeAttackAnimation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.skill.*;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

import static com.nameless.theforcelawtweaks.main.TheForceLawTweaks.TFLLOGGER;

public class HeavyAttack extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("d1d145cc-f10f-41ed-a14b-5141ac919810");

    private final StaticAnimation[] animations;

    public HeavyAttack(HeavyAttack.Builder builder) {
        super(builder);
        this.animations = new StaticAnimation[builder.animationLocations.length];
        for(int i = 0; i < builder.animationLocations.length; ++i) {
            this.animations[i] = EpicFightMod.getInstance().animationManager.findAnimationByPath(builder.animationLocations[i].toString());
        }
    }

    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        container.getExecuter().getEventListener().addEventListener(PlayerEventListener.EventType.SKILL_EXECUTE_EVENT, EVENT_UUID, (event -> {
            DynamicAnimation currentAnim = event.getPlayerPatch().getAnimator().getPlayerFor(null).getAnimation();
            if(event.getSkillContainer().getSkill().getCategory().equals(SkillCategories.DODGE) && (currentAnim.equals(animations[0]) || currentAnim.equals(animations[1]))){
                event.setCanceled(true);
            }
        }));
    }

    public static HeavyAttack.Builder createHeavyAttackBuilder() {
        return (new HeavyAttack.Builder()).setCategory(SkillCategories.WEAPON_INNATE).setResource(Resource.STAMINA);
    }

    @Override
    public boolean shouldDraw(SkillContainer container) {
        return false;
    }

    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        super.executeOnServer(executer, args);
        DynamicAnimation currentAnimation = executer.getAnimator().getPlayerFor(null).getAnimation();
        //重击1接重击2
        if(currentAnimation.equals(this.animations[0])){
            executer.playAnimationSynchronized(this.animations[1], 0.0F);
            return;
        }
        //重击2接重击1
        if(currentAnimation.equals(this.animations[1])){
            executer.playAnimationSynchronized(this.animations[0], 0.0F);
            return;
        }
        //闪避技能接pursuit_heavy
        if(currentAnimation instanceof TFLDodgeAttackAnimation){
            executer.playAnimationSynchronized(TFLAnimations.PURSUIT, 0.0F);
            return;
        }

        int combo = executer.getSkill(SkillCategories.BASIC_ATTACK.universalOrdinal()).getDataManager().getDataValue(SkillDataKeys.COMBO_COUNTER.get());
        int heavyAttack = combo%2;

        executer.playAnimationSynchronized(this.animations[heavyAttack], 0.0F);
        TFLLOGGER.info("STAMINA: "+ executer.getStamina());
    }

    public static class Builder extends Skill.Builder<HeavyAttack> {
        protected ResourceLocation[] animationLocations;

        public Builder() {
        }

        public HeavyAttack.Builder setCategory(SkillCategory category) {
            this.category = category;
            return this;
        }

        public HeavyAttack.Builder setActivateType(ActivateType activateType) {
            this.activateType = activateType;
            return this;
        }

        public HeavyAttack.Builder setResource(Resource resource) {
            this.resource = resource;
            return this;
        }

        public HeavyAttack.Builder setAnimations(ResourceLocation... animationLocations) {
            this.animationLocations = animationLocations;
            return this;
        }
    }


}
