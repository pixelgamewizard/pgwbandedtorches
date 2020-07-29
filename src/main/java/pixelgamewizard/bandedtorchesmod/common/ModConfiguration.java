package pixelgamewizard.bandedtorchesmod.common;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ModConfiguration
{
    private Configuration configuration;
    
    public static final String GENERAL_CATEGORY = "general";
    private boolean allowTorchDuplicationRecipe;
    
    public boolean getAllowTorchDuplicationRecipe()
    {
        return allowTorchDuplicationRecipe;
    }
    
    public void preInit(FMLPreInitializationEvent event)
    {
        configuration = new Configuration(new File(event.getModConfigurationDirectory(), BandedTorchesMod.MODID + ".cfg"));
        configuration.load();
        allowTorchDuplicationRecipe = configuration.getBoolean("allowTorchDuplicationRecipe", GENERAL_CATEGORY, true, "Allow the recipe to duplicate a banded torch using a normal torch.");
        configuration.save();
    }
}
