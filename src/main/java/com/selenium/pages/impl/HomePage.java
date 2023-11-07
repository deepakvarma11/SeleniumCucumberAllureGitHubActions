package com.selenium.pages.impl;

import com.selenium.pages.interfaces.IHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends AbstractBasePage implements IHomePage {

    private static final String HOMEPAGEURL = "https://ksrtc.in/oprs-web/guest/home.do?lange=en";
    private final WebDriver driver;


    @Override
    public void openHomePage() {
        openDispatcherPage(HOMEPAGEURL);
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By bookYourTickets = By.xpath("//h2[contains(text(),'Book')]");
    private By signIn = By.xpath("//a[@href='/oprs-web/login/show.do']");


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

