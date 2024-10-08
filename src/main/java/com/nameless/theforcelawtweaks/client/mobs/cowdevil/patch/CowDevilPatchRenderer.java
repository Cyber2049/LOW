package com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch;

import com.nameless.theforcelawtweaks.client.mobs.cowdevil.oringal.CowDevilModel;
import com.nameless.theforcelawtweaks.gameasset.Meshs;
import com.nameless.theforcelawtweaks.world.capabilities.entity.CowDevilPatch;
import com.nameless.theforcelawtweaks.world.entity.CowDevilEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.client.renderer.patched.entity.PatchedLivingEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class CowDevilPatchRenderer extends PatchedLivingEntityRenderer<CowDevilEntity, CowDevilPatch, CowDevilModel<CowDevilEntity>, CowDevilMesh> {
    public CowDevilPatchRenderer() {
    }

    @Override
    public CowDevilMesh getMesh(CowDevilPatch cowDevilPatch) {
        return Meshs.cowDevilMesh;
    }

    @Override
    protected void setJointTransforms(CowDevilPatch entitypatch, Armature armature, float partialTicks) {
        this.setJointTransform("Head", armature, entitypatch.getHeadMatrix(partialTicks));
    }
}
