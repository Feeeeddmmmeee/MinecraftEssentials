package feedme.minecraft.essentials.Items;

import feedme.minecraft.essentials.MinecraftEssentials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Daggers {
    
    public static ToolItem WOODEN_DAGGER = new SwordItem(ToolMaterials.WOOD, 2, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem STONE_DAGGER = new SwordItem(ToolMaterials.STONE, 2, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem GOLDEN_DAGGER = new SwordItem(ToolMaterials.GOLD, 2, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem IRON_DAGGER = new SwordItem(ToolMaterials.IRON, 2, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem DIAMOND_DAGGER = new SwordItem(ToolMaterials.DIAMOND, 2, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem NETHERITE_DAGGER = new SwordItem(ToolMaterials.NETHERITE, 2, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));

    public static void registerDaggers(){
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "wooden_dagger"), WOODEN_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "stone_dagger"), STONE_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "golden_dagger"), GOLDEN_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "iron_dagger"), IRON_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "diamond_dagger"), DIAMOND_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(MinecraftEssentials.MOD_ID, "netherite_dagger"), NETHERITE_DAGGER);
    }

}
