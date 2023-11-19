package com.selenium.core.driver.impl.capabilities.factory;

import com.selenium.core.driver.interfaces.ICapabilitiesProvider;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeCapabilitiesProvider implements ICapabilitiesProvider {
    @Override
    public MutableCapabilities provideCapabilities(final String run) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (run.equalsIgnoreCase("remote")) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-dev-shm-usage");
//            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-notifications");
//            chromeOptions.addArguments("--disabled-gpu");
            chromeOptions.addArguments("--no-sandbox");
//            chromeOptions.addArguments(Arrays.asList("--allow-running-insecure-content", "--ignore-certificate-errors",
//                    "--disable-popup-blocking", "--disable-dev-shm-usage", "--no-sandbox", "--disable-gpu", "--disable-blink-features=AutomationControlled"));
        }
        return chromeOptions;
    }
}
