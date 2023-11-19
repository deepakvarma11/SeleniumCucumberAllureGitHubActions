package com.selenium.pages.impl;

import com.selenium.core.annotations.CurrentUrl;
import com.selenium.pages.interfaces.IHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@CurrentUrl(value = "/guest/home.do?lange=en")
public class HomePage extends AbstractBasePage implements IHomePage {

    private final WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By bookYourTickets = By.xpath("//h2[contains(text(),'Book')]");
    private final By signIn = By.xpath("//a[@href='/oprs-web/login/show.do']");


    @Override
    public void openHomePage() {
        openDispatcherPage(this.getClass().getAnnotation(CurrentUrl.class).value());
    }

    public void isDisplayedHomePage() {
        driver.findElement(bookYourTickets).isDisplayed();
    }

    public void clickSignIn() {
        pageLoaded();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(signIn)).perform();
        driver.findElement(signIn).click();
    }
}

