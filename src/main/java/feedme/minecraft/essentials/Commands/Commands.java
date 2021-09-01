package feedme.minecraft.essentials.Commands;

import feedme.minecraft.essentials.MinecraftEssentials;
import feedme.minecraft.essentials.Events.BloodMoon;
import feedme.minecraft.essentials.Events.DefaultEvent;
import feedme.minecraft.essentials.Events.SolarEclipse;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;

public class Commands {
    
    public static void registerCommands(){
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("event")
                .then(CommandManager.literal("solareclipse")
                    .executes(context -> {
                        MinecraftEssentials.CurrentEvent = new SolarEclipse();
            
                        return 1;
                    })
                )
            );
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("event")
                .then(CommandManager.literal("bloodmoon")
                    .executes(context -> {
                        MinecraftEssentials.CurrentEvent = new BloodMoon();
            
                        return 1;
                    })
                )
            );
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(CommandManager.literal("event")
                .then(CommandManager.literal("clear")
                    .executes(context -> {
                        MinecraftEssentials.CurrentEvent = new DefaultEvent();
            
                        return 1;
                    })
                )
            );
        });

    }

}
