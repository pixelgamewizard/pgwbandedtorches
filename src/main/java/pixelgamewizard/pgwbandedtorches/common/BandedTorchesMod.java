package pixelgamewizard.pgwbandedtorches.common;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
        for (int torchIndex = 0; torchIndex < Constants.TORCH_COUNT; torchIndex++)
        {
            ModBlocks.TorchBlockRegistryObjects torch = ModBlocks.torches[torchIndex];
            ItemBlockRenderTypes.setRenderLayer(torch.block.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(torch.wallBlock.get(), RenderType.cutout());
        }
    }
}
