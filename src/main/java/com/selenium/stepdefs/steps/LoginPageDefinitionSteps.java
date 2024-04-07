package com.selenium.stepdefs.steps;

import com.selenium.pages.impl.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class LoginPageDefinitionSteps {

    LoginPage lp = new LoginPage();

    @Given("Open Loginpage")
    public void open_homepage() {
        lp.openLoginPage();
    }

    @Then("Login page is displayed")
    public void login_page_is_displayed() {
        lp.loginPageDisplayed();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        lp.enterUsername(username);
        lp.enterPassword(password);
//		lp.acceptTermAndConditions();
    }

    @When("Click login")
    public void click_login() {
        lp.clickLogin();
    }

    @Then("Login incorrect displayed")
    public void login_incorrect_displayed() {
        Assertions.assertThat(lp.verifyInvalidLogin()).isTrue();
    }

    @Then("Username is {string}")
    public void username_is(String string) {
        Assertions.assertThat(lp.verifyUsername()).isEqualTo(string);
    }
}
