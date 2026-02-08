package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginValidTest extends BaseTest {

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

    @Test(priority = 1, description = "Verify login page is loaded with all required elements")
    public void testLoginPageUIElements() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not displayed");
            Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed");
            Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
        } catch (Exception e) {
            throw new Exception("Test failed: testLoginPageUIElements - " + e.getMessage(), e);
        }
    }

    @Test(priority = 2, description = "Verify successful login with valid credentials")
    public void testValidLoginWithRememberMe() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.performLogin("test@example.com", "ValidPassword123");
            loginPage.clickRememberMe();
            loginPage.clickLoginButton();
            
            Thread.sleep(5000);
            String currentUrl = driver.getCurrentUrl();
            Assert.assertNotEquals(currentUrl, "https://login.salesforce.com/?locale=in", 
                "Login failed: Still on login page");
        } catch (Exception e) {
            throw new Exception("Test failed: testValidLoginWithRememberMe - " + e.getMessage(), e);
        }
    }

    @Test(priority = 3, description = "Verify login with valid username and password")
    public void testValidLogin() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.enterUsername("test.user@salesforce.com");
            loginPage.enterPassword("SecurePassword@123");
            loginPage.clickLoginButton();
            
            Thread.sleep(5000);
            String currentUrl = driver.getCurrentUrl();
            Assert.assertNotEquals(currentUrl, "https://login.salesforce.com/?locale=in", 
                "Login failed: Still on login page");
        } catch (Exception e) {
            throw new Exception("Test failed: testValidLogin - " + e.getMessage(), e);
        }
    }

    @Test(priority = 4, description = "Verify remember me checkbox functionality")
    public void testRememberMeCheckbox() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.clickRememberMe();
            Assert.assertTrue(driver.findElement(org.openqa.selenium.By.xpath("//input[@id='rememberUn']")).isSelected(), 
                "Remember me checkbox not selected");
        } catch (Exception e) {
            throw new Exception("Test failed: testRememberMeCheckbox - " + e.getMessage(), e);
        }
    }

    @Test(priority = 5, description = "Verify username field accepts valid input")
    public void testUsernameFieldInput() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.enterUsername("valid.user@test.com");
            String enteredValue = driver.findElement(org.openqa.selenium.By.xpath("//input[@id='username']")).getAttribute("value");
            Assert.assertEquals(enteredValue, "valid.user@test.com", "Username field input mismatch");
        } catch (Exception e) {
            throw new Exception("Test failed: testUsernameFieldInput - " + e.getMessage(), e);
        }
    }

    @Test(priority = 6, description = "Verify password field accepts valid input and hides characters")
    public void testPasswordFieldInput() throws Exception {
        try {
            loginPage.navigateToLoginPage();
            loginPage.enterPassword("MySecurePassword123");
            String fieldType = driver.findElement(org.openqa.selenium.By.xpath("//input[@id='password']")).getAttribute("type");
            Assert.assertEquals(fieldType, "password", "Password field is not of type password");
        } catch (Exception e) {
            throw new Exception("Test failed: testPasswordFieldInput - " + e.getMessage(), e);
        }
    }
}
