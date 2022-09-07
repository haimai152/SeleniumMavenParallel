package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.datatest.ConstantData;
import haimai.pages.LoginCMSPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginCMSTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;

    @BeforeMethod
    public void loginCRMTest() {
        loginCMSPage = new LoginCMSPage();

    } //Truyền driver từ BaseTest sang các class Page

    @Test(priority = 1)
    public void inValidEmail() {
        loginCMSPage.verifyLogIn("abc@gmail.com", "123456");
    }

//    @Test(priority = 2)
//    public void inValidPassword() {
//        loginCMSPage.verifyLogIn("maihaitdc@gmail.com", "123456789");
//    }
//
//    @Test(priority = 3)
//    public void inValidEmailPassword() {
//        loginCMSPage.verifyLogIn("abc@gmail.com", "123456789");
//    }

    @Test(priority = 2)
    public void signIn_Valid() {
        loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
    }


}
