package pixelgamewizard.bandedtorchesmod.client;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import pixelgamewizard.bandedtorchesmod.common.BandedTorchesMod;
import pixelgamewizard.bandedtorchesmod.common.ModBlocks;

@EventBusSubscriber(value = Side.CLIENT, modid = BandedTorchesMod.MODID)
public class ModelRegistrationHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_WHITE);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_ORANGE);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_MAGENTA);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_LIGHT_BLUE);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_YELLOW);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_LIME);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_PINK);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_GRAY);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_LIGHT_GRAY);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_CYAN);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_PURPLE);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_BLUE);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_BROWN);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_GREEN);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_RED);
        registerBandedTorchModelItem(ModBlocks.BANDED_TORCH_BLACK);
    }

    private static void registerBandedTorchModelItem(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        String iconFileName = "";
        if (BandedTorchesMod.CONFIGURATION.getUseDistinctInventoryIcon())
        {
            iconFileName = item.getRegistryName() + "_distinct";
        }
        else
        {
            iconFileName = item.getRegistryName() + "";
        }
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(iconFileName, "inventory"));
    }
}
