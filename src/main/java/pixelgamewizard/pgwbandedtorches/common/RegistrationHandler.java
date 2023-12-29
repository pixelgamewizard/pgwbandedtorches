package pixelgamewizard.pgwbandedtorches.common;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import pixelgamewizard.pgwbandedtorches.common.Constants.TorchProperties;


public class RegistrationHandler
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, BandedTorchesMod.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, BandedTorchesMod.MODID);
    static
    {
        for (int torchPropertiesIndex = 0; torchPropertiesIndex < Constants.TORCH_PROPERTIES_ARRAY.length; torchPropertiesIndex++)
        {
            TorchProperties torchProperties = Constants.TORCH_PROPERTIES_ARRAY[torchPropertiesIndex];
            for (int colourIndex = 0; colourIndex < Constants.COLOUR_ARRAY.length; colourIndex++)
            {
                String bandedTorchName = "banded_" + torchProperties.name + "_" + Constants.COLOUR_ARRAY[colourIndex];
                String bandedTorchWallName = bandedTorchName + "_wall";

                DeferredHolder<Block, TorchBlock> blockRegistryObject = BLOCKS.register(
                    bandedTorchName,
                    () -> new TorchBlock(
                        torchProperties.particleType,
                        BlockBehaviour.Properties.of()
                        .noCollission()
                        .instabreak()
                        .lightLevel((BlockState) -> {return torchProperties.lightLevel;})
                        .sound(SoundType.WOOD)
                    ));
                DeferredHolder<Block, TorchBlock> wallBlockRegistryObject = BLOCKS.register(
                    bandedTorchWallName,
                    () -> new WallTorchBlock(
                        torchProperties.particleType,
                        BlockBehaviour.Properties.of()
                        .noCollission()
                        .instabreak()
                        .lightLevel((BlockState) -> {return torchProperties.lightLevel;})
                        .sound(SoundType.WOOD)
                        .lootFrom(blockRegistryObject)
                    ));
                DeferredHolder<Item, StandingAndWallBlockItem> itemRegistryObject = ITEMS.register(
                    bandedTorchName,
                    () -> new StandingAndWallBlockItem(
                        blockRegistryObject.get(),
                        wallBlockRegistryObject.get(),
                        new Item.Properties(),
                        Direction.DOWN));

                int torchIndex = ModBlocks.CalculateTorchIndex(torchPropertiesIndex, colourIndex);
                ModBlocks.torches[torchIndex] = new ModBlocks.TorchBlockDeferredHolders();
                ModBlocks.torches[torchIndex].block = blockRegistryObject;
                ModBlocks.torches[torchIndex].wallBlock = wallBlockRegistryObject;
                ModBlocks.torches[torchIndex].item = itemRegistryObject;
            }
        }
    }

    public static void init(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
