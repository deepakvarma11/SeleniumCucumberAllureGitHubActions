package com.selenium.core.driver.interfaces;

import com.selenium.core.exceptions.TestRuntimeException;
import org.openqa.selenium.MutableCapabilities;

public interface ICapabilitiesFactory {

    MutableCapabilities getCapabilities() throws TestRuntimeException;
}
