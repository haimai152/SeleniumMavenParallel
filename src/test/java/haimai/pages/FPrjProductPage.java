package haimai.pages;

import haimai.helpers.ExcelHelpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Hashtable;

public class FPrjProductPage extends CommonPage {
    ExcelHelpers excelHelpers;
    FPrjCheckAddedProOnUserPage fPrjCheckAddedProOnUserPage;
    public FPrjProductPage() {
        excelHelpers = new ExcelHelpers();
    }

    private By addNewProduct = By.xpath("//span[normalize-space()='Add New product']");
    private By productName = By.xpath("//input[@placeholder='Product Name']");

    private By categorySearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By brandClick = By.xpath("//div[contains(text(),'Select Brand')]");
    private By brandSearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By unit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By qtyNumberClear = By.xpath("//input[@name='min_qty']");
    private By qtyNumberEnter = By.xpath("//input[@name='min_qty']");
    private By tagsName = By.xpath("//span[@role='textbox']");
    private By unitPriceClear = By.xpath("//input[@placeholder='Unit price']");
    private By unitPriceInput = By.xpath("//input[@placeholder='Unit price']");
    private By discountClear = By.xpath("//input[@placeholder='Discount']");
    private By discountInput = By.xpath("//input[@placeholder='Discount']");
    private By discountType = By.xpath("//div[@class='col-md-3']//div[@class='filter-option-inner-inner'][normalize-space()='Flat']");
    private By discountPercent = By.xpath("//span[normalize-space()='Percent']");
    private By discountFlat = By.xpath("//span[normalize-space()='Flat']");
    private By quantity = By.xpath("//input[@placeholder='Quantity']");
    private By saveButton = By.xpath("//button[normalize-space()='Save & Publish']");
    private By searchProduct = By.xpath("//input[@id='search']");
    private By logoutProfile = By.xpath("//span[@class='d-block fw-500']");
    private By logoutButton = By.xpath("//span[normalize-space()='Logout']");

    public void fPrjAddProduct(Hashtable<String, String> dataProduct) {
       // clickAddProduct();
        fPrjEnterProductData(dataProduct);
    }

    public void clickAddProduct() {
        WebUI.waitForElementClickable(addNewProduct);
        WebUI.clickElement(addNewProduct);

    }

    public void fPrjEnterProductData(Hashtable<String, String> dataPage) {
        WebUI.setElementText(productName, dataPage.get("productName"));
        By categoryClick = By.xpath("//button[@data-id='category_id']");
        WebUI.clickElement(categoryClick);
        WebUI.setElementText(categorySearch, dataPage.get("catName"));
        By categorySelected = By.xpath("//span[normalize-space()='" + dataPage.get("catName") + "']");
        WebUI.clickElement(categorySelected);
//        WebUI.setElementText(categorySearch, "Demo category 1");
//        By categorySelected = By.xpath("//span[normalize-space()='Demo category 1']");


        WebUI.clickElement(brandClick);
        WebUI.setElementText(brandSearch, dataPage.get("brandName"));
        By brandSelected = By.xpath("//span[normalize-space()='" + dataPage.get("brandName") + "']");
        WebUI.clickElement(brandSelected);
        WebUI.clickElement(unit);
        WebUI.setElementText(unit, dataPage.get("unit"));
        WebUI.clearElement(qtyNumberClear);
        WebUI.setElementText(qtyNumberEnter, dataPage.get("minPurchaseQty"));
        WebUI.setElementText(tagsName, dataPage.get("tag"));
        WebUI.clearElement(unitPriceClear);
        WebUI.setElementText(unitPriceInput, dataPage.get("unitPrice"));
        WebUI.clearElement(discountClear);
        WebUI.setElementText(discountInput, dataPage.get("discount"));

        WebUI.clickElement(discountType);
        if (dataPage.get("discountType").equals("Percent")) {
            WebUI.clickElement(discountPercent);
        } else {
            WebUI.clickElement(discountFlat);
        }

        WebUI.clearElement(quantity);
        WebUI.setElementText(quantity, dataPage.get("quantity"));
        WebUI.clickElement(saveButton);
        WebUI.sleep(5);

        WebUI.waitForElementClickable(searchProduct);
        WebUI.setElementText(searchProduct, dataPage.get("productName"));
        WebUI.pressENTER();
        By productNameElement = By.xpath(" //td[normalize-space()='" + dataPage.get("productName") + "']");
        boolean checkProductName = WebUI.checkElementExist(productNameElement);
        Assert.assertTrue(checkProductName, "Fail to add/edit Product");
    }

    public FPrjCheckAddedProOnUserPage openUserPage() {
        WebUI.clickElement(logoutProfile);
        WebUI.clickElement(logoutButton);
        WebUI.openURL("https://cms.anhtester.com/");
        WebUI.waitForPageLoaded();
        //  WebUI.sleep(3);
        return new FPrjCheckAddedProOnUserPage();
    }
}
