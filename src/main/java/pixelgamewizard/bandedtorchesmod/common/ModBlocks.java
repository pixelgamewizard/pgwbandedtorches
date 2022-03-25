package pixelgamewizard.bandedtorchesmod.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;


public class ModBlocks
{
    static class TorchBlockRegistryObjects
    {
        public RegistryObject<Block> block;
        public RegistryObject<Block> wallBlock;
        public RegistryObject<Item> item;
    }
    public static final TorchBlockRegistryObjects[] torches = new TorchBlockRegistryObjects[Constants.COLOURS.length];
}
