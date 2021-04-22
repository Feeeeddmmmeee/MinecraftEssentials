package feedme.minecraft.essentials.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {

    @Shadow private ClientWorld world;

    @Inject(method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;getMoonPhase()I"))
    private void changeMoonColor(MatrixStack matrixStackIn, float partialTicks, CallbackInfo ci) {
        if(MinecraftEssentials.CurrentEvent.getName() == "BloodMoon"){
            Vector3f glColor = MinecraftEssentials.transformToVectorColor(MinecraftEssentials.CurrentEvent.modifyMoonColor());
            RenderSystem.color4f(glColor.getX(), glColor.getY(), glColor.getZ(), 1.0F - this.world.getRainGradient(partialTicks));
        }
    }
}