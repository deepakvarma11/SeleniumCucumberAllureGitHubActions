package com.selenium.core.driver;

import com.selenium.core.driver.impl.capabilities.drivers.GlobalDriverProvider;
import com.selenium.core.exceptions.BrowserException;
import com.selenium.core.exceptions.TafRuntimeException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public class WebDriverService {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public void initWebDriver() {
        try {
            driverThreadLocal.set(new GlobalDriverProvider().createWebDriver());
            pageLoadtimeout();
            maximizeBrowser();
            deleteCookies();
        } catch (TafRuntimeException | BrowserException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public void deleteCookies() {
        driverThreadLocal.get().manage().deleteAllCookies();
    }

    public void pageLoadtimeout(){
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driverThreadLocal.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
    }
    public void maximizeBrowser() {
        driverThreadLocal.get().manage().window().maximize();
    }

    public static void destroyWebDriver() {
        if (Objects.nonNull(driverThreadLocal.get())) {
            driverThreadLocal.get().close();
            driverThreadLocal.get().quit();
        }
    }

}
