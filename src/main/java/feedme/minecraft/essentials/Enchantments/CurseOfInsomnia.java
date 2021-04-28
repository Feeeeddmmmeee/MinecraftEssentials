package feedme.minecraft.essentials.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class CurseOfInsomnia extends Enchantment{

    protected CurseOfInsomnia(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public int getMinPower(int level){
        return 15;
    }

    @Override
    public int getMaxLevel(){
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
  
    @Override
    public boolean isCursed() {
        return true;
    }
    
}
