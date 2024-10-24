package com.nameless.theforcelawtweaks.skill.weaponinnateskill;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.SkillCategory;
import yesman.epicfight.skill.SkillDataKeys;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

import static com.nameless.theforcelawtweaks.main.TheForceLawTweaks.TFLLOGGER;

public class HeavyAttack extends WeaponInnateSkill {

    private final StaticAnimation[] animations;

    public HeavyAttack(HeavyAttack.Builder builder) {
        super(builder);
        this.animations = new StaticAnimation[builder.animationLocations.length];
        for(int i = 0; i < builder.animationLocations.length; ++i) {
            this.animations[i] = EpicFightMod.getInstance().animationManager.findAnimationByPath(builder.animationLocations[i].toString());
        }
    }

    public static HeavyAttack.Builder createHeavyAttackBuilder() {
        return (new HeavyAttack.Builder()).setCategory(SkillCategories.WEAPON_INNATE).setResource(Resource.STAMINA);
    }

    public void executeOnServer(ServerPlayerPatch executer, FriendlyByteBuf args) {
        super.executeOnServer(executer, args);
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
