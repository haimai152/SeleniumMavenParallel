package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.dataproviders.DataProviderManager;
import haimai.datatest.ConstantData;
import haimai.helpers.ExcelHelpers;
import haimai.helpers.PropertiesHelpers;
import haimai.pages.LoginCMSPage;
import haimai.utils.Log;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("this is Epic")
@Feature("this is Feature")
public class LoginCMSTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;

    @BeforeMethod
    public void loginCRMTest() {
        loginCMSPage = new LoginCMSPage();

    } //Truyền driver từ BaseTest sang các class Page

    @Test(priority = 1)
    public void inValidEmail() {
        loginCMSPage.verifyLogIn(PropertiesHelpers.getValue("email"), PropertiesHelpers.getValue("password"));
    } //Gọi file truyền data configs cho login

    @Test(priority = 2)
    public void inValidPassword() {
        loginCMSPage.verifyLogIn("admin@example.com", "123456789");
    }

    @Test(priority = 3)
    public void inValidEmailPassword() {
        loginCMSPage.verifyLogIn("abc@gmail.com", "123456789");
    }

    @Test(priority = 4)
    public void signIn_Valid() {
        loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
    }

    @Test(priority = 5)
    public void testLoginSuccessEXCEL() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile("src/test/java/haimai/datatest/logindata.xlsx", "Sheet1"); //Khai báo file và sheet

        System.out.println(excelHelpers.getLastRowNum());
        System.out.println(excelHelpers.getPhysicalNumberOfRows());
        // loginCMSPage.logIn(excelHelpers.getCellData("username", 1), excelHelpers.getCellData("password", 1));
        excelHelpers.setCellData("pass", 1, 2);
        excelHelpers.setCellData("fail", 2, 2);
    }

    @Test(priority = 6, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
    public void testDataProviderLogin(String username, String password) {
        loginCMSPage.verifyLogIn(username, password);
        Log.info(username + " - " + password);
//        Logger log = LogManager.getLogger(LoginCMSTest.class);
//        log.info(username + " - " + password);
    }

    @Step("testLoginFromDataProvider")
    @Test(priority = 7, dataProvider = "data_provider_login_from_excel", dataProviderClass = DataProviderManager.class)
    public void testDataProviderLoginExcel(String username, String password, String result) {
        loginCMSPage.verifyLogIn(username, password);
    }

    @Step("testLoginDataProviderFromExcelByRow")
    @Test(priority = 8, dataProvider = "data_provider_login_from_excel_by_row", dataProviderClass = DataProviderManager.class)
    public void testDataProviderLoginExcelByRow(Hashtable<String, String> data) {
        loginCMSPage.verifyLogIn(data.get("username"), data.get("password"));
    }
}
