package com.selenium.pages.impl;

import com.selenium.core.annotations.CurrentUrl;
import com.selenium.pages.interfaces.ILoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@CurrentUrl(urls = {"/login/show.do"})
public class LoginPage extends AbstractBasePage implements ILoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginHere = By.xpath("//h5[contains(text(),'Login Here')]");
    private final By username = By.name("userName");
    private final By password = By.id("password");
    private final By termConditions = By.id("TermsConditions");
    private final By loginBtn = By.id("submitBtn");
    private final By afterLoginUsername = By.xpath("//span[contains(@class,'font-weight-bold text-uppercase')]");
    private final By loginIncorrectMsg = By.xpath("//div[@id='errorMsg']/strong");

    @Override
    public void openLoginPage() {
        openDispatcherPage((this.getClass().getAnnotation(CurrentUrl.class).urls()));
    }

    public void loginPageDisplayed() {
        driver.findElement(loginHere).isDisplayed();
    }

    public void enterUsername(String text) {
        driver.findElement(username).sendKeys(text);
    }

    public void enterPassword(String text) {
        driver.findElement(password).sendKeys(text);
        Actions ac = new Actions(driver);
        ac.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).build().perform();
    }

    public void acceptTermAndConditions() {
        driver.findElement(termConditions).click();
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public boolean verifyInvalidLogin() {
        return driver.findElement(loginIncorrectMsg).getText().equals("Login incorrect. Please try again");
    }

    public String verifyUsername() {
        return driver.findElement(afterLoginUsername).getText().toLowerCase();
    }
}
