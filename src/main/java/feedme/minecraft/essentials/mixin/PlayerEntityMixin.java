package feedme.minecraft.essentials.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import feedme.minecraft.essentials.MinecraftEssentials;
import feedme.minecraft.essentials.Items.Daggers;
import feedme.minecraft.essentials.StatusEffects.BleedingStatusEffect;
import feedme.minecraft.essentials.StatusEffects.DaggerCooldown;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void applyBleeding(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if(!source.getMagic()){
            if(MinecraftEssentials.CurrentEvent.getName() == "BloodMoon"){
                this.applyStatusEffect(new StatusEffectInstance(BleedingStatusEffect.BLEEDING, 60, 0, false, false, true));
            }
        }
    }

    @Inject(method = "attack", at = @At("HEAD"))
    private void daggerCooldown(Entity target, CallbackInfo ci){
        if(target instanceof LivingEntity){
            if(this.getMainHandStack().isItemEqual(Daggers.NETHERITE_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.DIAMOND_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.IRON_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.GOLDEN_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.STONE_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.WOODEN_DAGGER.getDefaultStack())){
                if(!this.hasStatusEffect(DaggerCooldown.DAGGER_COOLDOWN)) {
                    this.clearStatusEffects();
                    this.applyStatusEffect(new StatusEffectInstance(DaggerCooldown.DAGGER_COOLDOWN, 1200, 0, false, false, true));
                    target.damage(DamageSource.player((PlayerEntity) (Entity) this), 10.0f);
                }
            }
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void daggerInvisibilty(CallbackInfo ci) {
    
        if(this.getMainHandStack().isItemEqual(Daggers.NETHERITE_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.DIAMOND_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.IRON_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.GOLDEN_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.STONE_DAGGER.getDefaultStack()) || this.getMainHandStack().isItemEqual(Daggers.WOODEN_DAGGER.getDefaultStack())){
            if(!this.hasStatusEffect(DaggerCooldown.DAGGER_COOLDOWN)){
                this.applyStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 25, 0, false, false, false));
            }
        }

    }
}
