package com.selenium.core.driver.impl.capabilities.factory;

import com.selenium.core.driver.interfaces.ICapabilitiesProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeCapabilitiesProvider implements ICapabilitiesProvider {
    @Override
    public MutableCapabilities provideCapabilities() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return chromeOptions;
    }
}
