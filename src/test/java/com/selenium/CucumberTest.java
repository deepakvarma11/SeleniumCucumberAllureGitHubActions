package com.selenium;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/main/resources/features" },
        glue = {"com.selenium.stepdefs.steps" },
        monochrome = true, dryRun = false,
//				plugin = { "progress", "html:build/report/html/index.html",
//				"junit:build/report/junit/cucumber-report.xml",
//				"json:build/report/json/cucumber-report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CucumberTest {
}
