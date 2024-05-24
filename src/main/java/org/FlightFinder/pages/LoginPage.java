package org.FlightFinder.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public static WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void synchronised(By locator, WebElement element)  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        try {
            Thread.sleep(2000); }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath="//button[text()='I agree']")
    WebElement acceptCookies;

    @FindBy(xpath="//button[text()='Sign In']")
    WebElement signInLink;

    @FindBy(xpath="//input[@name='email']")
    WebElement emailTextField;

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordTextField;

    @FindBy(xpath="//div[@class='column']/button[text()='Sign In']")
    WebElement signInButton;

    @FindBy(xpath="(//div[@role='listbox'])[2]")
    WebElement accountButton;

    @FindBy(xpath="//span[text()='Logout']")
    WebElement logoutButton;


    public WebElement getAcceptCookies() {
        synchronised(By.xpath("//button[text()='I agree']"),acceptCookies);
        return acceptCookies;
    }

    public WebElement getSignInLink() {
        synchronised(By.xpath("//button[text()='Sign In']"),signInLink);
        return signInLink;
    }

    public WebElement getEmailTextField() {
        synchronised(By.xpath("//input[@name='email']"),emailTextField);
        return emailTextField;
    }

    public WebElement getPasswordTextField() {
        synchronised(By.xpath("//input[@name='password']"),passwordTextField);
        return passwordTextField;
    }

    public WebElement getSignInButton() {
        synchronised(By.xpath("//div[@class='column']/button[text()='Sign In']"),signInButton);
        return signInButton;
    }

    public WebElement getAccountButton() {
        synchronised(By.xpath("(//div[@role='listbox'])[2]"),accountButton);
        return accountButton;
    }

    public WebElement getLogoutButton() {
        synchronised(By.xpath("//span[text()='Logout']"),logoutButton);
        return logoutButton;
    }

}
