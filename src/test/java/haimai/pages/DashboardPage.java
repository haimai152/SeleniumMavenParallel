package haimai.pages;

import haimai.utils.WebUI;
import org.openqa.selenium.By;

public class DashboardPage extends CommonPage {


    public DashboardPage() {

    }

    //    private By productMenuItem = By.xpath("//span[normalize-space()='Products']");
//    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
//    private By categoryMenuItem = By.xpath("//span[normalize-space()='Category']");
    private By logoutProfile = By.xpath("//span[@class='d-block fw-500']");
    private By logoutButton = By.xpath("//span[normalize-space()='Logout']");
    private By allProduct = By.xpath("//span[normalize-space()='All products']");

    //    public void get_driver(){
//        System.out.println("đây là driver: "+this.driver);
//    }
//    public ProductPage openProduct() {
//        WebUI.waitForElementClickable(productMenuItem);
//        WebUI.clickElement(productMenuItem);
//
//        WebUI.waitForElementClickable(addNewProduct);
//        WebUI.clickElement(addNewProduct);
//
//        return new ProductPage(driver);
//    }
//
//    public ProductPage openAllProduct() {
//        WebUI.waitForElementClickable(productMenuItem);
//        WebUI.clickElement(productMenuItem);
//        WebUI.waitForElementClickable(allProduct);
//        WebUI.clickElement(allProduct);
//
//        return new ProductPage(driver);
//    }
//
//    public CategoryPage openCategory() {
//        WebUI.waitForElementClickable(productMenuItem);
//        WebUI.clickElement(productMenuItem);
//
//        WebUI.waitForElementClickable(categoryMenuItem);
//        WebUI.clickElement(categoryMenuItem);
//
//        return new CategoryPage(driver);
//    }

    public LoginCMSPage logout() {
        WebUI.clickElement(logoutProfile);
        WebUI.clickElement(logoutButton);
        return new LoginCMSPage();
    }
}