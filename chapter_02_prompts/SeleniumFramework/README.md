# Salesforce Selenium Automation Framework

Enterprise-level Selenium automation framework for testing Salesforce login functionality.

## Project Structure

```
SeleniumFramework/
├── pom.xml
├── src/
│   ├── main/java/pages/
│   │   └── LoginPage.java
│   └── test/java/
│       ├── base/
│       │   └── BaseTest.java
│       ├── tests/
│       │   ├── LoginValidTest.java
│       │   └── LoginInvalidTest.java
│       └── resources/
│           └── testng.xml
```

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser

## Installation

1. Clone/Extract the project
2. Navigate to project root
3. Run: `mvn clean install`

## Running Tests

### All Tests
```
mvn test
```

### Specific Test Class
```
mvn test -Dtest=LoginValidTest
mvn test -Dtest=LoginInvalidTest
```

### Using TestNG Configuration
```
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

## Test Coverage

### LoginValidTest (6 test cases)
- Login page UI elements verification
- Successful login with valid credentials
- Login with remember me functionality
- Remember me checkbox functionality
- Username field input validation
- Password field input validation

### LoginInvalidTest (10 test cases)
- Invalid username login attempt
- Invalid password login attempt
- Both credentials invalid
- Empty username
- Empty password
- Both credentials empty
- Special characters in username
- SQL injection attempt
- Whitespace only username
- Very long password

## Technology Stack

- Selenium WebDriver 4.15.0
- TestNG 7.8.1
- Maven 3.11.0
- WebDriverManager 5.6.3
- Java 11

## Framework Features

- Page Object Model with PageFactory
- XPath-based element locators
- WebDriverWait for explicit waits
- Comprehensive exception handling
- TestNG annotations (@Test, @BeforeTest, @AfterTest, @BeforeSuite, @AfterSuite)
- Implicit and explicit wait strategies
- Enterprise-grade error handling
