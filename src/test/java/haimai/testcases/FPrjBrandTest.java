package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.dataproviders.DataProviderManager;
import haimai.datatest.ConstantData;
import haimai.pages.CommonPage;
import haimai.pages.FPrjBrandPage;
import haimai.pages.LoginCMSPage;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class FPrjBrandTest extends BaseTestParallel {
    public LoginCMSPage loginCMSPage;
    public FPrjBrandPage fPrjBrandPage;
    private CommonPage commonPage;

    @BeforeMethod
    public void setupBrandTest() {
        loginCMSPage = new LoginCMSPage();
    } //Truyền driver từ BaseTest sang các class Page

    //Final Project
    @Step("dataProviderAddBrand")
    @Test(priority = 1, dataProvider = "dataExcelAddBrand", dataProviderClass = DataProviderManager.class)
    public void addBrandExcel(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        fPrjBrandPage = commonPage.openBrand();
        fPrjBrandPage.addBrandData(data.get("name"), data.get("fileLogo"), data.get("logoName"), data.get("metaTitle"), data.get("metaDescription"));
    }

    @Step("dataProviderEditBrand")
    @Test(priority = 2, dataProvider = "dataExcelEditBrand", dataProviderClass = DataProviderManager.class)
    public void editBrandExcel(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        fPrjBrandPage = commonPage.openBrand();
        fPrjBrandPage.searchBrand(data.get("oldName"));
        fPrjBrandPage.editBrandData(data.get("oldName"), data.get("nameEdit"), data.get("fileLogo"), data.get("logoName"), data.get("metaTitle"), data.get("metaDescription"));
    }

    @Step("dataProviderDelBrand")
    @Test(priority = 3, dataProvider = "dataExcelDelBrand", dataProviderClass = DataProviderManager.class)
    public void delBrandExcel(Hashtable<String, String> data) {
        commonPage = loginCMSPage.verifyLogIn_prj(ConstantData.EMAIL, ConstantData.PASSWORD, ConstantData.TYPE);
        fPrjBrandPage = commonPage.openBrand();
        fPrjBrandPage.searchBrand(data.get("name"));
        fPrjBrandPage.delBrandData();
    }
}
