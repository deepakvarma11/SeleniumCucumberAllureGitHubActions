package com.selenium.core.driver.interfaces;

import com.selenium.core.exceptions.BrowserException;
import com.selenium.core.exceptions.TestRuntimeException;
import org.openqa.selenium.WebDriver;

public interface IWebDriverProvider {

    WebDriver createWebDriver() throws BrowserException, TestRuntimeException;
}
