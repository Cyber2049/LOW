package com.nameless.theforcelawtweaks.world.entity;

import com.nameless.theforcelawtweaks.main.TheForceLawTweaks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BossEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheForceLawTweaks.MODID);
    public static final RegistryObject<EntityType<CowDevilEntity>> COWDEVIL =
            ENTITIES.register("cow_devil", () -> EntityType.Builder.<CowDevilEntity>of(CowDevilEntity::new, MobCategory.MISC)
                    .sized(1.25f, 1.25f)
                    .clientTrackingRange(64).build("cow_devil"));

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(COWDEVIL.get(), CowDevilEntity.createAttributes().build());
    }

}
