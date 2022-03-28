package pixelgamewizard.bandedtorchesmod.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class ModBlocks
{
    private static final Logger LOGGER = LogManager.getLogger();
    static class TorchBlockRegistryObjects
    {
        public RegistryObject<Block> block;
        public RegistryObject<Block> wallBlock;
        public RegistryObject<Item> item;
    }
    public static final TorchBlockRegistryObjects[] torches = new TorchBlockRegistryObjects[Constants.TORCH_COUNT];

    public static int CalculateTorchIndex(int torchPropertiesIndex, int colourIndex)
    {
        if ( torchPropertiesIndex < 0 || torchPropertiesIndex >= Constants.TORCH_PROPERTIES_ARRAY.length )
        {
            LOGGER.error(
                "Torch Properties index " + torchPropertiesIndex + " is out of bounds. " +
                "Count is " + Constants.TORCH_PROPERTIES_ARRAY.length + ". " +
                "Continuing world load is *NOT* recommended. " +
                "This is a bug in the Banded Torches mod, please report it on the project's GitHub page at: " +
                "https://github.com/pixelgamewizard/pgwbandedtorches/issues" );
            return -1;
        }
        
        if ( colourIndex < 0 || colourIndex >= Constants.COLOUR_ARRAY.length )
        {
            LOGGER.error(
                "Colour index " + torchPropertiesIndex + " is out of bounds. " +
                "Count is " + Constants.COLOUR_ARRAY.length + ". " +
                "Continuing world load is *NOT* recommended. " +
                "This is a bug in the Banded Torches mod, please report it on the project's GitHub page at: " +
                "https://github.com/pixelgamewizard/pgwbandedtorches/issues" );
            return -1;
        }

        return (torchPropertiesIndex * Constants.COLOUR_ARRAY.length) + colourIndex;
    }
}
