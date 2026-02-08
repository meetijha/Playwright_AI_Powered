package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginInvalidTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeTest(alwaysRun = true)
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @AfterTest(alwaysRun = true)
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test(priority = 1, description = "Verify login fails with invalid username")
    public void testLoginWithInvalidUsername() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.performLogin("invalid.user@test.com", "ValidPassword123");
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid username");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithInvalidUsername - " + e.getMessage(), e);
        }
    }

    @Test(priority = 2, description = "Verify login fails with invalid password")
    public void testLoginWithInvalidPassword() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.performLogin("test@example.com", "InvalidPassword123");
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid password");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithInvalidPassword - " + e.getMessage(), e);
        }
    }

    @Test(priority = 3, description = "Verify login fails with both invalid username and password")
    public void testLoginWithBothInvalidCredentials() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.performLogin("invalid.user@test.com", "InvalidPassword123");
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid credentials");
            String errorMsg = loginPage.getErrorMessage();
            Assert.assertNotNull(errorMsg, "Error message is null");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithBothInvalidCredentials - " + e.getMessage(), e);
        }
    }

    @Test(priority = 4, description = "Verify login fails with empty username")
    public void testLoginWithEmptyUsername() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.enterPassword("SomePassword123");
            loginPage.clickLoginButton();
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty username");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithEmptyUsername - " + e.getMessage(), e);
        }
    }

    @Test(priority = 5, description = "Verify login fails with empty password")
    public void testLoginWithEmptyPassword() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.enterUsername("test@example.com");
            loginPage.clickLoginButton();
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty password");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithEmptyPassword - " + e.getMessage(), e);
        }
    }

    @Test(priority = 6, description = "Verify login fails with both username and password empty")
    public void testLoginWithBothCredentialsEmpty() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.clickLoginButton();
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty credentials");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithBothCredentialsEmpty - " + e.getMessage(), e);
        }
    }

    @Test(priority = 7, description = "Verify login fails with special characters in username")
    public void testLoginWithSpecialCharactersInUsername() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.performLogin("test@#$%user@test.com", "ValidPassword123");
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for special characters in username");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithSpecialCharactersInUsername - " + e.getMessage(), e);
        }
    }

    @Test(priority = 8, description = "Verify login fails with SQL injection attempt")
    public void testLoginWithSQLInjectionAttempt() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.performLogin("' OR '1'='1", "' OR '1'='1");
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for SQL injection attempt");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithSQLInjectionAttempt - " + e.getMessage(), e);
        }
    }

    @Test(priority = 9, description = "Verify login fails with whitespace only in username")
    public void testLoginWithWhitespaceOnlyUsername() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.performLogin("   ", "ValidPassword123");
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for whitespace only username");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithWhitespaceOnlyUsername - " + e.getMessage(), e);
        }
    }

    @Test(priority = 10, description = "Verify login fails with very long password")
    public void testLoginWithVeryLongPassword() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            String longPassword = "a".repeat(500);
            loginPage.performLogin("test@example.com", longPassword);
            
            Thread.sleep(3000);
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for very long password");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginWithVeryLongPassword - " + e.getMessage(), e);
        }
    }
}
