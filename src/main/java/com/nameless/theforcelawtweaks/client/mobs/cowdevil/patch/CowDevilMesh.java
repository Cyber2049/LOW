package com.nameless.theforcelawtweaks.client.mobs.cowdevil.patch;

import yesman.epicfight.api.client.model.AnimatedMesh;
import yesman.epicfight.api.client.model.ModelPart;
import yesman.epicfight.api.client.model.VertexIndicator.AnimatedVertexIndicator;

import java.util.Map;

public class CowDevilMesh extends AnimatedMesh {
    public CowDevilMesh(Map<String, float[]> arrayMap, AnimatedMesh parent, RenderProperties properties, Map<String, ModelPart<AnimatedVertexIndicator>> parts) {
        super(arrayMap, parent, properties, parts);
    }
}
