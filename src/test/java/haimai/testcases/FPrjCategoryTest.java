package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.dataproviders.DataProviderManager;
import haimai.datatest.ConstantData;
import haimai.pages.CommonPage;
import haimai.pages.FPrjCategoryPage;
import haimai.pages.LoginCMSPage;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class FPrjCategoryTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public FPrjCategoryPage fPrjCategoryPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupCategoryTest() {
        loginCMSPage = new LoginCMSPage();
    }

    @Step("dataProviderAddCategory")
    @Test(priority = 1, dataProvider = "addCategory", dataProviderClass = DataProviderManager.class)
    public void addCategory(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        fPrjCategoryPage = commonPage.openFPrjCategory();
        fPrjCategoryPage.addCategoryPage(data);
    }


}
