package com.enderdevelopment.performanceoptimizer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceOptimizer implements ModInitializer {
    public static final String MOD_ID = "performanceoptimizer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Performance Optimizer");
        // Initialization code will go here
    }
}