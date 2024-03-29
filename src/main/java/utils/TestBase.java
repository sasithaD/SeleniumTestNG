package utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class TestBase {

    public static WebDriver driver;
    public static Properties properties;
    public static Logger testBaseLogger = Logger.getLogger(String.valueOf(TestBase.class));
    public static SoftAssert softAssert = new SoftAssert();
    public static Map<String, String> actualData = new HashMap<>();

    public static void readPropertyFile() {
        try {
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
                System.setProperty("webdriver.gecko.driver", "configurations/drivers/geckodriver.exe");
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

    public static void selectValueFromAutoSuggestionListInTextField(WebElement element, String txt) {
        element.clear();
        testBaseLogger.info("\nTyping on element:  " + element + " value: " + txt);
        element.sendKeys(txt);
        element.sendKeys(Keys.ARROW_DOWN + "" + Keys.ENTER);
        testBaseLogger.info("Item was successfully selected from the Auto suggestion list");

    }


    public static String getElementTextBy(By by) {
        testBaseLogger.info("Retrieving the element text of " + driver.findElement(by) + "");
        String elementText = driver.findElement(by).getText();
        if (!elementText.isEmpty()) {
            testBaseLogger.info("Retrieving text successful");
        } else {
            testBaseLogger.info("No text found on specific element " + driver.findElement(by) + "");
        }
        return elementText;
    }

    public void selectDropDownByText(WebElement element, String text) {
        testBaseLogger.info("Selecting value from dropdown");
        Select select = new Select(element);
        select.selectByVisibleText(text);
        testBaseLogger.info("successfully selected from dropdown");
    }

    public void selectDropDownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void softAssertFailure(String actualValue, String expectedValue, String errorMessage) {
        softAssert.assertEquals(actualValue, expectedValue, errorMessage);
        softAssert.fail(errorMessage);
    }

    public static void assertFailure(String actualValue, String expectedValue, String errorMessage) {
        Assert.assertEquals(actualValue, expectedValue, errorMessage);
        Assert.fail(errorMessage);
    }

    public static boolean isElementPresentAndDisplay(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementEnableForAction(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clearInputField(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public static void selectCheckBox(WebElement element) {
        if (!element.isSelected()) {
            clickOnElement(element);
        }
    }

    public static void disSelectCheckBox(WebElement element) {
        if (element.isSelected()) {
            clickOnElement(element);
        }
    }

    public static void waitUntilElementGetClickable(WebElement element) {
        try {
            String timeout = properties.getProperty("waitingTime");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.valueOf(timeout)));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (ElementClickInterceptedException e) {
            testBaseLogger.info("Failed. Due to : " + e.getLocalizedMessage() + "");
        } catch (NoSuchElementException e) {
            testBaseLogger.info("Failed. Due to : " + e.getLocalizedMessage() + "");
        } catch (TimeoutException e) {
            testBaseLogger.info("Failed. Due to : " + e.getLocalizedMessage() + "");
        }
    }

    public static void waitUntilVisibilityOfElement(By locator) {
        try {
            String timeout = properties.getProperty("waitingTime");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.valueOf(timeout)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            testBaseLogger.info("Failed. Due to : " + e.getLocalizedMessage() + "");
        } catch (TimeoutException e) {
            testBaseLogger.info("Failed. Due to : " + e.getLocalizedMessage() + "");
        }
    }

    public static void waitUntilElementIsHidden(By locator) {
        try {
            String timeout = properties.getProperty("waitingTime");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.valueOf(timeout)));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (ElementNotInteractableException e) {
            testBaseLogger.info("Failed. Due to : " + e.getLocalizedMessage() + "");
        } catch (TimeoutException e) {
            testBaseLogger.info("Failed. Due to : " + e.getLocalizedMessage() + "");
        }
    }

    public String[][] readExcelData(String excelFileName, String sheetName) {

        String[][] excelDataList = null;

        try {
            FileInputStream fileStream = new FileInputStream(excelFileName);
            Workbook workBook = Workbook.getWorkbook(fileStream);
            Sheet excelSheet = workBook.getSheet(sheetName);

            int totalNoOfCols = excelSheet.getColumns();
            int totalNoOfRows = excelSheet.getRows();

            excelDataList = new String[totalNoOfRows - 1][totalNoOfCols];

            for (int i = 1; i < totalNoOfRows; i++) {

                for (int j = 0; j < totalNoOfCols; j++) {
                    excelDataList[i - 1][j] = excelSheet.getCell(j, i).getContents();
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
        if (element.isEnabled()) {
            isEnabled = true;
            testBaseLogger.info("Element is enabled");
        } else {
            isEnabled = false;
            testBaseLogger.info("Element is disabled");
        }
        return isEnabled;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean isAlertPresent(String alertText) {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText().equalsIgnoreCase(alertText);
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean isPageLoaded(WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    public void mouseMove(WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public void mouseMoveWithOffsets(WebElement element, int offsetX, int offsetY) {
        Actions act = new Actions(driver);
        act.moveToElement(element, offsetX, offsetY).build().perform();
    }

    public void mouseMoveWithOffsetsAndClick(WebElement element, int offsetX, int offsetY) {
        Actions act = new Actions(driver);
        act.moveToElement(element, offsetX, offsetY).click().build().perform();
    }

    public void moveAndClick(WebElement targetElement) {
        Actions builder = new Actions(driver);
        builder.moveToElement(targetElement).click(targetElement).perform();
    }

    public static void javaScriptClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void actionClick(WebElement targetElement) {
        Actions builder = new Actions(driver);
    }

    public Dimension getWindowDimension() {
        return driver.manage().window().getSize();
    }

    public void waitFor(Integer millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e1) {
            Thread.currentThread().interrupt();
        }
    }

    public static void checkBoxJSSelect(WebElement element) {
        if (!element.isSelected()) {
            javaScriptClick(element);
        }
    }

    public static void checkBoxJSDisSelect(WebElement element) {
        if (element.isSelected()) {
            javaScriptClick(element);
        }
    }

    public static void scrollUntilElementView(WebElement element) {
        testBaseLogger.info("\n Scroll until visibility of element : " + element + "");
        Coordinates coordinate = ((Locatable) element).getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();
        testBaseLogger.info("Successfully scrolled");
    }

    public static void scrollUntilElementViewJS(WebElement element) {
        testBaseLogger.info("\n Scroll until visibility of element : " + element + "");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        testBaseLogger.info("Successfully scrolled");
    }

    public static void waitForElementVisibilityBy(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.valueOf(timeout)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            testBaseLogger.info("Element located at path --> " + locator + " and waiting for " + timeout + " seconds");
        } catch (NoSuchElementException e) {
            testBaseLogger.info("Failed Due to : " + e.getLocalizedMessage() + "");
        } catch (TimeoutException e) {
            testBaseLogger.info("Failed Due to : " + e.getLocalizedMessage() + "");
        }
    }


    public void switchToNewWindow() {
        String initialWindow = driver.getWindowHandle();
        for (String newWindow : driver.getWindowHandles()) {
            if (!initialWindow.equalsIgnoreCase(newWindow)) {
                testBaseLogger.info("Switch to new Window : " + newWindow);
                driver.switchTo().window(newWindow);
                break;
            }
        }
    }

    public String javaScriptGetText(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String text = (String) executor.executeScript("return arguments[0].value", element);
        if (!text.isEmpty())
            testBaseLogger.info("Retrieving text successful");
        else
            testBaseLogger.info("No text found on specific element " + element + "");
        return text;
    }

    public static void captureScreenshotOnFailure(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File("src/main/resources/screenshots/" + screenshotName + ".png"));
            testBaseLogger.info("Screenshot successfully taken");
        } catch (Exception e) {
            testBaseLogger.info("Failed Screenshot taking due to : " + e.getLocalizedMessage() + "");
        }
    }

    public static String getPropertyFileValue(String propertyKey) {

        String propertyValue = "";

        if(!propertyKey.isEmpty()) {
            readPropertyFile();
            propertyValue = properties.getProperty(propertyKey);

            if(propertyValue != null)
                testBaseLogger.info("Successfully retrieved Property value |" + propertyValue + "| for Property key |" + propertyKey + "|");
            else {
                System.out.println("Provided Property Key is either invalid or incorrect --> " + propertyKey);
                testBaseLogger.info("Error occured while trying to retrieve the Property value " + propertyKey);
            }

        } else
            System.out.println("Property Key is not provided");

        return propertyValue;
    }

    public static String readPDF(String pdfFilePath) throws IOException {
        File file = new File(pdfFilePath);
        FileInputStream inputFile = new FileInputStream(file);
        PDDocument documentObject = PDDocument.load(inputFile);
        PDFTextStripper objPDFStrip = new PDFTextStripper();
        return objPDFStrip.getText(documentObject);
    }

    public void writeActualValue(String key, String value) {
        testBaseLogger.info("Writing the actual value into the key: " + key + "");
        actualData.put(key, value);
    }

    public String readActualValue(String key) {
        testBaseLogger.info("Reading the actual value stored in the key: " + key + "");
        return actualData.get(key);
    }

    public String getNumericValue(String textValue) {
        testBaseLogger.info("Capturing only the numeric value of text: " + textValue + "");
        return textValue.replaceAll("[^0-9]", "");
    }

    public List<String[]> readCSV(String csvFileName, char separator) throws IOException, CsvException {

        List<String[]> csvData;
        CSVParser csvParser = new CSVParserBuilder().withSeparator(separator).build();
        try(CSVReader reader = new CSVReaderBuilder(new FileReader(csvFileName))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()){
            csvData = reader.readAll();
            csvData.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (IOException | CsvException e) {
            testBaseLogger.info("Error reading CSV File");
            e.printStackTrace();
            throw e;
        }
        return csvData;
    }
}
