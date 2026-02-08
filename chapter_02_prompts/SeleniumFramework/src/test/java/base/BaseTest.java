package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("========== Test Suite Initialization ==========");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("========== Test Suite Completion ==========");
    }

    @BeforeTest
    public void setUp() throws Exception {
        try {
            driver = initializeDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new Exception("Driver initialization failed: " + e.getMessage(), e);
        }
    }

    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.err.println("Error during driver teardown: " + e.getMessage());
        }
    }

    private WebDriver initializeDriver(String browserName) throws Exception {
        WebDriver webDriver;
        try {
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                default:
                    throw new Exception("Unsupported browser: " + browserName);
            }
        } catch (Exception e) {
            throw new Exception("Failed to initialize WebDriver for browser: " + browserName + " - " + e.getMessage(), e);
        }
        return webDriver;
    }
}
