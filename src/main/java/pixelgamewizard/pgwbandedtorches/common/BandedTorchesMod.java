package pixelgamewizard.pgwbandedtorches.common;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;


@Mod(BandedTorchesMod.MODID)
public class BandedTorchesMod
{
    public static final String MODID = "pgwbandedtorches";

    public BandedTorchesMod(IEventBus modEventBus)
    {
        NeoForge.EVENT_BUS.register(BandedTorchesMod.class);
        RegistrationHandler.init();
    }

    // For some reason the NeoForge API introduced a requirement that mod classes
    // implement a SubscribeEvent, even if there are event handlers elsewhere.
    // https://neoforged.net/news/20.2eventbus-changes/
    @SubscribeEvent
    private static void dummyFunction(final BuildCreativeModeTabContentsEvent ignored) {}
}
