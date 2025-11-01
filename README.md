# 🧪 QA Automation Testing Assignment

## 📝 Project Overview
This project contains automated test cases for the login functionality of a demo web application using:
- **Selenium WebDriver 4.15.0** - Browser automation
- **Java 11** - Programming language
- **TestNG 7.8.0** - Testing framework
- **Page Object Model (POM)** - Design pattern
- **Allure Reports 2.24.0** - Test reporting
- **Maven** - Build and dependency management

**Test Application URL:** https://practicetestautomation.com/practice-test-login/

---

## 🏗️ Project Structure

```
qa-automation-assignment/
│
├── tests/
│   └── login.test.java                    # Test cases
│
├── pages/
│   └── login.page.java                    # Page Object Model
│
├── utils/
│   └── config.java                        # Configuration constants
│
├── pom.xml                                # Maven dependencies
├── testng.xml                             # TestNG configuration
├── README.md                              # This file
├── selenium.config.java                   # Selenium WebDriver configuration
└── .gitignore                             # Git ignore file
```

---

## ✅ Test Scenarios Covered

| # | Test Case | Description | Expected Result |
|---|-----------|-------------|-----------------|
| 1 | Login with valid credentials | Enter valid username and password | Redirected to "Logged In Successfully" page |
| 2 | Login with invalid username | Enter wrong username and valid password | Error: "Your username is invalid!" |
| 3 | Login with invalid password | Enter valid username and wrong password | Error: "Your password is invalid!" |
| 4 | Login with blank fields | Leave both fields empty and click login | Validation message appears |
| 5 | Logout functionality | After successful login, click logout | Redirected back to login page |

---

## 🛠️ Prerequisites

Before running the tests, ensure you have the following installed:

1. **Java JDK 11 or higher**
   ```bash
   java -version
   ```

2. **Maven 3.6 or higher**
   ```bash
   mvn -version
   ```

3. **Google Chrome Browser** (latest version recommended)

---

## 📦 Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd QA-Automation-Assignment
```

### 2. Install Dependencies
```bash
mvn clean install
```

This command will:
- Download all required dependencies (Selenium, JUnit, WebDriverManager)
- Compile the project
- Run the tests

---

## 🚀 Running the Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn test -Dtest=LoginTest
```

### Run Specific Test Method
```bash
mvn test -Dtest=LoginTest#testLoginWithValidCredentials
```

### Run Tests with TestNG XML
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run Tests with Verbose Output
```bash
mvn clean test -X
```

---

## 📊 Test Reports

### TestNG HTML Report (Default)
After running tests, TestNG automatically generates an HTML report:
```bash
mvn clean test
```
Report will be generated at: `test-output/index.html`

Open in browser:
```bash
# Windows
start test-output/index.html

# Mac
open test-output/index.html

# Linux
xdg-open test-output/index.html
```

### Generate Surefire Report (HTML)
```bash
mvn surefire-report:report
```
Report will be generated at: `target/site/surefire-report.html`

### Generate Allure Report (Optional - Bonus Feature)
```bash
# Generate Allure results
mvn clean test

# Serve Allure report
mvn allure:serve
```

---

## 🔧 Configuration

### Valid Test Credentials
The valid credentials are configured in `TestConfig.java`:
- **Username:** `student`
- **Password:** `Password123`

### Browser Configuration
By default, tests run on **Chrome**. To change the browser, modify `TestConfig.java`.

### Timeouts
- Implicit Wait: 10 seconds
- Explicit Wait: 10 seconds
- Page Load Timeout: 30 seconds

---

## 🎯 Best Practices Implemented

✅ **Page Object Model (POM)** - Separation of page elements and test logic  
✅ **Explicit Waits** - Using WebDriverWait for reliable element interactions  
✅ **Meaningful Assertions** - Clear assertion messages for better debugging  
✅ **Test Independence** - Each test can run independently  
✅ **Clean Code** - Proper naming conventions and code organization  
✅ **Configuration Management** - Centralized test data in TestConfig  
✅ **Proper Test Lifecycle** - Setup and teardown methods for browser management  

---

## 📁 Key Files Description

### login.page.java (Page Object Model)
- Contains all web elements and actions for the login page
- Uses PageFactory for element initialization
- Implements reusable methods for login operations

### login.test.java (Test Cases)
- Contains all 5 test scenarios
- Uses TestNG annotations (@Test, @BeforeMethod, @AfterMethod)
- Implements assertions to validate expected results
- Test priority order for sequential execution

### testng.xml (TestNG Configuration)
- TestNG suite configuration
- Defines test execution order
- Configures test grouping and parallel execution options

### config.java (Configuration)
- Stores valid credentials
- Contains timeout values
- Centralizes configuration parameters

### selenium.config.java (Selenium Configuration)
- WebDriver factory for multiple browsers
- Browser-specific options and configurations
- Centralized driver management

### pom.xml (Maven Configuration)
- Manages project dependencies
- Configures Selenium WebDriver 4.15.0
- Includes TestNG 7.8.0 for testing framework
- WebDriverManager for automatic driver management
- ExtentReports and Allure for advanced reporting

---

## 🐛 Troubleshooting

### Issue: ChromeDriver version mismatch
**Solution:** WebDriverManager automatically handles driver versions. Ensure you have the latest Chrome browser installed.

### Issue: Tests fail with timeout
**Solution:** Increase timeout values in `TestConfig.java` if you have a slow internet connection.

### Issue: Element not found
**Solution:** The Page Object Model uses explicit waits. Check if the website structure has changed.

---

## 📞 Contact & Support

For any questions or issues, please contact the project maintainer.

---

## 📄 License

This project is created for QA automation assignment purposes.

---

## 🎉 Bonus Features Included

✨ **WebDriverManager** - Automatic browser driver management  
✨ **TestNG Framework** - Powerful test execution and reporting  
✨ **TestNG HTML Reports** - Built-in test reporting  
✨ **Allure Reports** - Beautiful test reporting (optional)  
✨ **ExtentReports** - Advanced HTML reports with screenshots  
✨ **Reusable Components** - Page Object Model with reusable methods  
✨ **Test Prioritization** - Ordered test execution with @priority  
✨ **Clear Documentation** - Comprehensive README with examples  
✨ **Proper Project Structure** - Following Maven standards  

---

**Happy Testing! 🚀**
