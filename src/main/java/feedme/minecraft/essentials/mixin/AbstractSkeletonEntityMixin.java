package feedme.minecraft.essentials.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

@Mixin(AbstractSkeletonEntity.class)
public abstract class AbstractSkeletonEntityMixin extends HostileEntity implements RangedAttackMob {

    protected AbstractSkeletonEntityMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean burnsInDaylight() {
        return false;
    }

    @Inject(method = "tickMovement", at = @At("HEAD"), cancellable = true)
    public void cancelFireSkeleton(CallbackInfo ci) {
        if (this.isAlive()) {
            boolean bl = this.burnsInDaylight();
            bl = this.isAffectedByDaylight() && MinecraftEssentials.CurrentEvent.getName() != "SolarEclipse";
            if (bl) {
                this.setOnFireFor(8);
            }
            super.tickMovement();
            ci.cancel();
        }
    }
    
}