package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.time.Duration;

public class LoginStepDef  {

    private LoginPage loginPage;
    private WebDriverWait wait;
    private ConfigReader configReader;
    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on login page")
    public void user_is_on_login_page() throws Throwable {
        configReader = new ConfigReader();
        try{driver.get(configReader.readFromPropertyFile("url"));}
        catch (WebDriverException e) {}
        loginPage = new LoginPage(driver);
        loginPage.getAcceptCookies().click();
        loginPage.getSignInLink().click();
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        loginPage.getEmailTextField().sendKeys("strokenavior@gmail.com");
    }
    @And("user enters password {string}")
    public void user_enters_password(String string) {
        loginPage.getPasswordTextField().sendKeys("Password@123");
    }
    @And("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.getSignInButton().click();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleIs("Easily Find Reward Flight Availability: Redeem British Airways Avios Points"));
        Assert.assertEquals(string,driver.getTitle());
    }

    @And("user clicks on account button")
    public void user_clicks_on_account_button() {
        loginPage.getAccountButton().click();
    }

    @Then("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        loginPage.getLogoutButton().click();
    }

}
