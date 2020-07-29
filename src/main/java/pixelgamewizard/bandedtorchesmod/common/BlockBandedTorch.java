package pixelgamewizard.bandedtorchesmod.common;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;

public class BlockBandedTorch extends BlockTorch
{
    public BlockBandedTorch()
    {
        super();
        this.setHardness(0.0F);
        this.setLightLevel(0.9375F);
        // setSoundType is protected so needs to be here
        this.setSoundType(SoundType.WOOD);
    }
}
