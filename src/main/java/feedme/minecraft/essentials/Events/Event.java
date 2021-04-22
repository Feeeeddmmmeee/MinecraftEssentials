package feedme.minecraft.essentials.Events;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.Vector3f;

import java.awt.*;

public class Event {
    private final int chance;
    private String eventName;

    @Environment(EnvType.CLIENT)
    public Color modifyMoonColor() {
        return null;
    }

    @Environment(EnvType.CLIENT)
    public boolean modifySkyLightMapColor(Vector3f lightMapSkyColor){
        return false;
    }

    public Event(int chance, String name){
        this.chance = chance;
        this.eventName = name;
    }

    public final double getChance(){
        return this.chance;
    }

    public String getName(){
        return this.eventName;
    }

    public boolean modifyColors() {
        return false;
    }

    public boolean cantSleep(){
        return false;
    }

}
