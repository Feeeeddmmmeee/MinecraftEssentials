package feedme.minecraft.essentials.Events;

import net.minecraft.client.util.math.Vector3f;

import java.awt.*;

public class BloodMoon extends Event{

    public BloodMoon(){
        super(5, "BloodMoon");
    }

    @Override
    public Color modifyMoonColor() {
        return new Color(166, 16, 30, 255);
    }

    @Override
    public boolean modifySkyLightMapColor(Vector3f lightMapSkyColor) {
        if (lightMapSkyColor != null)
            lightMapSkyColor.lerp(new Vector3f(2.0F, 0, 0), 1.0F);
        return true;
    }

    @Override
    public boolean modifyColors() {
        return true;
    }

    @Override
    public boolean cantSleep(){
        return true;
    }
}
