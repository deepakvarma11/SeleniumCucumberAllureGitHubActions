package com.selenium.core.webElements;

import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.selenium.core.driver.WebDriverService.getDriver;

public class ElementUtils {

    public static Element findElementByXpath(String xpath, String name) {
        return new Element(getDriver().findElement(By.xpath(xpath)), name);
    }

    public static List<Element> findElementsByXpath(String xpath, String name) {
        return getDriver().findElements(By.xpath(xpath)).stream().map(o -> new Element(o,name)).collect(Collectors.toList());
    }

    public static Element findElementBySelector(By selector, String name){
        return new Element(getDriver().findElement(selector), name);
    }

    public static List<Element> findElementsByXpath(By selector, String name) {
        return getDriver().findElements(selector).stream().map(o -> new Element(o,name)).collect(Collectors.toList());
    }
}
