package com.epam.maf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    By ByLogo = By.id("nav-logo-sprites");
    By BySearchTextBox = By.id("twotabsearchtextbox");
    By BySearchResultText = By.cssSelector(".a-color-state.a-text-bold");
    By BySelectProduct = By.cssSelector(".a-section.aok-relative.s-image-fixed-height > img");
    By ByProductImage = By.id("imgTagWrapperId");

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    public boolean LogoDisplayed(){
        return isDisplayed(ByLogo);
    }

    public void searchText(String text){
        sendKeys(BySearchTextBox, text + Keys.ENTER);
    }

    public void clearText(){
        clearText(BySearchTextBox);
    }
    public String getSearchResultText(){
        return getText(BySearchResultText);
    }

    public void selectProductFromSearchResults(){
        click(BySelectProduct);
    }

    public boolean productImageIsDisplayed(){
        return isDisplayed(ByProductImage);
    }

}
