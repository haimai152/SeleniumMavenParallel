package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.driver.DriverManagerMe;
import haimai.helpers.CaptureHelpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TakeScreenShot extends BaseTestParallel {

    @BeforeClass
    public void setUpClass() {
        CaptureHelpers.startRecord("TakeScreenShot");
    }

//    @Test(priority = 1, dataProvider = "data_provider_login", dataProviderClass = DataProviderManager.class)
//    public void testLoginFromDataProvider(String username, String password) {
//        getLoginPage().logIn(username, password);
//        dangXuat();
//    }

    @Test(priority = 2)
    public void homePage() throws Exception {
        WebUI.openURL("https://anhtester.com");
        //step này cố tình Fail để chụp màn hình lại
        Assert.assertEquals(DriverManagerMe.getDriver().getTitle(), "Anh Tester - Automation Testing");
    }

    @Test(priority = 3)
    public void loginPage() throws Exception {
        WebUI.openURL("https://anhtester.com");
        WebUI.clickElement(By.id("btn-login"));
        Assert.assertEquals(DriverManagerMe.getDriver().getTitle(), "Selenium");
    }

    @AfterClass
    public void afterClass() {
        CaptureHelpers.stopRecord();
    }

}
