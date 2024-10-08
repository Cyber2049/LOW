package com.nameless.theforcelawtweaks.gameasset;

import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import com.nameless.theforcelawtweaks.skill.weaponinnateskill.HeavyAttack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

@Mod.EventBusSubscriber(modid = TheForceLawTweaks.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LOWSkills {
    public static Skill HAND_HALF_SWORD_HEAVY_ATTACK;
    public static void registerSkills(){
        SkillManager.register(HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
                .setAnimations(new ResourceLocation("theforcelawtweaks","biped/combat/handhalfsword_heavyattack_1"), new ResourceLocation("theforcelawtweaks","biped/combat/handhalfsword_heavyattack_2")) ,"theforcelawtweaks","handhalfsword_heavyattak");
    }

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent onBuild) {
        HAND_HALF_SWORD_HEAVY_ATTACK = onBuild.<WeaponInnateSkill, Skill.Builder<WeaponInnateSkill>>build("theforcelawtweaks", "handhalfsword_heavyattak");
    }
}
