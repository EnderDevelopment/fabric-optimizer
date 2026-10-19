package com.enderdevelopment.performanceoptimizer.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "performanceoptimizer")
public class PerformanceOptimizerConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean enableEntityOptimization = true;

    @ConfigEntry.Gui.Tooltip
    public boolean enableBlockEntityOptimization = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    public int entityTickInterval = 5;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    public int blockEntityTickInterval = 5;
}