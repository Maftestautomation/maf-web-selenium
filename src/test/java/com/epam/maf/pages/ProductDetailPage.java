package com.epam.maf.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{


    public ProductDetailPage() {

    }
    @FindBy(id = "ProductImagesComponent")
    private WebElement productImagesComponent;

    @FindBy(css = ".btn-add-to-cart")
    private WebElement addToCartButton;

    @FindBy(id = "CabAdvancedBannerArticle3")
    private WebElement bannerArticle;

    @FindBy(id = "breadcrumbComponent")
    private WebElement breadCrumb;

    @FindBy(xpath = "//*[contains(text(),'Details')]")
    private WebElement detailsSection;

    @FindBy(css = ".details")
    private WebElement detailsText;

    @FindBy(css = ".carousel-container")
    private WebElement algonomyComponent;

    @FindBy(className = "leo-product-sku-component-product-sku-alpha")
    private WebElement skuComponent;

    @FindBy(id = "CabCardContactUs")
    private WebElement contactUsComponent;

    @FindBy(xpath = "//a[contains(text(),'email')]")
    private WebElement emailLink;

    @FindBy(xpath = "//a[contains(text(),'CANDB')]")
    private WebElement telephoneLink;

    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    private WebElement contactUsLink;






    public boolean productImageComponentIsDisplayed(){
       return isDisplayed(productImagesComponent);
   }

    public boolean addToCartButtonIsDisplayed(){
        return isDisplayed(addToCartButton);
    }

    public boolean articleIsDisplayed(){
        return isDisplayed(bannerArticle);
    }

    public boolean breadcrumbIsDisplayed(){
        return isDisplayed(breadCrumb);
    }

    public boolean detailsSectionIsDisplayed(){
        return isDisplayed(detailsSection);
    }

    public boolean detailsTextIsDisplayed(){
        return isDisplayed(detailsSection);
    }

    public boolean algonomyIsDisplayed(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        return isDisplayed(algonomyComponent);
    }

    public void expandDetailsSection(){
        click(detailsSection);
    }

    public boolean skuIsDisplayed(){
        return isDisplayed(skuComponent);
    }

    public boolean contactUsComponentIsDisplayed(){
        return isDisplayed(contactUsComponent) && isDisplayed(emailLink) && isDisplayed(telephoneLink) && isDisplayed(contactUsLink);
    }

    public String getEmailLinkText(){
        return getText(emailLink);
    }

    public String getTelephoneLinkText(){
        return getText(telephoneLink);
    }

    public String getContactUsLinkText(){
        return getText(contactUsLink);
    }

}
