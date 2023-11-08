package com.selenium.core.driver.interfaces;

import org.openqa.selenium.MutableCapabilities;

public interface ICapabilitiesProvider {

    MutableCapabilities provideCapabilities(final String run);
}
