package com.neothedeveloper.biomesplus;

import net.fabricmc.api.ModInitializer;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class BiomesPlus implements ModInitializer {
    public static final String MOD_ID = "biomesplus";
    public static final Logger LOGGER = LoggerFactory.getLogger("Biomes Plus");
    @Override
    public void onInitialize() {
        LOGGER.info("Biomes Plus is starting.");

    }
}
