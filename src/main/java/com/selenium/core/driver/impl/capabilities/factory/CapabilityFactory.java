package com.selenium.core.driver.impl.capabilities.factory;

import com.selenium.core.driver.interfaces.ICapabilitiesFactory;
import com.selenium.core.driver.interfaces.ICapabilitiesProvider;
import com.selenium.core.enums.Config;
import com.selenium.core.exceptions.TestRuntimeException;
import com.selenium.core.utils.PropertyReader;
import org.openqa.selenium.MutableCapabilities;

import java.util.HashMap;
import java.util.Map;

public class CapabilityFactory implements ICapabilitiesFactory {

    private Map<String, ICapabilitiesProvider> capabilities = new HashMap<>();
    private final String run = System.getProperty("browserType",
            PropertyReader.getInstance().getProperty(Config.BROWSERTYPE.getKey()));

    public CapabilityFactory(){
        capabilities.put("firefox", new FireFoxCapabilitiesProvider());
        capabilities.put("chrome", new ChromeCapabilitiesProvider());
        capabilities.put("edge", new EdgeCapabilitiesProvider());
    }

    @Override
    public MutableCapabilities getCapabilities() throws TestRuntimeException {
        return capabilities.entrySet().stream()
                .filter(entry -> entry.getKey().toLowerCase().startsWith(PropertyReader.getInstance().getProperty(Config.BROWSER.getKey())))
                .map(entry -> entry.getValue().provideCapabilities(run))
                .findFirst()
                .orElseThrow(() -> new TestRuntimeException("Capabilities are empty"));
    }
}
