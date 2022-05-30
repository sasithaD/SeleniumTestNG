package utils;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class TestBase {

    public static WebDriver driver;
    public static Properties properties;
    public static Logger testBaseLogger = Logger.getLogger(String.valueOf(TestBase.class));
    public static SoftAssert softAssert = new SoftAssert();

    public static void readPropertyFile() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("configurations/properties/config.properties");
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
                System.setProperty("webdriver.chrome.driver", "configurations/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "configurations/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void setupPreRequisitesWithBrowserList(String browser) {
        // readPropertyFile();
        // List<String> browsers = List.of(properties.getProperty("browser").split(","));

        // if (browsers.size() > 0) {
        //  for (String browser : browsers) {

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "configurations/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","configurations/drivers/geckodriver.exe");
                //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                //capabilities.setCapability("marionette",true);
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "configurations/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }
        //  }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // } else
        //  testBaseLogger.info("Unable to proceed without specific browser name in Config.properties file");

    }



    public static void setupUrl() {
        driver.get(properties.getProperty("url"));
    }

    public static void typeOnElement(WebElement element, String inputValue) {
        if (!inputValue.isEmpty()) {
            element.clear();
            testBaseLogger.info("\nTyping on element " + element + " value: " + inputValue + "");
            element.sendKeys(inputValue);
            testBaseLogger.info("Typing successful");
        } else {
            testBaseLogger.info("No input value specified for " + element + "");
        }
    }

    public static void typeOnElementWithEnter(WebElement element, String inputValue) {
        if (!inputValue.isEmpty()) {
            element.clear();
            testBaseLogger.info("\nTyping on element:  " + element + " value: " + inputValue);
            element.sendKeys(inputValue);
            element.sendKeys(Keys.RETURN);
            testBaseLogger.info("Typing successful");
        } else {
            testBaseLogger.info("No value specified for " + element);
        }
    }

    public static void clickOnElement(WebElement element) {
        testBaseLogger.info("Clicking on element " + element + "");
        element.click();
        testBaseLogger.info("Clicking successful");
    }

    public static String getElementText(WebElement element) {
        testBaseLogger.info("Retrieving the element text of " + element + "");
        String elementText = element.getText();
        if (!elementText.isEmpty()) {
            testBaseLogger.info("Retrieving text successful");
        } else {
            testBaseLogger.info("No text found on specific element " + element + "");
        }
        return elementText;
    }

    public static void selectValueFromAutoSuggestionListInTextField(WebElement element) {
        testBaseLogger.info("Clicking on element " + element + "");
        element.sendKeys(Keys.ARROW_DOWN +""+ Keys.ENTER);
        testBaseLogger.info("Item was successfully selected from the Auto suggestion list");
    }


    public void selectDropDownByText(WebElement element, String text) {
        testBaseLogger.info("Selecting value from dropdown");
        Select select = new Select(element);
        select.selectByVisibleText(text);
        testBaseLogger.info("successfully selected from dropdown");
    }

    public static void softAssertEqual(String actualValue, String expectedValue, String errorMessage) {
        softAssert.assertEquals(actualValue, expectedValue, errorMessage);
    }

    public static void assertEqual(String actualValue, String expectedValue, String errorMessage) {
        Assert.assertEquals(actualValue, expectedValue, errorMessage);
    }

    public String[][] readExcelData(String excelFileName, String sheetName) {

        String[][] excelDataList = null;

        try {
            FileInputStream fileStream = new FileInputStream(excelFileName);
            Workbook workBook = Workbook.getWorkbook(fileStream);
            Sheet excelSheet = workBook.getSheet(sheetName);

            int totalNoOfCols = excelSheet.getColumns();
            int totalNoOfRows = excelSheet.getRows();

            excelDataList = new String[totalNoOfRows-1][totalNoOfCols];

            for (int i= 1 ; i < totalNoOfRows; i++) {

                for (int j=0; j < totalNoOfCols; j++) {
                    excelDataList[i-1][j] = excelSheet.getCell(j, i).getContents();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            testBaseLogger.info("Unable to locate file");
        } catch (IOException e) {
            e.printStackTrace();
            testBaseLogger.info("Unable to read file");
        } catch (BiffException e) {
            e.printStackTrace();
            testBaseLogger.info("Unable to read the excel file");
        }
        return excelDataList;
    }

    public static boolean isElementEnabled(WebElement element) {
        boolean isEnabled = true;
        testBaseLogger.info("Element Located " + element + "");
        if (element.isEnabled()){
            isEnabled = true;
            testBaseLogger.info("Element is enabled");
        } else {
            isEnabled = false;
            testBaseLogger.info("Element is disabled");
        }
         return isEnabled;

    }

}
