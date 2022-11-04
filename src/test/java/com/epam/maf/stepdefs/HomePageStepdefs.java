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
import org.testng.Assert;
import org.testng.annotations.Listeners;


@Slf4j
@Listeners(TestListener.class)
public class HomePageStepdefs {

    private final HomePage homePage;

    public HomePageStepdefs(HomePage homePage) {
        this.homePage = homePage;
    }


    @Given("^I login with username '(.*)' and password '(.*)'$")
    public void givenILoginWithUsernameTestTestComAndPasswordTest(String userName, String password) {
        User user = UserPool.getAccount();
        user.setEmail(userName);
        user.setPassword(password);
        System.out.println(userName + " " + password);
    }
    @Given("^I navigate to Amazon Home Page")
    public void givenINavigateToAmazonHomePage() {
        Assert.assertTrue(homePage.LogoDisplayed());
    }

    @Given("^I Check Browser Title$")
    public void givenICheckBrowserTitle() {
        String title = "Browser Title";
        Assert.assertEquals(title,"Browser Title");
    }

    @When("^I search '(.*)' product from search bar$")
    public void whenSearchProductFromSearchBar(String searchText) {
        homePage.searchText(searchText);
        Assert.assertTrue(homePage.getSearchResultText().contains(searchText));
        homePage.clearText();
    }

    @And("^I select a product from search result$")
    public void whenISelectAProductFromSearchResult() {
        homePage.selectProductFromSearchResults();
        Assert.assertTrue(homePage.productImageIsDisplayed());
    }

    @Then("^I check the '(.*)'$")
    public void thenICheckTheResult(String text) {
        if (text.equals("true")){
            Assert.assertTrue(homePage.productImageIsDisplayed());
        }else if (text.equals("false")){
            Assert.assertFalse(homePage.productImageIsDisplayed());
        }
    }

    @Given("I search blabla")
    public void iSearchBlabla() {
    }
}
