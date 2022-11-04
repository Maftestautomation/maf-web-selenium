package com.epam.maf.pages;

import com.epam.maf.utilities.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Slf4j
public class BasePage {

    public BasePage() {
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void waitPageLoading(By byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
            log.info(" ================ Waiting for element to be loading: " + byElement +" ================");
    }

    public String getText(By byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
            log.info("================ Text is displayed as: " + byElement+ " ================");
        return text;

    }

    public boolean isDisplayed(By byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).isDisplayed();
        if(displayed){
              log.info("================ Element" + byElement + " is succesfuly displayed ================");
        } else {
                  log.info("================ Element" + byElement + " is not displayed ================");
        }
        return displayed;
    }

    public void click(By byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
           log.info("================ Clicked element: " + byElement+ " ================");
    }

    public void sendKeys(By byElement, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text);
           log.info("================ Entering: " +text + " to element: " +byElement+ " ================");
    }

    public void clearText (By byElement){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).clear();
    }
}
