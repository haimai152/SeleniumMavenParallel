package haimai.pages;

import haimai.helpers.ExcelHelpers;
import haimai.helpers.PropertiesHelpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Hashtable;
import java.util.List;

public class CheckSearchProTablePage extends CommonPage {
    ExcelHelpers excelHelpers;
    public CheckSearchProTablePage() {
        excelHelpers = new ExcelHelpers();
    }
    private By searchProElement = By.xpath("//input[@id='search']");
    public void checkSearchTableByColumn(int column, String value) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        //Xác định số dòng của table sau khi search
        List<WebElement> row = WebUI.getWebElements(By.xpath("//table[@class='table aiz-table mb-0 footable footable-1 breakpoint breakpoint-lg']//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Total rows: " + rowTotal);
        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = WebUI.getWebElement(By.xpath("//table[@class='table aiz-table mb-0 footable footable-1 breakpoint breakpoint-lg']//tbody/tr[" + i + "]/td[" + column + "]"));
            WebUI.scrollToElement(elementCheck);
            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertEquals(elementCheck.getText(), value, "Row " + i + " does not contain the searching value.");
        }
    }
    public void checkPageOnSearchProTable(Hashtable<String, String> dataProduct){
        String searchValue = dataProduct.get("productName");
        WebUI.waitForElementVisible(searchProElement);
        WebUI.clickElement(searchProElement);
        WebUI.setElementText(searchProElement, searchValue);
        WebUI.pressENTER();
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);

        List<WebElement> row = WebUI.getWebElements(By.xpath("//li[contains(@class,'page-item')]"));
        int pageTotal = row.size()-2; //Lấy ra số page
        System.out.println("Total Pages: " + pageTotal);
        for (int i = 1; i <= pageTotal; i++) {
            checkSearchTableByColumn(2, searchValue);
            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[contains(text(),'›')]"));
            }
        }
    }
}
