package com.epam.maf.runner;

import com.epam.maf.utilities.Config;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.epam.maf.utilities.DriverFactory.getDriver;
import static com.epam.maf.utilities.DriverFactory.quitDriver;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},
        features = {"src/test/resources"},
        glue = {"com/epam/maf/stepdefs", "stepdefs"},
        //tags = "@smoke",
        monochrome = true,
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void Setup() {
        getDriver();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            Config.captureScreenshot(getDriver(), result.getName());
        }
    }

    @AfterTest
    public void tearDown() {
        quitDriver();
    }
}
