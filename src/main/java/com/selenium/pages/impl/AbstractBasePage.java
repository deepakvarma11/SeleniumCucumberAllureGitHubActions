package com.selenium.pages.impl;

import com.selenium.core.driver.WebDriverService;
import com.selenium.core.enums.Config;
import com.selenium.core.utils.PropertyReader;
import com.selenium.pages.interfaces.IBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractBasePage implements IBasePage {

    @Override
    public void openDispatcherPage(final String url) {
        String currentBaseUrl = PropertyReader.getInstance().getProperty(Config.URL.getKey());
        WebDriverService.getDriver().get(currentBaseUrl+url);
    }

    public void openDispatcherPage(final String[] urls){
        String currentBaseUrl = PropertyReader.getInstance().getProperty(Config.URL.getKey());
        WebDriverService.getDriver().get(currentBaseUrl+urls[0]);
    }

    @Override
    public String getPageTitle() {
        return WebDriverService.getDriver().getTitle();
    }

    @Override
    public void pageLoaded() {
        new WebDriverWait(WebDriverService.getDriver(), Duration.ofSeconds(30)).until(driver -> "complete".equals(this.JavaScriptExecute("return document.readyState")));
    }

    public String JavaScriptExecute(String execute){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) WebDriverService.getDriver();
        return (String) javascriptExecutor.executeScript(execute);

    }
}
