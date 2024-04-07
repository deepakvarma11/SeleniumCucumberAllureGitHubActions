package com.selenium.pages.impl;

import com.selenium.core.annotations.CurrentUrl;
import com.selenium.pages.interfaces.IHomePage;

import static com.selenium.core.webElements.ActionsClass.withActions;
import static com.selenium.core.webElements.ElementUtils.findElementByXpath;

@CurrentUrl(value = "/guest/home.do?lange=en")
public class HomePage extends AbstractBasePage implements IHomePage {

    private static final String BOOK_YOUR_TICKETS = "//h2[contains(text(),'Book')]";
    private static final String SIGN_IN = "//a[@href='/oprs-web/login/show.do']";


    @Override
    public void openHomePage() {
        openDispatcherPage(this.getClass().getAnnotation(CurrentUrl.class).value());
    }

    public boolean isDisplayedHomePage() {
        return findElementByXpath(BOOK_YOUR_TICKETS, "").isDisplayed();
    }

    public void clickSignIn() {
        pageLoaded();
        withActions().moveToElement(findElementByXpath(SIGN_IN, "")).done();
        findElementByXpath(SIGN_IN, "").click();
    }
}

