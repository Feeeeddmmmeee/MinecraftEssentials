package feedme.minecraft.essentials;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.util.math.Vector3f;
import feedme.minecraft.essentials.Commands.Commands;
import feedme.minecraft.essentials.Events.DefaultEvent;
import feedme.minecraft.essentials.Events.Event;
import feedme.minecraft.essentials.Items.BattleAxes;
import feedme.minecraft.essentials.Items.Daggers;
import feedme.minecraft.essentials.StatusEffects.BleedingStatusEffect;
import feedme.minecraft.essentials.StatusEffects.DaggerCooldown;

import java.awt.*;

public class MinecraftEssentials implements ModInitializer {

	public static final String MOD_ID = "mcessentials";
	public static Event CurrentEvent = new DefaultEvent();


	public static Vector3f transformToVectorColor(Color color) {
        int rgbColor = color.getRGB();
        float r = (float) (rgbColor >> 16 & 255) / 255.0F;
        float g = (float) (rgbColor >> 8 & 255) / 255.0F;
        float b = (float) (rgbColor & 255) / 255.0F;
        return new Vector3f(r, g, b);
    }

	@Override
	public void onInitialize() {

		BattleAxes.registerBattleaxes();
		BleedingStatusEffect.registerBleeding();
		Commands.registerCommands();
		DaggerCooldown.registerDaggerCooldown();
		Daggers.registerDaggers();

	}
}
