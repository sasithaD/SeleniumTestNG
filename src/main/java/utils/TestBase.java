package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;

    public static void readPropertyFile() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/configurations/config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setupPreRequisites() {
        readPropertyFile();
        String browserName = properties.getProperty("browser");

        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void setupUrl() {
        driver.get(properties.getProperty("url"));
    }
}
