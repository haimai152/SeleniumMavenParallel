package haimai.driver;

import org.openqa.selenium.WebDriver;

public class DriverManagerMe {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManagerMe() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManagerMe.driver.set(driver);
    }

    public static void quit() {
        DriverManagerMe.driver.get().quit();
        driver.remove();
    }

}
