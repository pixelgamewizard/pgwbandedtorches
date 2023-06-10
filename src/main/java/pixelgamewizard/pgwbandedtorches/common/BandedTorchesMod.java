package pixelgamewizard.pgwbandedtorches.common;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(BandedTorchesMod.MODID)
public class BandedTorchesMod
{
    public static final String MODID = "pgwbandedtorches";

    public BandedTorchesMod()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::handleCreativeModeTabEvent);
        MinecraftForge.EVENT_BUS.register(this);
        RegistrationHandler.init();
    }

    private void handleCreativeModeTabEvent(final BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || 
            event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS)
        {
            for (int torchIndex = 0; torchIndex < Constants.TORCH_COUNT; torchIndex++)
            {
                ModBlocks.TorchBlockRegistryObjects torch = ModBlocks.torches[torchIndex];
                event.accept(torch.item);
            }
        }
    }
}
