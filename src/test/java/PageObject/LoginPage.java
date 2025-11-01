// pages/login.page.java
package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators using @FindBy annotation
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "error")
    private WebElement errorMessage;

    @FindBy(className = "post-title")
    private WebElement successMessage;

    @FindBy(linkText = "Log out")
    private WebElement logoutButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Page Actions with Allure Steps
    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    @Step("Click submit button")
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    @Step("Login with username: {username}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }

    @Step("Get error message")
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    @Step("Get success message")
    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }

    @Step("Check if error message is displayed")
    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Check if logout button is displayed")
    public boolean isLogoutButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(logoutButton));
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click logout button")
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    @Step("Get current URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Check if on login page")
    public boolean isOnLoginPage() {
        return getCurrentUrl().contains("practice-test-login");
    }
}