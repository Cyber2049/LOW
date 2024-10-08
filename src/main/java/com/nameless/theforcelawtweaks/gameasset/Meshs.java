package com.nameless.theforcelawtweaks.gameasset;

import com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch.CowDevilMesh;
import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;

public class Meshs {
    public static CowDevilMesh cowDevilMesh;
    public static void build(ModelBuildEvent.MeshBuild event) {
        cowDevilMesh = event.getAnimated(TheForceLawTweaks.MODID, "entity/cow_devil", CowDevilMesh::new);
    }
}
