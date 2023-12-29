package pixelgamewizard.pgwbandedtorches.common;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(
   modid = BandedTorchesMod.MODID,
   bus = Mod.EventBusSubscriber.Bus.MOD)
public class BandedTorchesStaticEventHandler
{
   @SubscribeEvent
   public static void handleCreativeModeTabEvent(final BuildCreativeModeTabContentsEvent event)
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
