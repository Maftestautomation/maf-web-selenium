package com.epam.maf.stepdefs;

import com.epam.maf.listener.TestListener;
import com.epam.maf.pages.ProductDetailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import static com.epam.maf.constants.Constants.*;

@Slf4j
@Listeners(TestListener.class)
public class ProductDetailStepdefs {

    private final ProductDetailPage productDetailPage;
    WebDriver driver;

    public ProductDetailStepdefs(ProductDetailPage productDetailPage) {
        this.productDetailPage = productDetailPage;
    }

    @Then("^I check product on product detail page$")
    public void thenICheckProductOnProductDetailPage() {
        Assert.assertTrue(productDetailPage.productImageComponentIsDisplayed(),"Product image is not displayed properly");
        Assert.assertTrue(productDetailPage.addToCartButtonIsDisplayed(),"Add to Cart button is not displayed properly");
        Assert.assertTrue(productDetailPage.articleIsDisplayed(),"Article is not displayed properly");
    }

    @Then("^I check breadcrumb on product detail page$")
    public void thenICheckBreadcrumbOnProductDetailPage() {
        Assert.assertTrue(productDetailPage.breadcrumbIsDisplayed(),"Breadcrumb is not displayed properly");
    }

    @When("^I expand product details section$")
    public void whenIExpandProductDetailsSection() {
        Assert.assertTrue(productDetailPage.detailsSectionIsDisplayed(),"Details section is not displayed");
        productDetailPage.expandDetailsSection();
    }

    @Then("I should see details information on product detail page")
    public void thenIShouldSeeDetailsInformationOnProductDetailPage() {
        Assert.assertTrue(productDetailPage.detailsTextIsDisplayed(),"Details text is not displayed");
    }

    @Then("I should see algonomy component on product detail page")
    public void thenIShouldSeeAlgonomyComponentOnProductDetailPage() {
        Assert.assertTrue(productDetailPage.algonomyIsDisplayed(),"Algonomy component is not displayed");
    }

    @Then("^I should see product SKU on product detail page$")
    public void thenIShouldSeeProductSKUOnProductDetailPage() {
        Assert.assertTrue(productDetailPage.skuIsDisplayed(),"Product SKU is not displayed");
    }


    @Then("I should see contact us component on product detail page")
    public void thenIShouldSeeContactUsComponentOnProductDetailPage() {
        Assert.assertTrue(productDetailPage.contactUsComponentIsDisplayed(),"Contact Us component is not displayed");

        Assert.assertEquals(productDetailPage.getContactUsLinkText(),CONTACT_US_TEXT);
        Assert.assertEquals(productDetailPage.getTelephoneLinkText(),TELEPHONE_TEXT);
        Assert.assertEquals(productDetailPage.getEmailLinkText(),EMAIL_TEXT);
    }
}
