package com.selenium.stepdefs.steps;

import com.selenium.core.driver.WebDriverService;
import com.selenium.core.utils.PropertyReader;
import com.selenium.pages.impl.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class HomePageDefinitionSteps {

    WebDriver driver = WebDriverService.getDriver();
    Properties pr = PropertyReader.getInstance();
    HomePage hp = new HomePage(WebDriverService.getDriver());

    @Given("I am in the Background scenario")
    public void i_am_in_the_background_scenario() {
        System.out.println("IN THE BACKGROUND SCENARIO");
    }

    @Given("Goto to Homepage {string}")
    public void goto_to_homepage(String string) {
        driver.get(pr.getProperty(string));
    }

    @Then("HomePage is displayed")
    public void home_page_is_displayed() {
        hp.isDisplayedHomePage();
    }

    @When("Click on Signin")
    public void click_on_signin() {
        hp.clickSignIn();
    }
}
