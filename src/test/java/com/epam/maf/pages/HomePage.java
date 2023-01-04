package com.epam.maf.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage() {
    }

    @FindBy(className = "cookie-warning-forced-close-button")
    private WebElement closeCookieButton;
    @FindBy(id = "SearchBox")
    private WebElement searchBox;

    @FindBy(className = "user-menu-wrapper")
    private List<WebElement> userMenuWrapperListElement;

    @FindBy(id = "CabCategoryNavComponent")
    private WebElement navBarComponentListElement;

    @FindBy(css = ".footer")
    private WebElement footer;

    @FindBy(id = "FurnitureCMSLink")
    private WebElement furniturePage;

    @FindBy(css = "#SofasCMSLink > div > div > a")
    private WebElement sofasLink;

    @FindBy(id = "sort")
    private WebElement sortButton;

    @FindBy(css = "button.dropdown-item.state-active")
    private WebElement relevanceButton;



    public void closeCookie(){
        click(closeCookieButton);
    }

    public boolean searchBoxIsDisplayed(){
        return isDisplayed(searchBox);
    }
    public boolean userMenuIsDisplayed(){
        List<WebElement> userMenuWrapperList = getDriver().findElements(By.className("user-menu-wrapper"));
        boolean isDisplayed = false;
        for (WebElement webElement : userMenuWrapperList) {
            isDisplayed = webElement.isDisplayed();
        }
        return isDisplayed;
    }

    public boolean navBarIsClickable(){
        List<WebElement> navBarComponentList = getDriver().findElements(By.id("CabCategoryNavComponent"));
        boolean isClickable = false;
        for (WebElement webElement : navBarComponentList) {
            isClickable = isClickable(webElement);
        }
        return isClickable;
    }

    public boolean footerIsDisplayed(){
        return isDisplayed(footer);
    }

    public void navigateToProductDetailPage(){
        click(furniturePage);
        click(sofasLink);
        click(sortButton);
        click(relevanceButton);

        clickRandomProductOnPLP();
    }



}
