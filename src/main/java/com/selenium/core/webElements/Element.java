package com.selenium.core.webElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Element {

    private String name;
    private WebElement webElement;

    public Element(WebElement webElement,String name){
        this.webElement = webElement;
        this.name = name;
    }

    public boolean isDisplayed(){
        return webElement.isDisplayed();
    }

    public WebElement findElement(){
        return webElement;
    }

    public Element click(){
        webElement.click();
        return this;
    }

    public Element sendText(final String text){
        webElement.sendKeys(text);
        return this;
    }

    public Element pressEnter(){
        webElement.sendKeys(Keys.ENTER);
        return this;
    }

    public String getText(){
        return webElement.getText();
    }
}
