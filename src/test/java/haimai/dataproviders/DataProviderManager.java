package haimai.dataproviders;

import haimai.helpers.ExcelHelpers;
import haimai.helpers.Helpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {

    @DataProvider(name = "addBrand", parallel = false)
    public Object[][] addBrandData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "addBrand", 1, 1);

        return data;
    }

    @DataProvider(name = "editBrand", parallel = false)
    public Object[][] editBrandData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "editBrand", 1, 1);

        return data;
    }

    @DataProvider(name = "delBrand", parallel = false)
    public Object[][] delBrandData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "delBrand", 1, 1);

        return data;
    }

    @DataProvider(name = "addCategory", parallel = false)
    public Object[][] addCategoryData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "addCategory", 1, 1);

        return data;
    }

    @DataProvider(name = "addProduct", parallel = false)
    public Object[][] addProductData() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dataTestProject.xlsx", "addProduct", 1, 1);

        return data;
    }
}
