package feedme.minecraft.essentials.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.Identifier;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererSunMixin implements WorldRendererAccessor{

    @Inject(method = "tick", at = @At("HEAD"))
    public void updateSun(CallbackInfo ci) {
        if(MinecraftEssentials.CurrentEvent.getName() == "SolarEclipse"){
            WorldRendererAccessor.mcessentials$setSunTexture(new Identifier(MinecraftEssentials.MOD_ID, "textures/solar_eclipse/sun_during_eclipse.png"));
            //((WorldRendererAccessor) MinecraftClient.getInstance().worldRenderer).mcessentials$renderDarkSky();
            
        }
        else{
            WorldRendererAccessor.mcessentials$setSunTexture(new Identifier(MinecraftEssentials.MOD_ID, "textures/solar_eclipse/sun.png"));
            //((WorldRendererAccessor) MinecraftClient.getInstance().worldRenderer).mcessentials$renderLightSky();
        }
    }

}