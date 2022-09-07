package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.datatest.ConstantData;
import haimai.pages.CategoryPage;
import haimai.pages.CommonPage;
import haimai.pages.LoginCMSPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public CategoryPage categoryPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupCategoryTest() {
        loginCMSPage = new LoginCMSPage();
    }

    @Test
    public void addCategoryTest() {
        commonPage = loginCMSPage.logIn(ConstantData.EMAIL, ConstantData.PASSWORD);
        categoryPage = commonPage.openCategory();
        categoryPage.addCategory();
    }

}
