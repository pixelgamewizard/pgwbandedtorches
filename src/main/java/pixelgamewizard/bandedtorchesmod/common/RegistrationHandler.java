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


public class RegistrationHandler
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BandedTorchesMod.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BandedTorchesMod.MODID);
    static
    {
        for (int colourIndex = 0; colourIndex < Constants.COLOURS.length; colourIndex++)
        {
            String BANDED_TORCH_BASE_NAME = "banded_torch_";
            String bandedTorchName = BANDED_TORCH_BASE_NAME + Constants.COLOURS[colourIndex];
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
            ModBlocks.torches[colourIndex] = new ModBlocks.TorchBlockRegistryObjects();
            ModBlocks.torches[colourIndex].block = blockRegistryObject;
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
            ModBlocks.torches[colourIndex].wallBlock = wallBlockRegistryObject;
            ModBlocks.torches[colourIndex].item = ITEMS.register(
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
