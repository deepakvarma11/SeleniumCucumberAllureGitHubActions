package com.selenium.core.driver.impl.capabilities.drivers;

import com.selenium.core.driver.impl.capabilities.factory.CapabilityFactory;
import com.selenium.core.driver.interfaces.ICapabilitiesFactory;
import com.selenium.core.driver.interfaces.IWebDriverProvider;
import com.selenium.core.exceptions.BrowserException;
import com.selenium.core.exceptions.TafRuntimeException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GlobalDriverProvider implements IWebDriverProvider {

    private final ICapabilitiesFactory factory = new CapabilityFactory();

    @Override
    public WebDriver createWebDriver(final String browser) throws BrowserException, TafRuntimeException {
        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver(new ChromeOptions().merge(createCapabilities()));
        } else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver(new FirefoxOptions().merge(createCapabilities()));
        } else {
            throw new BrowserException("No browser found or incorrect browser");
        }
    }

    public MutableCapabilities createCapabilities() throws TafRuntimeException {
        MutableCapabilities capabilities = factory.getCapabilities();
        return capabilities;
    }
}
