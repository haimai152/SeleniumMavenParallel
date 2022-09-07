package haimai.pages;

import haimai.utils.WebUI;
import org.openqa.selenium.By;

public class CommonPage {
    //  private WebDriver driver;

    public CommonPage() {

    }

    private LoginCMSPage logInCMSPage;
    private DashboardPage dashboardPage;
    private CategoryPage categoryPage;
    private ProductPage productPage;

    private By productMenuItem = By.xpath("//span[normalize-space()='Products']");
    private By addNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By categoryMenuItem = By.xpath("//span[normalize-space()='Category']");

    private By logoutProfile = By.xpath("//span[@class='d-block fw-500']");
    private By logoutButton = By.xpath("//span[normalize-space()='Logout']");
    private By allProduct = By.xpath("//span[normalize-space()='All products']");

    public LoginCMSPage getSignInCMSPage() {
        if (logInCMSPage == null) {
            logInCMSPage = new LoginCMSPage();
        }
        return logInCMSPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public void clickProductMenu() {
        WebUI.waitForElementClickable(productMenuItem);
        WebUI.clickElement(productMenuItem);
    }

    public ProductPage clickAddProductMenu() {
        clickProductMenu();
        WebUI.waitForElementClickable(addNewProduct);
        WebUI.clickElement(addNewProduct);
        return new ProductPage(driver);
    }

    public ProductPage clickAllProductMenu() {
        clickProductMenu();
        WebUI.waitForElementClickable(allProduct);
        WebUI.clickElement(allProduct);
        return new ProductPage(driver);
    }

    public CategoryPage openCategory() {
        clickProductMenu();
        WebUI.waitForElementClickable(categoryMenuItem);
        WebUI.clickElement(categoryMenuItem);
        return new CategoryPage(driver);
    }

    public LoginCMSPage logout() {
        WebUI.clickElement(logoutProfile);
        WebUI.clickElement(logoutButton);
        return new LoginCMSPage();
    }
}
