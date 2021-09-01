package feedme.minecraft.essentials.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;

@Mixin(HostileEntity.class)
public abstract class HostileEntityMixin {

    @Inject(method = "isSpawnDark", at = @At("RETURN"), cancellable = true)
    private static void eclipseIsSpawnDark(ServerWorldAccess serverWorldAccess, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir){
        if(MinecraftEssentials.CurrentEvent.getName() == "SolarEclipse"){
            cir.setReturnValue(true);
        }
    }
    
}
