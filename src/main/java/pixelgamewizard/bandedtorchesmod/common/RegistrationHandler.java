package pixelgamewizard.bandedtorchesmod.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber(modid = BandedTorchesMod.MODID)
public class RegistrationHandler {
    
    @SubscribeEvent
    public static void registerBlocks(Register<Block> event)
    {
        String[] colors = {
            "white",
            "orange",
            "magenta",
            "light_blue",
            "yellow",
            "lime",
            "pink",
            "gray",
            "light_gray",
            "cyan",
            "purple",
            "blue",
            "brown",
            "green",
            "red",
            "black"
        };
        for (String color : colors)
        {
            String bandedTorchID = "banded_torch_" + color;
            BlockBandedTorch bandedTorch = new BlockBandedTorch();
            bandedTorch.setRegistryName(BandedTorchesMod.MODID, bandedTorchID);
            bandedTorch.setTranslationKey(BandedTorchesMod.MODID + "." + bandedTorchID);
            bandedTorch.setCreativeTab(CreativeTabs.DECORATIONS);
            event.getRegistry().register(bandedTorch);
        }
    }
    
    @SubscribeEvent
    public static void registerItems(Register<Item> event)
    {
        Block[] blocks = {
            ModBlocks.BANDED_TORCH_WHITE,
            ModBlocks.BANDED_TORCH_ORANGE,
            ModBlocks.BANDED_TORCH_MAGENTA,
            ModBlocks.BANDED_TORCH_LIGHT_BLUE,
            ModBlocks.BANDED_TORCH_YELLOW,
            ModBlocks.BANDED_TORCH_LIME,
            ModBlocks.BANDED_TORCH_PINK,
            ModBlocks.BANDED_TORCH_GRAY,
            ModBlocks.BANDED_TORCH_LIGHT_GRAY,
            ModBlocks.BANDED_TORCH_CYAN,
            ModBlocks.BANDED_TORCH_PURPLE,
            ModBlocks.BANDED_TORCH_BLUE,
            ModBlocks.BANDED_TORCH_BROWN,
            ModBlocks.BANDED_TORCH_GREEN,
            ModBlocks.BANDED_TORCH_RED,
            ModBlocks.BANDED_TORCH_BLACK
        };
        for (Block block : blocks)
        {
            ItemBlock caveCrystalBlockItem = new ItemBlock(block);
            caveCrystalBlockItem.setRegistryName(block.getRegistryName());
            String translationKey = block.getRegistryName().toString().replace(':','.');
            caveCrystalBlockItem.setTranslationKey(translationKey);
            event.getRegistry().register(caveCrystalBlockItem);
        }
    }
    
    public static void regsiterBlocksToOreDicts()
    {
        Block[] blocks = {
            ModBlocks.BANDED_TORCH_WHITE,
            ModBlocks.BANDED_TORCH_ORANGE,
            ModBlocks.BANDED_TORCH_MAGENTA,
            ModBlocks.BANDED_TORCH_LIGHT_BLUE,
            ModBlocks.BANDED_TORCH_YELLOW,
            ModBlocks.BANDED_TORCH_LIME,
            ModBlocks.BANDED_TORCH_PINK,
            ModBlocks.BANDED_TORCH_GRAY,
            ModBlocks.BANDED_TORCH_LIGHT_GRAY,
            ModBlocks.BANDED_TORCH_CYAN,
            ModBlocks.BANDED_TORCH_PURPLE,
            ModBlocks.BANDED_TORCH_BLUE,
            ModBlocks.BANDED_TORCH_BROWN,
            ModBlocks.BANDED_TORCH_GREEN,
            ModBlocks.BANDED_TORCH_RED,
            ModBlocks.BANDED_TORCH_BLACK
        };
        for (Block block : blocks)
        {
            OreDictionary.registerOre("torch", block);
            OreDictionary.registerOre("blockTorch", block);
        }
    }
}
