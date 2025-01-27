package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverConfigurations {

    public static String url;
    public static int implicitWait;

    static {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties")) {
            Properties props = new Properties();
            props.load(fis);
            url = props.getProperty("baseUrl");
            implicitWait = Integer.parseInt(props.getProperty("implicitWait"));
        } catch (Exception e) {
            throw new RuntimeException("Error loading configuration: " + e.getMessage());
        }
    }
}
