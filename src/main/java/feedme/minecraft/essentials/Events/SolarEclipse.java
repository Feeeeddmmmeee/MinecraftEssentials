package feedme.minecraft.essentials.Events;

import net.minecraft.client.util.math.Vector3f;

public class SolarEclipse extends Event{
    public SolarEclipse(){
        super(5, "SolarEclipse");
    }

    @Override
    public boolean modifySkyLightMapColor(Vector3f lightMapSkyColor) {
        if (lightMapSkyColor != null)
            lightMapSkyColor.lerp(new Vector3f(-0.2F, -0.2f, -0.2f), 1.0F);
        return true;
    }

    @Override
    public boolean modifyColors(){
        return true;
    }

    @Override
    public boolean cantSleep(){
        return true;
    }
}
