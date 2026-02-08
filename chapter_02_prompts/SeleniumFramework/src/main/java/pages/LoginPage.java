package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@id='forgot_password_link']")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get("https://login.salesforce.com/?locale=in");
        wait.until(ExpectedConditions.presenceOf(usernameField));
    }

    public void enterUsername(String username) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameField));
            usernameField.clear();
            usernameField.sendKeys(username);
        } catch (Exception e) {
            throw new Exception("Failed to enter username: " + e.getMessage(), e);
        }
    }

    public void enterPassword(String password) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            passwordField.clear();
            passwordField.sendKeys(password);
        } catch (Exception e) {
            throw new Exception("Failed to enter password: " + e.getMessage(), e);
        }
    }

    public void clickLoginButton() throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (Exception e) {
            throw new Exception("Failed to click login button: " + e.getMessage(), e);
        }
    }

    public void clickRememberMe() throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (!rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
        } catch (Exception e) {
            throw new Exception("Failed to click remember me checkbox: " + e.getMessage(), e);
        }
    }

    public boolean isErrorMessageDisplayed() throws Exception {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Error message verification failed: " + e.getMessage(), e);
        }
    }

    public String getErrorMessage() throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (Exception e) {
            throw new Exception("Failed to retrieve error message: " + e.getMessage(), e);
        }
    }

    public void performLogin(String username, String password) throws Exception {
        try {
            enterUsername(username);
            enterPassword(password);
            clickLoginButton();
        } catch (Exception e) {
            throw new Exception("Login action failed: " + e.getMessage(), e);
        }
    }

    public boolean isUsernameFieldDisplayed() throws Exception {
        try {
            return wait.until(ExpectedConditions.visibilityOf(usernameField)).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Username field visibility check failed: " + e.getMessage(), e);
        }
    }

    public boolean isPasswordFieldDisplayed() throws Exception {
        try {
            return wait.until(ExpectedConditions.visibilityOf(passwordField)).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Password field visibility check failed: " + e.getMessage(), e);
        }
    }

    public boolean isLoginButtonDisplayed() throws Exception {
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Login button visibility check failed: " + e.getMessage(), e);
        }
    }
}
