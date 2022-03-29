package pixelgamewizard.pgwbandedtorches.common;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;

public class Constants
{
    public static final String[] COLOUR_ARRAY =
    {
        "white",
        "orange",
        "magenta",
        "light_blue",
        "yellow",
        "lime",
        "pink",
        "gray",
        "light_gray",
        "cyan",
        "purple",
        "blue",
        "brown",
        "green",
        "red",
        "black"
    };

    public static class TorchProperties
    {
        public TorchProperties( String name, int lightLevel, SimpleParticleType particleType )
        {
            this.name = name;
            this.lightLevel = lightLevel;
            this.particleType = particleType;
        }
        public String name;
        public int lightLevel;
        public SimpleParticleType particleType;
    }
    public static final TorchProperties[] TORCH_PROPERTIES_ARRAY =
    {
        new TorchProperties( "torch", 14, ParticleTypes.FLAME ),
        new TorchProperties( "soul_torch", 10, ParticleTypes.SOUL_FIRE_FLAME )
    };

    public static final int TORCH_COUNT = Constants.TORCH_PROPERTIES_ARRAY.length * Constants.COLOUR_ARRAY.length;
}
