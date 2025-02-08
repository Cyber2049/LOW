package com.nameless.theforcelawtweaks.gameasset;

import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import com.nameless.theforcelawtweaks.skill.weaponinnateskill.HeavyAttack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.dodge.DodgeSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

@Mod.EventBusSubscriber(modid = TheForceLawTweaks.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LOWSkills {
    public static Skill HAND_HALF_SWORD_HEAVY_ATTACK;
    public static Skill COLOSSALSWORD_HEAVY_ATTACK;
    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent build){
        SkillBuildEvent.ModRegistryWorker modRegistry = build.createRegistryWorker(EpicFightMod.MODID);

        HAND_HALF_SWORD_HEAVY_ATTACK = modRegistry.build("handhalfsword_heavyattak", HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
                .setAnimations(new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/handhalfsword_heavyattack_1"),
                        new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/handhalfsword_heavyattack_2")));

        COLOSSALSWORD_HEAVY_ATTACK = modRegistry.build("colossalsword_heavyattak",HeavyAttack::new, HeavyAttack.createHeavyAttackBuilder()
                .setAnimations(new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/colossalsword/colossalsword_heavy1"),
                        new ResourceLocation(TheForceLawTweaks.MODID,"biped/combat/colossalsword/colossalsword_heavy2")));

        }
}
