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
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler
{
    private static final String BANDED_TORCH_BASE_NAME = "banded_torch_";
    public static final int COLOUR_COUNT = 16;
    private static final String[] colours =
    {
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
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BandedTorchesMod.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BandedTorchesMod.MODID);
    static class RegistryObjects
    {
        public RegistryObject<Block> block;
        public RegistryObject<Block> wallBlock;
        public RegistryObject<Item> item;
    }
    public static final RegistryObjects[] REGISTRY_OBJECTS = new RegistryObjects[COLOUR_COUNT];
    static
    {
        for (int colourIndex = 0; colourIndex < COLOUR_COUNT; colourIndex++)
        {
            String bandedTorchName = BANDED_TORCH_BASE_NAME + colours[colourIndex];
            RegistryObject<Block> blockRegistryObject = BLOCKS.register(
                bandedTorchName,
                () -> new TorchBlock(
                    AbstractBlock.Properties
                    .of(Material.DECORATION)
                    .noCollission()
                    .instabreak()
                    .lightLevel((BlockState) -> {return 14;})
                    .sound(SoundType.WOOD),
                    ParticleTypes.FLAME));
            REGISTRY_OBJECTS[colourIndex] = new RegistryObjects();
            REGISTRY_OBJECTS[colourIndex].block = blockRegistryObject;
            RegistryObject<Block> wallBlockRegistryObject = BLOCKS.register(
                bandedTorchName + "_wall",
                () -> new WallTorchBlock(
                    AbstractBlock.Properties
                    .of(Material.DECORATION)
                    .noCollission()
                    .instabreak()
                    .lightLevel((BlockState) -> {return 14;})
                    .sound(SoundType.WOOD)
                    .lootFrom(blockRegistryObject),
                    ParticleTypes.FLAME));
            REGISTRY_OBJECTS[colourIndex].wallBlock = wallBlockRegistryObject;
            REGISTRY_OBJECTS[colourIndex].item = ITEMS.register(
                bandedTorchName,
                () -> new WallOrFloorItem(
                    blockRegistryObject.get(),
                    wallBlockRegistryObject.get(),
                    new Item.Properties()
                    .tab(ItemGroup.TAB_DECORATIONS)));
        }
    }

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
