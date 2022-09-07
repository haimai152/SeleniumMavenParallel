package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.datatest.ConstantData;
import haimai.pages.CommonPage;
import haimai.pages.LoginCMSPage;
import haimai.pages.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public ProductPage productPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupProductTest() {
        loginCMSPage = new LoginCMSPage();
    }

    @Test
    public void addProductTest() {
        commonPage = loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        productPage = commonPage.clickAddProductMenu();
        productPage.addProduct();
    }

    @Test
    public void editProductTest() {
        commonPage = loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        productPage = commonPage.clickAllProductMenu();
        productPage.editProduct();
    }
}
