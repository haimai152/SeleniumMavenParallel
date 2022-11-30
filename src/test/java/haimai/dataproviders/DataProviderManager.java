package haimai.dataproviders;

import haimai.helpers.ExcelHelpers;
import haimai.helpers.Helpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {
    @DataProvider(name = "data_provider_login", parallel = true)
    public Object[][] dataLoginCRM() {
        return new Object[][]{{"admin@example.com", "123456"}, {"haimai@example.com", "hai13"}};
    }

    @DataProvider(name = "data_provider_login_from_excel", parallel = true)
    public Object[][] dataLoginCRMFromExcel() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelData(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/logindata.xlsx", "Login");

        return data;
    }

    @DataProvider(name = "data_provider_login_from_excel_by_row", parallel = true)
    public Object[][] dataLoginCRMFromExcelByRow() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/logindata.xlsx", "Login", 1, 3);

        return data;
    }

    @DataProvider(name = "dataExcelAddBrand", parallel = false)
    public Object[][] addBrandData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "addBrand", 1, 3);

        return data;
    }

    @DataProvider(name = "dataExcelEditBrand", parallel = false)
    public Object[][] editBrandData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "editBrand", 1, 1);

        return data;
    }

    @DataProvider(name = "dataExcelDelBrand", parallel = false)
    public Object[][] delBrandData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "delBrand", 1, 1);

        return data;
    }
}
