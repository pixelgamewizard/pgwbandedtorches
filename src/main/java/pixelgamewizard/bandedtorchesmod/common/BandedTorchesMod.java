package pixelgamewizard.bandedtorchesmod.common;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;


@Mod(
    useMetadata = true,
    modid = BandedTorchesMod.MODID,
    name = BandedTorchesMod.NAME,
    version = BandedTorchesMod.VERSION,
    acceptedMinecraftVersions = BandedTorchesMod.MC_VERSION,
    dependencies = "required-after:forge@[14.23.5.2838,)"
)
public class BandedTorchesMod {
    public static final String MODID = "pgwbandedtorches";
    public static final String NAME = "PixelGameWizard Banded Torches";
    public static final String VERSION = "0.9.20200729a";
    public static final String MC_VERSION = "[1.12.2]";
    
    public static final Logger LOGGER = LogManager.getLogger(BandedTorchesMod.MODID);
    public static final ModConfiguration CONFIGURATION = new ModConfiguration();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CONFIGURATION.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        RegistrationHandler.regsiterBlocksToOreDicts();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}