package haimai.pages;

import haimai.utils.WebUI;
import org.openqa.selenium.By;

public class CommonPage {
    //  private WebDriver driver;

    public CommonPage() {

    }


    private FPrjCategoryPage fPrjCategoryPage;
    private FPrjProductPage fPrjProductPage;


    private By productMenuItem = By.xpath("//span[normalize-space()='Products']");
    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By categoryMenuItem = By.xpath("//span[normalize-space()='Category']");

    private By brandMenuItem = By.xpath("//span[normalize-space()='Brand']");

    private By logoutProfile = By.xpath("//span[@class='d-block fw-500']");
    private By logoutButton = By.xpath("//span[normalize-space()='Logout']");
    private By allProduct = By.xpath("//span[normalize-space()='All products']");


    public void clickProductMenu() {
        WebUI.waitForElementClickable(productMenuItem);
        WebUI.clickElement(productMenuItem);
    }

    public FPrjProductPage openFPrjProduct() {
        clickProductMenu();
        WebUI.waitForElementClickable(addNewProduct);
        WebUI.waitForElementVisible(addNewProduct);
        WebUI.clickElement(addNewProduct);
        return new FPrjProductPage();
    }


    public FPrjCategoryPage openFPrjCategory() {
        clickProductMenu();
        WebUI.waitForElementClickable(categoryMenuItem);
        WebUI.clickElement(categoryMenuItem);
        return new FPrjCategoryPage();
    }

    public FPrjBrandPage openBrand() {
        clickProductMenu();
        WebUI.waitForElementClickable(brandMenuItem);
        WebUI.clickElement(brandMenuItem);
        return new FPrjBrandPage();
    }

//    public FPrjCheckAddedProOnUserPage openUserPage() {
//        WebUI.clickElement(logoutProfile);
//        WebUI.clickElement(logoutButton);
//        WebUI.openURL("https://cms.anhtester.com/");
//
//        return new FPrjCheckAddedProOnUserPage();
//    }
    public LoginCMSPage logout() {
        WebUI.clickElement(logoutProfile);
        WebUI.clickElement(logoutButton);
        return new LoginCMSPage();
    }
}
