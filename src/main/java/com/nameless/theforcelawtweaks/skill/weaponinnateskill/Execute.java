package com.nameless.theforcelawtweaks.skill.weaponinnateskill;

import com.nameless.theforcelawtweaks.gameasset.animation.TFLAnimations;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.types.LongHitAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.network.server.SPPlayAnimation;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.effect.EpicFightMobEffects;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Mod.EventBusSubscriber
public class Execute {
    private static final ArrayList<CapabilityItem.WeaponCategories> execute = new ArrayList<>();
    static {
        execute.add(CapabilityItem.WeaponCategories.SWORD);
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRightClickEntity(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getEntity(), event.getLevel());
    }


    private static void execute(@Nullable Event event, Player player, Level level) {
        if (player == null) return;
        if (!level.isClientSide())
        {
            final Vec3 _center = new Vec3(player.getX(), player.getEyeY(), player.getZ());
            List<LivingEntity> _entfound = level.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (LivingEntity entityiterator : _entfound) {
                LivingEntityPatch<?> ep = EpicFightCapabilities.getEntityPatch(entityiterator, LivingEntityPatch.class);
                if (ep != null && (entityiterator != player)) {
                    PlayerPatch<?> pp = EpicFightCapabilities.getEntityPatch(player, PlayerPatch.class);
                    if ((ep.getAnimator().getPlayerFor(null).getAnimation() instanceof StaticAnimation staticAnimation && (staticAnimation == Animations.BIPED_KNEEL)) |
                            (ep.getAnimator().getPlayerFor(null).getAnimation() instanceof LongHitAnimation longHitAnimation && ((longHitAnimation == Animations.WITHER_NEUTRALIZED)
                                    | (longHitAnimation == Animations.VEX_NEUTRALIZED) | (longHitAnimation == Animations.SPIDER_NEUTRALIZED)
                                    | (longHitAnimation == Animations.DRAGON_NEUTRALIZED) | (longHitAnimation == Animations.ENDERMAN_NEUTRALIZED)
                                    | (longHitAnimation == Animations.BIPED_COMMON_NEUTRALIZED) | (longHitAnimation == Animations.GREATSWORD_GUARD_BREAK)))) {
                        Vec3 viewVec = ep.getOriginal().getViewVector(1.0F);
                        pp.setGrapplingTarget(ep.getOriginal());
                        if (pp instanceof LocalPlayerPatch lpp) {
                            lpp.setLockOn(true);
                            lpp.toggleLockOn();
                        }
                        player.addEffect(new MobEffectInstance(EpicFightMobEffects.STUN_IMMUNITY.get(),80 , 0));
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,50 , 1));
                        ep.getOriginal().addEffect(new MobEffectInstance(EpicFightMobEffects.STUN_IMMUNITY.get(), 30, 0));
                        ep.playSound(EpicFightSounds.NEUTRALIZE_BOSSES.get(), 1.0F, 1.0F);
                        player.teleportTo(ep.getOriginal().getX() + viewVec.x() * 1.85, ep.getOriginal().getY(), ep.getOriginal().getZ() + viewVec.z() * 1.85);
                        player.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(ep.getOriginal().getX(), ep.getOriginal().getEyeY() - 0.1, ep.getOriginal().getZ()));
                        ep.getOriginal().lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(player.getX(), player.getEyeY() - 0.1, player.getZ()));
                        pp.playAnimationSynchronized(TFLAnimations.EXECUTE, 0.0F);
                        ep.playAnimationSynchronized(TFLAnimations.EXECUTEED, 0.65F, SPPlayAnimation::new);
                        break;
                    }
                }
            }
        }
    }
}
