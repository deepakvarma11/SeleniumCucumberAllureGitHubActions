package com.selenium.core.driver.interfaces;

import com.selenium.core.exceptions.TafRuntimeException;
import org.openqa.selenium.MutableCapabilities;

public interface ICapabilitiesFactory {

    MutableCapabilities getCapabilities() throws TafRuntimeException;
}
