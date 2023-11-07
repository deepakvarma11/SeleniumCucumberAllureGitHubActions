package com.selenium.core.driver;

import com.selenium.core.driver.impl.capabilities.drivers.GlobalDriverProvider;
import com.selenium.core.enums.Config;
import com.selenium.core.exceptions.BrowserException;
import com.selenium.core.exceptions.TafRuntimeException;
import com.selenium.core.utils.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WebDriverService {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public void initWebDriver() {
        GlobalDriverProvider globalDriverProvider = new GlobalDriverProvider();
        try{
            final String browser = PropertyReader.getInstance().getProperty(Config.BROWSER.getKey());
            driverThreadLocal.set(globalDriverProvider.createWebDriver(browser));
            maximizeBrowser();
            deleteCookies();
        } catch (TafRuntimeException e) {
            throw new RuntimeException(e);
        } catch (BrowserException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    public void deleteCookies(){
        driverThreadLocal.get().manage().deleteAllCookies();
    }
    public void maximizeBrowser(){
        driverThreadLocal.get().manage().window().maximize();
    }

    public static void destroyWebDriver(){
        if(Objects.nonNull(driverThreadLocal.get())){
            driverThreadLocal.get().close();
            driverThreadLocal.get().quit();
        }
    }

}
