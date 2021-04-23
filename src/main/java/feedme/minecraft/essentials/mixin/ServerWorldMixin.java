package feedme.minecraft.essentials.mixin;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import feedme.minecraft.essentials.MinecraftEssentials;
import feedme.minecraft.essentials.Events.BloodMoon;
import feedme.minecraft.essentials.Events.DefaultEvent;
import feedme.minecraft.essentials.Events.SolarEclipse;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World{
    
    protected ServerWorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef,
            DimensionType dimensionType, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long seed) {
        super(properties, registryRef, dimensionType, profiler, isClient, debugWorld, seed);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void setEvent(BooleanSupplier boolsup, CallbackInfo info){

        if(this.isDay() && MinecraftEssentials.CurrentEvent.getName() == "BloodMoon"){
            MinecraftEssentials.CurrentEvent = new DefaultEvent();
        }

        if(this.isNight() && MinecraftEssentials.CurrentEvent.getName() == "SolarEclipse"){
            MinecraftEssentials.CurrentEvent = new DefaultEvent();
        }

        if(this.getLevelProperties().getTimeOfDay() % 24000 == 13001 && this.isNight()){
            MinecraftEssentials.CurrentEvent = new DefaultEvent();
            int eventChance = this.random.nextInt(100);
            if(eventChance < 15){ //5
                MinecraftEssentials.CurrentEvent = new BloodMoon();
                ((ServerWorld) (Object) this).getPlayers().forEach(player -> {
                    player.sendMessage(new LiteralText("The Blood Moon is rising..."), false);
                });
            }
        }
        if(this.getLevelProperties().getTimeOfDay() % 24000 == 1 && this.isDay()){
            MinecraftEssentials.CurrentEvent = new DefaultEvent();
            int eventChance = this.random.nextInt(100);
            if(eventChance < 8){ //5
                MinecraftEssentials.CurrentEvent = new SolarEclipse();
                ((ServerWorld) (Object) this).getPlayers().forEach(player -> {
                    player.sendMessage(new LiteralText("A Solar Eclipse is happening!"), false);
                });
            }
        }
    }
}
