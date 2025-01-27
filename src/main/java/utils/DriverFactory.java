package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.manager", "true");
                return new ChromeDriver();

            case "firefox":
                System.setProperty("webdriver.manager", "true");
                return new FirefoxDriver();

            case "edge":
                System.setProperty("webdriver.manager", "true");
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
