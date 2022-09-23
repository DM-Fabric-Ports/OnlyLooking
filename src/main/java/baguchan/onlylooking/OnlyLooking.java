package baguchan.onlylooking;

import net.fabricmc.api.ModInitializer;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class OnlyLooking implements ModInitializer{
    public static final String MODID = "onlylooking";

    @Override
    public void onInitialize() {
        ModLoadingContext.registerConfig(MODID, ModConfig.Type.COMMON, ModConfigs.COMMON_SPEC);
    }
}
