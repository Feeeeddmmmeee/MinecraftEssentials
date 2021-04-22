package feedme.minecraft.essentials.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import feedme.minecraft.essentials.MinecraftEssentials;
import feedme.minecraft.essentials.StatusEffects.BleedingStatusEffect;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void applyBleeding(DamageSource source, float amount, CallbackInfoReturnable cir){
        if(!source.getMagic()){
            if(MinecraftEssentials.CurrentEvent.getName() == "BloodMoon"){
                this.applyStatusEffect(new StatusEffectInstance(BleedingStatusEffect.BLEEDING, 60, 1));
            }
        }
    }
    
}
