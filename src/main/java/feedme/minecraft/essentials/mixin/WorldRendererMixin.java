package feedme.minecraft.essentials.mixin;

import com.mojang.blaze3d.systems.RenderSystem;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.client.world.ClientWorld;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin implements WorldRendererAccessor{

    @Shadow private ClientWorld world;
    @Shadow private VertexFormat skyVertexFormat;
    @Shadow private VertexBuffer darkSkyBuffer;
    @Shadow protected abstract void renderSkyHalf(BufferBuilder buffer, float y, boolean bottom);
    @Shadow protected abstract void renderEndSky(MatrixStack matrixStack);

    @Inject(method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;getMoonPhase()I"))
    private void changeMoonColor(MatrixStack matrixStackIn, float partialTicks, CallbackInfo ci) {
        if(MinecraftEssentials.CurrentEvent.getName() == "BloodMoon"){
            Vector3f glColor = MinecraftEssentials.transformToVectorColor(MinecraftEssentials.CurrentEvent.modifyMoonColor());
            RenderSystem.color4f(glColor.getX(), glColor.getY(), glColor.getZ(), 1.0F - this.world.getRainGradient(partialTicks));
        }

    }

    @Inject(method = "renderSky", at = @At("RETURN"))
    public void renderSky(MatrixStack matrixStack, float f, CallbackInfo ci) {
        //WorldRendererAccessor.mcessentials$setCloudsTexture(new Identifier(MinecraftEssentials.MOD_ID, "textures/solar_eclipse/eclipse_clouds.png"));
        //WorldRendererAccessor.mcessentials$setEndSkyTexture(new Identifier(MinecraftEssentials.MOD_ID, "textures/solar_eclipse/solar_eclipse_sky.png"));
        //this.renderEndSky(matrixStack);
    }
}