package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.dataproviders.DataProviderManager;
import haimai.datatest.ConstantData;
import haimai.pages.CommonPage;
import haimai.pages.FPrjCheckAddedProOnUserPage;
import haimai.pages.FPrjProductPage;
import haimai.pages.LoginCMSPage;
import haimai.utils.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class FPrjCheckAddedProOnUserTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public FPrjProductPage fPrjProductPage;
    public CommonPage commonPage;
    public FPrjCheckAddedProOnUserPage fPrjCheckAddedProOnUserPage;

    @BeforeMethod
    public void setupCheckProductTest() {
        loginCMSPage = new LoginCMSPage();
    }

    @Step("dataProviderCheckProduct")
    @Test(priority = 1, dataProvider = "addProduct", dataProviderClass = DataProviderManager.class)
    public void checkProduct(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        fPrjProductPage = commonPage.openFPrjProduct();
        fPrjProductPage.fPrjAddProduct(data);
        fPrjCheckAddedProOnUserPage=fPrjProductPage.openUserPage();
        fPrjCheckAddedProOnUserPage.checkAddedProduct(data.get("productName"));
        fPrjCheckAddedProOnUserPage.checkDetailProduct(data);
    }

}
