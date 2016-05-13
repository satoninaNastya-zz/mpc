package CucumberSteps;


import DriverLogics.ProxyServer;
import DriverLogics.WebDriverHelper;

import PageFactory.MainPage;
import PageFactory.SearchResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Steps {
    WebDriver driver = WebDriverHelper.getCurrentDriver();

    @Before
    public void doHar() throws Exception {
        ProxyServer.doHar();
    }


    @Given("^open site (.*)$")
    public void openSite(String site) throws Exception {
        driver.get(site);
    }

    @When("^press to (.*) tab$")
    public void pressToDownloadGamesTab(String tabName) throws Throwable {
        MainPage.getMainPage(driver).pressTab(tabName);
    }

    @Then("^page (.*) is open$")
    public void openPage(String url) throws Throwable {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @And("^press Reviews menu (.*) item$")
    public void pressReviewsMenuItem(String itemName) throws Throwable {
        MainPage.getMainPage(driver).pressItemReviewsMenu(itemName);
    }

    @When("^press to logo \"Free Games by RSS\"$")
    public void pressToFreeGamesByRSSLogo() throws Throwable {
        MainPage.getMainPage(driver).pressToFreeGamesByRSSLogo();
    }

    @When("^press to \"MPC\" logo$")
    public void pressToMPCLogo() throws Throwable {
        MainPage.getMainPage(driver).pressToMPCLogo();
    }

    @When("^enter (.*) into the search field$")
    public void enterIntoTheSearchField(String searchWord) throws Throwable {
        MainPage.getMainPage(driver).enterIntoTheSearchField(searchWord);
    }

    @And("^press Search button$")
    public void pressSearchButton() throws Throwable {
        MainPage.getMainPage(driver).pressSearchButton();
    }

    @And("^was found a few games$")
    public void wasFoundAFewGames() throws Throwable {
        Assert.assertTrue(SearchResultsPage.getSearchResultsPage(driver).getSearchResultsCount() > 0);
    }
}
