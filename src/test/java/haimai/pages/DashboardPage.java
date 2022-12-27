package haimai.pages;

import haimai.utils.WebUI;
import org.openqa.selenium.By;

public class DashboardPage extends CommonPage {


    public DashboardPage() {

    }

    private By logoutProfile = By.xpath("//span[@class='d-block fw-500']");
    private By logoutButton = By.xpath("//span[normalize-space()='Logout']");
    private By allProduct = By.xpath("//span[normalize-space()='All products']");

    public LoginCMSPage logout() {
        WebUI.clickElement(logoutProfile);
        WebUI.clickElement(logoutButton);
        return new LoginCMSPage();
    }
}