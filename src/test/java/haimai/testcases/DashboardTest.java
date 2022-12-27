package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.datatest.ConstantData;
import haimai.pages.CommonPage;
import haimai.pages.DashboardPage;
import haimai.pages.LoginCMSPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public DashboardPage dashboardPage;
    public CommonPage commonPage;

    @BeforeMethod
    public void setupDashboardTest() {
        loginCMSPage = new LoginCMSPage();

    }

    @Test
    public void testLogout() {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD,ConstantData.TYPE);
        commonPage.logout();
    }
}
