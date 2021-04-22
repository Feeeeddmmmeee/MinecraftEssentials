package feedme.minecraft.essentials.Items;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BattleAxes {
    
    public static ToolItem WOODEN_BATTLE_AXE = new SwordItem(ToolMaterials.WOOD, 5, -3.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem STONE_BATTLE_AXE = new SwordItem(ToolMaterials.STONE, 5, -3.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem GOLDEN_BATTLE_AXE = new SwordItem(ToolMaterials.GOLD, 5, -3.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem IRON_BATTLE_AXE = new SwordItem(ToolMaterials.IRON, 5, -3.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem DIAMOND_BATTLE_AXE = new SwordItem(ToolMaterials.DIAMOND, 6, -3.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem NETHERITE_BATTLE_AXE = new SwordItem(ToolMaterials.NETHERITE, 6, -3.4f, new Item.Settings().group(ItemGroup.COMBAT));

    public static void registerBattleaxes(){
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "wooden_battle_axe"), WOODEN_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "stone_battle_axe"), STONE_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "golden_battle_axe"), GOLDEN_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "iron_battle_axe"), IRON_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "diamond_battle_axe"), DIAMOND_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "netherite_battle_axe"), NETHERITE_BATTLE_AXE);
    }

}
