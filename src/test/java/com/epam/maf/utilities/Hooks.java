package com.epam.maf.utilities;

import com.epam.maf.listener.TestListener;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.epam.maf.utilities.DriverFactory.getDriver;
import static com.epam.maf.utilities.DriverFactory.quitDriver;

@Slf4j
@Listeners(TestListener.class)
public class Hooks {

    @Before
    public void Setup() {
        getDriver();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            Config.captureScreenshot(getDriver(), result.getName());
        }
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}
