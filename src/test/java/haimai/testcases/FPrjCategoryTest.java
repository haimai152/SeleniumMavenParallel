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
    @Test(priority = 1, dataProvider = "dataExcelAddCategory", dataProviderClass = DataProviderManager.class)
    public void addCategoryExcel(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        fPrjCategoryPage = commonPage.openFPrjCategory();
        //  fPrjCategoryPage.addCategory(data.get("name"), data.get("parentCat"), data.get("orderingNumber"), data.get("type"), data.get("bannerFilePath"), data.get("iconFilePath"), data.get("metaTitle"), data.get("metaDescription"));
        fPrjCategoryPage.addCategory(data);
    }


}
