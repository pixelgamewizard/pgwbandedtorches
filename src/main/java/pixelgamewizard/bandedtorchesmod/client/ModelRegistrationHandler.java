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
        registerModel(ModBlocks.BANDED_TORCH_WHITE);
        registerModel(ModBlocks.BANDED_TORCH_ORANGE);
        registerModel(ModBlocks.BANDED_TORCH_MAGENTA);
        registerModel(ModBlocks.BANDED_TORCH_LIGHT_BLUE);
        registerModel(ModBlocks.BANDED_TORCH_YELLOW);
        registerModel(ModBlocks.BANDED_TORCH_LIME);
        registerModel(ModBlocks.BANDED_TORCH_PINK);
        registerModel(ModBlocks.BANDED_TORCH_GRAY);
        registerModel(ModBlocks.BANDED_TORCH_LIGHT_GRAY);
        registerModel(ModBlocks.BANDED_TORCH_CYAN);
        registerModel(ModBlocks.BANDED_TORCH_PURPLE);
        registerModel(ModBlocks.BANDED_TORCH_BLUE);
        registerModel(ModBlocks.BANDED_TORCH_BROWN);
        registerModel(ModBlocks.BANDED_TORCH_GREEN);
        registerModel(ModBlocks.BANDED_TORCH_RED);
        registerModel(ModBlocks.BANDED_TORCH_BLACK);
    }

    private static void registerModel(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}