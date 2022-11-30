package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.dataproviders.DataProviderManager;
import haimai.pages.LoginCMSPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("this is Epic of final project")
@Feature("this is Feature of final project")
public class FPrjLoginCMSTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;

    @BeforeMethod
    public void loginCRMTest() {
        loginCMSPage = new LoginCMSPage();
    } //Truyền driver từ BaseTest sang các class Page

    //Final Project
    @Step("testLoginDataProviderFromExcelByRow")
    @Test(priority = 1, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
    public void testDataProviderLoginExcelByRowPrj(Hashtable<String, String> data) {
        loginCMSPage.verifyLogIn_prj(data.get("username"), data.get("password"), data.get("type"));
    }
}
