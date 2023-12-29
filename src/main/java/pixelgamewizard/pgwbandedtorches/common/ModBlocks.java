package pixelgamewizard.pgwbandedtorches.common;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class ModBlocks
{
    private static final Logger LOGGER = LogManager.getLogger();
    static class TorchBlockDeferredHolders
    {
        public DeferredHolder<Block, TorchBlock> block;
        public DeferredHolder<Block, TorchBlock> wallBlock;
        public DeferredHolder<Item, StandingAndWallBlockItem> item;
    }
    public static final TorchBlockDeferredHolders[] torches = new TorchBlockDeferredHolders[Constants.TORCH_COUNT];

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
