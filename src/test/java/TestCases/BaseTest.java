// tests/BaseTest.java
package TestCases;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.config;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setupSuite() {
       
        System.out.println("Starting Test Execution with Allure Reports");
        
    }

    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(config.PAGE_LOAD_TIMEOUT));
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Take screenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
                
                // Attach to Allure report
                Allure.addAttachment(
                    "Failure Screenshot - " + result.getName(), 
                    "image/png", 
                    new ByteArrayInputStream(screenshotBytes), 
                    "png"
                );
                
                System.out.println("Screenshot captured for failed test: " + result.getName());
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    public void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void cleanupSuite() {
       
        System.out.println("All tests completed!");
        System.out.println("To view Allure report, run: mvn allure:serve");
      
    }
}