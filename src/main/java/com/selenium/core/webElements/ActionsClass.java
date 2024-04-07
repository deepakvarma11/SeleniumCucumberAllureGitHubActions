package com.selenium.core.webElements;

import com.selenium.core.driver.WebDriverService;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

    private static Actions actions;

    private ActionsClass(Actions actions){
        this.actions = actions;
    }

    public static ActionsClass withActions(){
        return new ActionsClass(new Actions(WebDriverService.getDriver()));
    }

    public ActionsClass sendKeys(CharSequence... keys){
        actions.sendKeys(keys);
        return this;
    }

    public ActionsClass sendTab(){
        actions.sendKeys(Keys.TAB);
        return this;
    }

    public ActionsClass sendSpace(){
        actions.sendKeys(Keys.SPACE);
        return this;
    }

    public ActionsClass moveToElement(Element element){
        actions.moveToElement(element.findElement());
        return this;
    }

    public void perform(){
        actions.perform();
    }

    public ActionsClass build(){
        actions.build();
        return this;
    }

    public void done(){
        actions.build().perform();
    }



}
