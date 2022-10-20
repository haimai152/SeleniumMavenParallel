package haimai.utils;

//import dev.failsafe.internal.util.Assert;

import com.aventstack.extentreports.Status;
import haimai.driver.DriverManagerMe;
import haimai.reports.AllureManager;
import haimai.reports.ExtentTestManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    private final static int TIMEOUT = 10;
    private final static double STEP_TIME = 0.5;

    private final static double PAGE_LOAD_TIMEOUT = 20;
    //   private static WebDriver driver;


    public static WebElement getWebElement(By by) {
        return DriverManagerMe.getDriver().findElement(by);
    }

    /*
       public static WebDriver setDriver(WebDriver driver){
           WebUI.driver = driver;
           return driver;
       }
     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManagerMe.getDriver(), Duration.ofSeconds((long) PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerMe.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            logConsole("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                //Assert.isTrue(jsReady, "Timeout waiting for page load (Javascript). (" + PAGE_LOAD_TIMEOUT + "s)");
                Assert.fail("Timeout waiting for page load (Javascript). (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }

    public static void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManagerMe.getDriver(), Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClickable(By by) {
        waitForPageLoaded();
        WebDriverWait wait = new WebDriverWait(DriverManagerMe.getDriver(), Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (200 * second));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    @Step("Open URL: {0}")
    public static void openURL(String url) {
        DriverManagerMe.getDriver().get(url);
        sleep(STEP_TIME);
        Log.info("Open: " + url);
        ExtentTestManager.logMessage(Status.PASS, "Open URL: " + url);

        AllureManager.saveTextLog("Open: " + url);
        waitForPageLoaded();
    }

    public static boolean verifyUrl(String url) {

        return DriverManagerMe.getDriver().getCurrentUrl().contains(url);
    }

    public static void scrollToElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerMe.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(element));
    }

    public static WebElement highLightElement(By by) {
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (DriverManagerMe.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManagerMe.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);
    }

    public static void clearElement(By by) {
        waitForPageLoaded();
        waitForElementClickable(by);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.elementToBeClickable(by));
        sleep(TIMEOUT);
        DriverManagerMe.getDriver().findElement(by).clear();
    }

    @Step("Click element: {0}")
    public static void clickElement(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(TIMEOUT);
        DriverManagerMe.getDriver().findElement(by).click();
        Log.info("Click element: " + by);
        ExtentTestManager.logMessage(Status.PASS, "Click element: " + by);
        AllureManager.saveTextLog("Click element: " + by);
    }

    @Step("Click element {0} with timeout {1}")
    public static void clickElement(By by, long timeout) {
        waitForPageLoaded();
        waitForElementVisible(by);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(TIMEOUT);
        DriverManagerMe.getDriver().findElement(by).click();
        Log.info("Clicked on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Clicked on element " + by);
    }

    @Step("Set text {1} on {0}")
    public static void setElementText(By by, String value) {
        waitForPageLoaded();
        waitForElementClickable(by);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(TIMEOUT);
        DriverManagerMe.getDriver().findElement(by).sendKeys(value);
        Log.info("Set text: " + value + "on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Set text: " + value + " on element " + by);
    }

    @Step("Get text of element {0}")
    public static String getElementText(By by) {
        waitForPageLoaded();
        waitForElementClickable(by);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        String text = DriverManagerMe.getDriver().findElement(by).getText();
        //  logConsole("Get text: " + text);
        Log.info("Get text: " + text);
        ExtentTestManager.logMessage(Status.PASS, "Get text: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    public static Boolean checkElementExist(By by) {
        sleep(2);
        List<WebElement> listElement = DriverManagerMe.getDriver().findElements(by);

        if (listElement.size() > 0) {
            System.out.println("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            System.out.println("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

    public static void sendKeyForElement(By by) {
        waitForPageLoaded();
        WebElement element = DriverManagerMe.getDriver().findElement(by);
        Actions action = new Actions(DriverManagerMe.getDriver());
        action.sendKeys(Keys.ENTER).build().perform();
    }

}
