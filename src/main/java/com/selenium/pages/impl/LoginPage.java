package com.selenium.pages.impl;

import com.selenium.core.annotations.CurrentUrl;
import com.selenium.pages.interfaces.ILoginPage;
import org.openqa.selenium.By;

import static com.selenium.core.webElements.ActionsClass.withActions;
import static com.selenium.core.webElements.ElementUtils.findElementBySelector;
import static com.selenium.core.webElements.ElementUtils.findElementByXpath;

@CurrentUrl(urls = {"/login/show.do"})
public class LoginPage extends AbstractBasePage implements ILoginPage {

    private static final String LOGIN_HERE = "//h5[contains(text(),'Login Here')]";
    private static final String USERNAME = "userName";
    private static final String PASSWORD = "password";
    private static final String TERMS_CONDITIONS = "TermsConditions";
    private static final String LOGIN_BTN = "submitBtn";
    private static final String AFTER_LOGIN_USERNAME = "//span[contains(@class,'font-weight-bold " +
            "text-uppercase')]";
    private static final String LOGIN_INCORRECT_MSG = "//div[@id='errorMsg']/strong";

    @Override
    public void openLoginPage() {
        openDispatcherPage((this.getClass().getAnnotation(CurrentUrl.class).urls()));
    }

    public void loginPageDisplayed() {
        findElementByXpath(LOGIN_HERE, "login here button").isDisplayed();
    }

    public void enterUsername(String text) {
        findElementBySelector(By.name(USERNAME), "Username input").sendText(text);
    }

    public void enterPassword(String text) {
        findElementBySelector(By.id(PASSWORD), "Password input").sendText(text);
        withActions().sendTab().sendSpace().done();
    }

    public void acceptTermAndConditions() {
        findElementBySelector(By.id(TERMS_CONDITIONS), TERMS_CONDITIONS).click();
    }

    public void clickLogin() {
        findElementBySelector(By.id(LOGIN_BTN), LOGIN_BTN).click();
    }

    public boolean verifyInvalidLogin() {
        return findElementByXpath(LOGIN_INCORRECT_MSG, "").getText().equals("Login incorrect. Please try again");
    }

    public String verifyUsername() {
        return findElementByXpath(AFTER_LOGIN_USERNAME, "").getText().toLowerCase();
    }
}
