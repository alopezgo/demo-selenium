package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverConfigurations;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser") // Recibe el navegador desde TestNG XML
    public void beforeMethod(@Optional("chrome") String browser) {
        try {
            driver = DriverFactory.getDriver(browser);
            driver.manage().window().maximize();
            driver.get(DriverConfigurations.url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println(browser + " WebDriver initialized successfully.");
        } catch (Exception e) {
            System.err.println("Error initializing WebDriver: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver quit successfully.");
        }
    }
}
