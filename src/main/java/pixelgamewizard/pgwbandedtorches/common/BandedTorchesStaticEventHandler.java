package pixelgamewizard.pgwbandedtorches.common;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(
   modid = BandedTorchesMod.MODID,
   bus = Bus.MOD)
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
            ModBlocks.TorchBlockDeferredHolders torch = ModBlocks.torches[torchIndex];
            event.accept(torch.item.get());
         }
      }
   }
}
