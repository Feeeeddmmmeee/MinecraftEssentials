package feedme.minecraft.essentials.StatusEffects;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BleedingStatusEffect extends StatusEffect{
    public BleedingStatusEffect(){
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
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).damage(DamageSource.MAGIC, 1.0f);
        }
    }

    public static BleedingStatusEffect BLEEDING = new BleedingStatusEffect();

    public static void registerBleeding(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MinecraftEssentials.MOD_ID, "bleeding"), BLEEDING);
    }
    
}
