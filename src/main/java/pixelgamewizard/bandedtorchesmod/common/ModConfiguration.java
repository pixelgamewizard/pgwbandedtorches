package pixelgamewizard.bandedtorchesmod.common;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;


public class ModConfiguration
{
    private Configuration configuration;
    
    public static final String GENERAL_CATEGORY = "general";
    private boolean allowTorchDuplicationRecipe;
    
    public static final String CLIENT_CATEGORY = "client";
    private boolean useDistinctInventoryIcon;
    
    public boolean getAllowTorchDuplicationRecipe()
    {
        return allowTorchDuplicationRecipe;
    }
    
    public boolean getUseDistinctInventoryIcon()
    {
        return useDistinctInventoryIcon;
    }
    
    public void preInit(FMLPreInitializationEvent event)
    {
        configuration = new Configuration(new File(event.getModConfigurationDirectory(), BandedTorchesMod.MODID + ".cfg"));
        configuration.load();
        allowTorchDuplicationRecipe = configuration.getBoolean("allowTorchDuplicationRecipe", GENERAL_CATEGORY, true, "Allow the recipe to duplicate a banded torch using a normal torch.");
        if (event.getSide() == Side.CLIENT)
        {
            useDistinctInventoryIcon = configuration.getBoolean("useDistinctInventoryIcon", CLIENT_CATEGORY, true, "Use a dedicated torch icon so that the band is more visible (especially with the stack counter in double digits).");
        }
        configuration.save();
    }
}
