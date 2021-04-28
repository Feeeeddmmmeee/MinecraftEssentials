package feedme.minecraft.essentials.Enchantments;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentRegistry {
    
    public static final Enchantment CURSE_OF_INSOMNIA = new CurseOfInsomnia(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEARABLE, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});

    public static void registerEnchantments(){

        Registry.register(Registry.ENCHANTMENT, new Identifier(MinecraftEssentials.MOD_ID, "curse_of_insomnia"), CURSE_OF_INSOMNIA);

    }

}
