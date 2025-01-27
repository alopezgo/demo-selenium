package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverConfigurations;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser") // Se recibe el parámetro opcional desde TestNG
    public void beforeMethod(@Optional("chrome") String browser) {
        String browserFromConsole = System.getProperty("browser");

        if (browserFromConsole != null && !browserFromConsole.isEmpty()) {
            System.out.println("Browser specified in console: " + browserFromConsole);
            browser = browserFromConsole; // Sobrescribe el valor recibido
        } else {
            System.out.println("No browser specified in console, using: " + browser);
        }

        try {
            driver = DriverFactory.getDriver(browser); // Inicializar WebDriver
            driver.manage().window().maximize();
            driver.get(DriverConfigurations.url); // Navegar a la URL configurada
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
