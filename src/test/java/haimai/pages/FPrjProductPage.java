package haimai.pages;

import haimai.helpers.ExcelHelpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;

import java.util.Hashtable;

public class FPrjProductPage extends CommonPage {
    ExcelHelpers excelHelpers;

    public FPrjProductPage() {
        excelHelpers = new ExcelHelpers();
    }

    private By addNewProduct = By.xpath("//span[normalize-space()='Add New product']");
    private By productName = By.xpath("//input[@placeholder='Product Name']");
    private By categoryClick = By.xpath("//div[contains(text(),'Women Clothing & Fashion')]");
    private By categorySearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By brandClick = By.xpath("//div[contains(text(),'Select Brand')]");
    private By brandSearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By qtyNumberClear = By.xpath("//input[@name='min_qty']");
    private By qtyNumberEnter = By.xpath("//input[@name='min_qty']");
    private By tagsName = By.xpath("//span[@role='textbox']");
    private By unitPriceClear = By.xpath("//input[@placeholder='Unit price']");
    private By unitPriceInput = By.xpath("//input[@placeholder='Unit price']");
    private By discountClear = By.xpath("//input[@placeholder='Discount']");
    private By discountInput = By.xpath("//input[@placeholder='Discount']");
    private By quantity = By.xpath("//input[@placeholder='Quantity']");
    private By saveButton = By.xpath("//button[normalize-space()='Save & Publish']");

    public void fPrjAddProduct(Hashtable<String, String> dataProduct) {
        clickAddProduct();
        fPrjEnterProductData(dataProduct);
    }

    public void clickAddProduct() {
        WebUI.waitForElementClickable(addNewProduct);
        WebUI.clickElement(addNewProduct);

    }

    public void fPrjEnterProductData(Hashtable<String, String> dataPage) {
        WebUI.setElementText(productName, dataPage.get("productName"));
        WebUI.clickElement(categoryClick);
        WebUI.setElementText(categorySearch, dataPage.get("catName"));
        By categorySelected = By.xpath("//span[normalize-space()='-- " + dataPage.get("catName") + "']");
        WebUI.clickElement(categorySelected);

        WebUI.clickElement(brandClick);
        WebUI.setElementText(brandSearch, dataPage.get("brandName"));
        By brandSelected = By.xpath("//span[normalize-space()='" + dataPage.get("brandName") + "']");
        WebUI.clickElement(brandSelected);
        WebUI.clearElement(qtyNumberClear);
        WebUI.setElementText(qtyNumberEnter, dataPage.get("minPurchaseQty"));
        WebUI.setElementText(tagsName, dataPage.get("tag"));
        WebUI.clearElement(unitPriceClear);
        WebUI.setElementText(unitPriceInput, dataPage.get("unitPrice"));
        WebUI.clearElement(discountClear);
        WebUI.setElementText(discountInput, dataPage.get("discount"));
        WebUI.setElementText(quantity, dataPage.get("quantity"));
        WebUI.clickElement(saveButton);
    }

}
