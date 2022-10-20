package haimai.common;

import haimai.driver.DriverManagerMe;
import haimai.helpers.PropertiesHelpers;
import haimai.listeners.TestListener;
import haimai.pages.CommonPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTestParallel extends CommonPage {
    public BaseTestParallel() {
        PropertiesHelpers.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browserName) {
        WebDriver driver = setupBrowser(browserName);
        DriverManagerMe.setDriver(driver);
        //  new WebUI(driver);


    }

    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver() {
        //  WebDriver driver = null;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (DriverManagerMe.getDriver() != null) {
            DriverManagerMe.quit();
        }
    }

}