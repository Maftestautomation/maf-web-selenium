package com.epam.maf.stepdefs;

import com.epam.maf.listener.TestListener;
import com.epam.maf.model.User;
import com.epam.maf.model.UserPool;
import com.epam.maf.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;



@Slf4j
@Listeners(TestListener.class)
public class HomePageStepdefs {

    private final HomePage homePage;
    WebDriver driver;

    public HomePageStepdefs(HomePage homePage) {
        this.homePage = homePage;
    }


    @Given("^I navigate to crateandbarrel homepage$")
    public void givenINavigateToCrateandbarrelHomepage() {
        homePage.closeCookie();
    }

    @Then("^I check '(.*)' on HomePage$")
    public void thenICheckComponentsOnHomePage(String text) {

        switch (text){
            case "components":
                Assert.assertTrue(homePage.searchBoxIsDisplayed());
                Assert.assertTrue(homePage.userMenuIsDisplayed());
                break;
            case "categories menu":
                Assert.assertTrue(homePage.navBarIsClickable());
                break;
            case "footer":
                Assert.assertTrue(homePage.footerIsDisplayed());
                break;
        }
    }

    @Given("^I navigate to product detail page$")
    public void givenINavigateToProductDetailPage() {
        homePage.navigateToProductDetailPage();
    }
}
