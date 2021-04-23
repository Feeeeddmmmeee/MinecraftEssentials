package feedme.minecraft.essentials.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.Identifier;

@Mixin(WorldRenderer.class)
public interface WorldRendererAccessor {
    @Accessor("SUN")
    @Mutable
    static void mcessentials$setSunTexture(Identifier newSun) {
        throw new AssertionError();
    }
/*
    @Accessor("RAIN")
    @Mutable
    static void mcessentials$setRainTexture(Identifier newRain) {
        throw new AssertionError();
    }

    @Accessor("darkSkyBuffer")
    @Mutable
    abstract void mcessentials$setDarkSkyBuffer(VertexBuffer newDarkSkyBuffer);

    @Accessor("END_SKY")
    @Mutable
    static void mcessentials$setEndSkyTexture(Identifier newSky) {
        throw new AssertionError();
    }

    @Accessor("CLOUDS")
    @Mutable
    static void mcessentials$setCloudsTexture(Identifier newClouds) {
        throw new AssertionError();
    }

    @Invoker("renderDarkSky") public void mcessentials$renderDarkSky();

    @Invoker("renderLightSky") public void mcessentials$renderLightSky();
*/
}