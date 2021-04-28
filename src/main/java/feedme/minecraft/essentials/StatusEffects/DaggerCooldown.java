package feedme.minecraft.essentials.StatusEffects;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DaggerCooldown extends StatusEffect{
    public DaggerCooldown(){
        super(
            StatusEffectType.HARMFUL,
            0x98D982);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
      return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        
    }

    public static DaggerCooldown DAGGER_COOLDOWN = new DaggerCooldown();

    public static void registerDaggerCooldown(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MinecraftEssentials.MOD_ID, "dagger_cooldown"), DAGGER_COOLDOWN);
    }
    
}
