package pixelgamewizard.pgwbandedtorches.common;

import net.neoforged.fml.common.Mod;


@Mod(BandedTorchesMod.MODID)
public class BandedTorchesMod
{
    public static final String MODID = "pgwbandedtorches";

    public BandedTorchesMod()
    {
        RegistrationHandler.init();
    }
}
