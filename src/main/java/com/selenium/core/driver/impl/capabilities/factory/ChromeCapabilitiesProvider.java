package com.selenium.core.driver.impl.capabilities.factory;

import com.selenium.core.driver.interfaces.ICapabilitiesProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeCapabilitiesProvider implements ICapabilitiesProvider {
    @Override
    public MutableCapabilities provideCapabilities(final String run) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (run.equalsIgnoreCase("remote")) {
            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("--disabled-gpu");
            chromeOptions.addArguments("--no-sandbox");
        }
        return chromeOptions;
    }
}
