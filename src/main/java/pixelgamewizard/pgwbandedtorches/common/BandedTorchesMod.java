package pixelgamewizard.pgwbandedtorches.common;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;


@Mod(BandedTorchesMod.MODID)
public class BandedTorchesMod
{
    public static final String MODID = "pgwbandedtorches";

    public BandedTorchesMod(IEventBus eventBus)
    {
        RegistrationHandler.init(eventBus);
    }
}
