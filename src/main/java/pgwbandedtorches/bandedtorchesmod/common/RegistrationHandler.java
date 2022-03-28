package pixelgamewizard.bandedtorchesmod.common;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import pixelgamewizard.bandedtorchesmod.common.Constants.TorchProperties;


public class RegistrationHandler
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BandedTorchesMod.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BandedTorchesMod.MODID);
    static
    {
        for (int torchPropertiesIndex = 0; torchPropertiesIndex < Constants.TORCH_PROPERTIES_ARRAY.length; torchPropertiesIndex++)
        {
            TorchProperties torchProperties = Constants.TORCH_PROPERTIES_ARRAY[torchPropertiesIndex];
            for (int colourIndex = 0; colourIndex < Constants.COLOUR_ARRAY.length; colourIndex++)
            {
                String bandedTorchName = "banded_" + torchProperties.name + "_" + Constants.COLOUR_ARRAY[colourIndex];
                String bandedTorchWallName = bandedTorchName + "_wall";

                RegistryObject<Block> blockRegistryObject = BLOCKS.register(
                    bandedTorchName,
                    () -> new TorchBlock(
                        AbstractBlock.Properties
                        .of(Material.DECORATION)
                        .noCollission()
                        .instabreak()
                        .lightLevel((BlockState) -> {return torchProperties.lightLevel;})
                        .sound(SoundType.WOOD),
                        torchProperties.particleType));
                RegistryObject<Block> wallBlockRegistryObject = BLOCKS.register(
                    bandedTorchWallName,
                    () -> new WallTorchBlock(
                        AbstractBlock.Properties
                        .of(Material.DECORATION)
                        .noCollission()
                        .instabreak()
                        .lightLevel((BlockState) -> {return torchProperties.lightLevel;})
                        .sound(SoundType.WOOD)
                        .lootFrom(blockRegistryObject),
                        torchProperties.particleType));
                RegistryObject<Item> itemRegistryObject = ITEMS.register(
                    bandedTorchName,
                    () -> new WallOrFloorItem(
                        blockRegistryObject.get(),
                        wallBlockRegistryObject.get(),
                        new Item.Properties()
                        .tab(ItemGroup.TAB_DECORATIONS)));

                int torchIndex = ModBlocks.CalculateTorchIndex(torchPropertiesIndex, colourIndex);
                ModBlocks.torches[torchIndex] = new ModBlocks.TorchBlockRegistryObjects();
                ModBlocks.torches[torchIndex].block = blockRegistryObject;
                ModBlocks.torches[torchIndex].wallBlock = wallBlockRegistryObject;
                ModBlocks.torches[torchIndex].item = itemRegistryObject;
            }
        }
    }

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
