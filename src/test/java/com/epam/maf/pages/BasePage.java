package com.epam.maf.pages;

import com.epam.maf.utilities.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Slf4j
public class BasePage {

    public static WebDriver driver;
    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void waitPageLoading(WebElement byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(byElement));
            log.info(" ================ Waiting for element to be loading: " + byElement +" ================");
    }

    public String getText(WebElement byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String text = wait.until(ExpectedConditions.visibilityOf(byElement)).getText();
            log.info("================ Text is displayed as: " + byElement+ " ================");
        return text;

    }

    public boolean isDisplayed(WebElement byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        boolean displayed = wait.until(ExpectedConditions.visibilityOf(byElement)).isDisplayed();
        if(displayed){
              log.info("================ Element" + byElement + " is succesfuly displayed ================");
        } else {
                  log.info("================ Element" + byElement + " is not displayed ================");
        }
        return displayed;
    }


    public void click(WebElement byElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
        log.info("================ Clicked element: " + byElement+ " ================");
    }

    public void sendKeys(WebElement byElement, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text);
           log.info("================ Entering: " +text + " to element: " +byElement+ " ================");
    }

    public void clearText (WebElement byElement){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).clear();
    }

    public boolean isClickable(WebElement byElement){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(byElement));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void clickRandomProductOnPLP(){

        List<WebElement> products = getDriver().findElements(By.cssSelector(".product-images"));
        int totalProducts = products.size();
        Random random = new Random();
        int randomProduct = random.nextInt(totalProducts);

        click(products.get(randomProduct));
    }
}
