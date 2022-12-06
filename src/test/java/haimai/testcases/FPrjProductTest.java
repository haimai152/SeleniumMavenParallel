package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.dataproviders.DataProviderManager;
import haimai.datatest.ConstantData;
import haimai.pages.CommonPage;
import haimai.pages.FPrjProductPage;
import haimai.pages.LoginCMSPage;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class FPrjProductTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public FPrjProductPage fPrjProductPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupCategoryTest() {
        loginCMSPage = new LoginCMSPage();
    }

    @Step("dataProviderAddProduct")
    @Test(priority = 1, dataProvider = "dataExcelAddProduct", dataProviderClass = DataProviderManager.class)
    public void addProductExcel(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        fPrjProductPage = commonPage.openFPrjProduct();
        fPrjProductPage.fPrjAddProduct(data);
    }
}
