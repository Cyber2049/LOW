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
    public static Skill COLOSSALSWORD_HEAVY_ATTACK;
    public static void registerSkills(){
        SkillManager.register(HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
            .setAnimations(new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/handhalfsword_heavyattack_1"), new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/handhalfsword_heavyattack_2")) ,TheForceLawTweaks.MODID,"handhalfsword_heavyattak");

        SkillManager.register(HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
                .setAnimations(new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/colossalsword/colossalsword_heavy1"), new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/colossalsword/colossalsword_heavy2")) ,TheForceLawTweaks.MODID,"colossalsword_heavyattak");
    }

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent onBuild) {
        HAND_HALF_SWORD_HEAVY_ATTACK = onBuild.<WeaponInnateSkill, Skill.Builder<WeaponInnateSkill>>build(TheForceLawTweaks.MODID, "handhalfsword_heavyattak");
        COLOSSALSWORD_HEAVY_ATTACK = onBuild.<WeaponInnateSkill, Skill.Builder<WeaponInnateSkill>>build(TheForceLawTweaks.MODID, "colossalsword_heavyattak");
    }
}
