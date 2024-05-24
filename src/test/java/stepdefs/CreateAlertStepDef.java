package stepdefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.AlertElements;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.io.IOException;
import java.util.Properties;

public class CreateAlertStepDef {
    private AlertElements elements;
    private WebDriverWait wait;
    private ConfigReader configReader;
    public String outboundDate;


    WebDriver driver = DriverFactory.getDriver();


    @Given("navigate to the application URL")
    public void navigate_to_the_application_url() throws Throwable {
        configReader = new ConfigReader();
        try{driver.get(configReader.readFromPropertyFile("url"));}
        catch (WebDriverException e) {}
    }
    @Given("accept cookies")
    public void accept_cookies() {
    elements = new AlertElements(driver);
    elements.getAcceptCookies().click();
    
    }
    @Given("sign in with valid credentials")
    public void sign_in_with_valid_credentials() throws IOException {
    elements.getSignInLink().click();
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("email"));
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("pass"));
        elements.getSignInButton().click();
    }
    @When("search for a destination")
    public void search_for_a_destination() {
        Actions action = new Actions(driver);
        action.click(elements.getWhereToField()).pause(1000).
                sendKeys("nyc" , Keys.ENTER).build().perform();
        elements.getSearchButton().click();
    }
    @When("create a new alert with specified dates")
    public void create_a_new_alert_with_specified_dates() {
        elements.getCreateAlertButton().click();
        elements.getDepartStartDate().click();
        elements.getNextMonth().click();
        elements.getStartDate().click();
        elements.getEndDate().click();
        elements.getreturnStartDate().click();
        elements.getNextMonth().click();
        elements.getStartDate().click();
        elements.getEndDate().click();
        elements.getCreateAlertButtonPopup().click();
    }

    @Then("should see the confirmation message")
    public void should_see_the_confirmation_message() {
        String alertMsg = elements.getAlertmsg().getText();
        outboundDate = elements.getOutboundDate().getText();
        Assert.assertEquals(alertMsg,"Alert created!");
    }

    @Then("should be able to logout successfully")
    public void should_be_able_to_logout_successfully() {
        elements.getCloseAlertPopup().click();
        elements.getAccountButton().click();
        elements.getLogoutButton().click();
    }

    @When("navigate to the list of alerts")
    public void navigate_to_the_list_of_alerts() {
        elements.getAlertButton().click();
    }

    @When("edit an existing alert")
    public void edit_an_existing_alert() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        try {jse.executeAsyncScript("arguments[0].click();",elements.getEditAlertButton());}
        catch (Exception e) {}
        elements.getAddPassengersButton().click();
        elements.getSaveButton().click();

    }

    @Then("should see the confirmation message for alert edited")
    public void should_see_the_confirmation_message_for_edit() {
        String alertMsg = elements.getConfirmEditAlert().getText();
        Assert.assertEquals(alertMsg,"Alerts updated successfully");
    }

    @When("delete an existing alert")
    public void delete_an_existing_alert() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        try {jse.executeAsyncScript("arguments[0].click();",elements.getEditAlertButton());}
        catch (Exception e) {}
        elements.getDeleteButton().click();
        elements.getDeleteButton().click();
    }

    @Then("should see the confirmation message for alert deleted")
    public void should_see_the_confirmation_message_for_deletion() {
        String alertMsg = elements.getAlertmsg().getText();
        Assert.assertEquals(alertMsg,"Alert has been deleted successfully");
    }

}

