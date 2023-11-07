package com.selenium.stepdefs.steps;

import com.selenium.core.driver.WebDriverService;
import com.selenium.core.driver.impl.capabilities.drivers.GlobalDriverProvider;
import com.selenium.core.driver.interfaces.IWebDriverService;
import com.selenium.core.exceptions.BrowserException;
import com.selenium.core.exceptions.TafRuntimeException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.util.Properties;

public class CucumberHooks {

    WebDriverService webDriverService;
    Properties properties;
    GlobalDriverProvider driverProvider;


    @Before(order = 0)
    public void initialSetup() throws BrowserException, TafRuntimeException {
        webDriverService = new WebDriverService();
        webDriverService.initWebDriver();
   }

    @After(order = 0)
    public void afterFinish(Scenario scenario){
        tearDown(scenario);
        WebDriverService.destroyWebDriver();
    }

    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) WebDriverService.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
    }


}
