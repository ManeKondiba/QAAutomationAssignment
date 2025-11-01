// tests/login.test.java
package TestCases;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObject.LoginPage;
import utils.config;

@Epic("Login Module")
@Feature("User Authentication")
public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    @Step("Navigate to login page and initialize page objects")
    public void setup() {
        super.setupDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Test(priority = 1, description = "Verify login with valid credentials")
    @Story("Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify that user can login successfully with valid username and password")
   
    public void testLoginWithValidCredentials() {
        Allure.step("Enter valid username: " + config.VALID_USERNAME);
        Allure.step("Enter valid password");
        loginPage.login(config.VALID_USERNAME, config.VALID_PASSWORD);
        
        Allure.step("Verify logout button is displayed");
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed(), 
            "Logout button should be visible after successful login");
        
        Allure.step("Verify success message");
        String successMessage = loginPage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Logged In Successfully", 
            "Success message should match");
        
        Allure.step("Verify URL contains 'logged-in-successfully'");
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("logged-in-successfully"), 
            "URL should contain 'logged-in-successfully'");
        
        Allure.addAttachment("Success URL", "text/plain", currentUrl);
    }

    @Test(priority = 2, description = "Verify login with invalid username")
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that appropriate error message is displayed when user enters invalid username")
   
    public void testLoginWithInvalidUsername() {
        Allure.step("Enter invalid username: invalidUser");
        Allure.step("Enter valid password");
        loginPage.login("invalidUser", config.VALID_PASSWORD);
        
        Allure.step("Verify error message is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
            "Error message should be displayed");
        
        Allure.step("Verify error message text");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Your username is invalid!"), 
            "Error message should indicate invalid username");
        
        Allure.addAttachment("Error Message", "text/plain", errorMessage);
    }

    @Test(priority = 3, description = "Verify login with invalid password")
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that appropriate error message is displayed when user enters invalid password")
   
    public void testLoginWithInvalidPassword() {
        Allure.step("Enter valid username");
        Allure.step("Enter invalid password: wrongPassword");
        loginPage.login(config.VALID_USERNAME, "wrongPassword");
        
        Allure.step("Verify error message is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
            "Error message should be displayed");
        
        Allure.step("Verify error message text");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Your password is invalid!"), 
            "Error message should indicate invalid password");
        
        Allure.addAttachment("Error Message", "text/plain", errorMessage);
    }

    @Test(priority = 4, description = "Verify login with blank fields")
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that validation message appears when user tries to login with blank fields")
   
    public void testLoginWithBlankFields() {
        Allure.step("Leave username field empty");
        Allure.step("Leave password field empty");
        Allure.step("Click submit button");
        loginPage.clickSubmit();
        
        Allure.step("Verify error message is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
            "Error message should be displayed for blank fields");
        
        Allure.step("Verify validation message");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Your username is invalid!"), 
            "Validation message should appear");
        
        Allure.addAttachment("Validation Message", "text/plain", errorMessage);
    }

    @Test(priority = 5, description = "Verify logout functionality")
    @Story("Logout")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify that user can logout successfully and is redirected to login page")
   
    public void testLogoutFunctionality() {
        Allure.step("Login with valid credentials");
        loginPage.login(config.VALID_USERNAME, config.VALID_PASSWORD);
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed(), 
            "Should be logged in successfully");
        
        Allure.step("Click logout button");
        loginPage.clickLogout();
        
        Allure.step("Verify user is redirected to login page");
        Assert.assertTrue(loginPage.isOnLoginPage(), 
            "Should be redirected to login page after logout");
        
        Allure.step("Verify URL contains 'practice-test-login'");
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("practice-test-login"), 
            "URL should contain 'practice-test-login'");
        
        Allure.addAttachment("Login Page URL", "text/plain", currentUrl);
    }

    @AfterMethod
    @Step("Close browser and cleanup")
    public void teardown() {
        super.teardownDriver();
    }
}