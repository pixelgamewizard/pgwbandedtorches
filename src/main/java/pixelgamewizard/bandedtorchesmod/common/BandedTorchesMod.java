package pixelgamewizard.bandedtorchesmod.common;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(BandedTorchesMod.MODID)
public class BandedTorchesMod
{
    public static final String MODID = "pgwbandedtorches";

    public BandedTorchesMod()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        RegistrationHandler.init();
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        for (int colourIndex = 0; colourIndex < Constants.COLOURS.length; colourIndex++)
        {
            ModBlocks.TorchBlockRegistryObjects torch = ModBlocks.torches[colourIndex];
            RenderTypeLookup.setRenderLayer(torch.block.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(torch.wallBlock.get(), RenderType.cutout());
        }
    }
}
