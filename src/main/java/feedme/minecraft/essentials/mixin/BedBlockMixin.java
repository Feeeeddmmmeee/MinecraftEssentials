package feedme.minecraft.essentials.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(BedBlock.class)
public class BedBlockMixin {
    
    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void cannotSleep(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit, CallbackInfoReturnable<ActionResult> callbackinforeturnable){
        if(MinecraftEssentials.CurrentEvent.cantSleep()){
            callbackinforeturnable.setReturnValue(ActionResult.FAIL);
            if(MinecraftEssentials.CurrentEvent.getName() == "BloodMoon"){
                player.sendMessage(new LiteralText("You cannot sleep during Blood Moons!"), true);
            }
            if(MinecraftEssentials.CurrentEvent.getName() == "SolarEclipse"){
                player.sendMessage(new LiteralText("You cannot sleep during Solar Eclipses!"), true);
            }
        }
    }

}
