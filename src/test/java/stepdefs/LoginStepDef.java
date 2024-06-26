package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.AlertElements;
import org.FlightFinder.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.io.IOException;
import java.time.Duration;

public class LoginStepDef  {

    private LoginPage elements;
    private WebDriverWait wait;
    private ConfigReader configReader;
    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on login page")
    public void user_is_on_login_page() throws Throwable {
        configReader = new ConfigReader();
        elements = new LoginPage(driver);
        try{driver.get(configReader.readFromPropertyFile("url"));}
        catch (WebDriverException e) {}
        try{
            elements.getAcceptCookies().click();}
        catch(WebDriverException e) {
            elements.getAcceptCookies().click();
        }
        elements.getSignInLink().click();
    }

    @When("user enters username")
    public void user_enters_username() throws IOException {
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("email"));
    }
    @And("user enters password")
    public void user_enters_password() throws IOException {
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("pass"));
    }

    @And("user clicks on Login button")
    public void user_clicks_on_login_button() {
        elements.getSignInButton().click();
    }

    @Then("verify the page title")
    public void page_title_should_be() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        String title = "Easily Find Reward Flight Availability: Redeem British Airways Avios Points";
        wait.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(title,driver.getTitle());
    }

    @And("user clicks on account button")
    public void user_clicks_on_account_button() {
        elements.getAccountButton().click();
    }

    @Then("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        elements.getLogoutButton().click();
    }

}
