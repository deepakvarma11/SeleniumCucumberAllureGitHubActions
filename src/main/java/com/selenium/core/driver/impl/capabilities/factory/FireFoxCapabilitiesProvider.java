package com.selenium.core.driver.impl.capabilities.factory;

import com.selenium.core.driver.interfaces.ICapabilitiesProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxCapabilitiesProvider implements ICapabilitiesProvider {
    @Override
    public MutableCapabilities provideCapabilities() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        return firefoxOptions;
    }
}
