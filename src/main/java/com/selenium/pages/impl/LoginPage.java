package com.selenium.pages.impl;

import com.selenium.pages.interfaces.ILoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends AbstractBasePage implements ILoginPage {

    private static final String LOGINPAGE_URL = "https://ksrtc.in/oprs-web/login/show.do";

    private WebDriver driver;

    @Override
    public void openLoginPage() {
        openDispatcherPage(LOGINPAGE_URL);
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginHere = By.xpath("//h5[contains(text(),'Login Here')]");
    private By username = By.name("userName");
    private By password = By.id("password");
    private By termConditions = By.id("TermsConditions");
    private By loginBtn = By.id("submitBtn");
    private By afterLoginUsername = By.xpath("//span[contains(@class,'font-weight-bold text-uppercase')]");
    private By loginIncorrectMsg = By.xpath("//div[@id='errorMsg']/strong");

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
