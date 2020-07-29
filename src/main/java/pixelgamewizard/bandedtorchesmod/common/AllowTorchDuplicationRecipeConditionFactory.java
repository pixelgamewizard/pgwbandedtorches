package pixelgamewizard.bandedtorchesmod.common;

import com.google.gson.JsonObject;
import java.util.function.BooleanSupplier;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class AllowTorchDuplicationRecipeConditionFactory implements IConditionFactory
{
    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json)
    {
        return() -> BandedTorchesMod.CONFIGURATION.getAllowTorchDuplicationRecipe();
    }
}
