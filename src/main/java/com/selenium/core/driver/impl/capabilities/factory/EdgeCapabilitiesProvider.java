package com.selenium.core.driver.impl.capabilities.factory;

import com.selenium.core.driver.interfaces.ICapabilitiesProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeCapabilitiesProvider implements ICapabilitiesProvider {
    @Override
    public MutableCapabilities provideCapabilities(String run) {
        EdgeOptions options = new EdgeOptions();
        if (run.equalsIgnoreCase("remote")) {
//            options.
        }
        return options;
    }
}
