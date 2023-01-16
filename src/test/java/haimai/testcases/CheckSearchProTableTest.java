package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.dataproviders.DataProviderManager;
import haimai.datatest.ConstantData;
import haimai.helpers.PropertiesHelpers;
import haimai.pages.CheckSearchProTablePage;
import haimai.pages.CommonPage;
import haimai.pages.FPrjProductPage;
import haimai.pages.LoginCMSPage;
import haimai.utils.WebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;

public class CheckSearchProTableTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public CommonPage commonPage;
    public CheckSearchProTablePage checkSearchProTablePage;

    @BeforeMethod
    public void setupProductTest() {
        loginCMSPage = new LoginCMSPage();
    }

    @Step("searchProductTable")
    @Test(priority = 1, dataProvider = "addProduct", dataProviderClass = DataProviderManager.class)
    public void searchProOnTable(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        checkSearchProTablePage = commonPage.openProForSearchTable();
        checkSearchProTablePage.checkPageOnSearchProTable(data);
    }
}
