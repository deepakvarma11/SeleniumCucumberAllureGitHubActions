package com.selenium.stepdefs.steps;

import com.selenium.pages.impl.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageDefinitionSteps {

    HomePage hp = new HomePage();

    @Given("I am in the Background scenario")
    public void i_am_in_the_background_scenario() {
        System.out.println("IN THE BACKGROUND SCENARIO");
    }


    @Given("Open Homepage")
    public void open_homepage() {
        hp.openHomePage();
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
