package feedme.minecraft.essentials.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.world.World;

@Mixin(PhantomEntity.class)
public abstract class PhantomEntityMixin extends FlyingEntity implements Monster {


    protected PhantomEntityMixin(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean burnsInDaylight() {
        return false;
    }

    @Inject(method = "tickMovement", at = @At("HEAD"), cancellable = true)
    public void cancelFireZombie(CallbackInfo ci) {
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