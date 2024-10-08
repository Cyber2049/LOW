package com.nameless.theforcelawtweaks.gameasset;

import com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch.CowDevilArmature;
import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import com.nameless.theforcelawtweaks.world.entity.BossEntities;
import yesman.epicfight.api.forgeevent.ModelBuildEvent.ArmatureBuild;

import static yesman.epicfight.gameasset.Armatures.registerEntityTypeArmature;

public class Armatures {
    public static CowDevilArmature cowDevilArmature;
    public static void build(ArmatureBuild event) {
        cowDevilArmature = event.get(TheForceLawTweaks.MODID, "entity/cow_devil", CowDevilArmature::new);
        registerEntityTypeArmature(BossEntities.COWDEVIL.get(), cowDevilArmature);
    }
}
