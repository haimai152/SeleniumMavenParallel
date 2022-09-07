package haimai.pages;

import haimai.datatest.ProductData;
import haimai.utils.WebUI;
import org.openqa.selenium.By;

public class ProductPage extends CommonPage {


    public ProductPage() {

    }

    private String categoryName = "Computer & Accessories";
    private String videoProvider = "Youtube";
    private String color = "DarkRed";
    private String attributes = "Fabric";
    private String fabric = "Cotton";
    private String flash = "Electronic";
    private String discountType = "Percent";
    private By productName = By.xpath("//input[@placeholder='Product Name']");
    private By categoryClick = By.xpath("//div[contains(text(),'" + categoryName + "')]");
    private By categorySelect = By.xpath("//span[normalize-space()='" + categoryName + "']");
    private By brandClick = By.xpath("//div[contains(text(),'Select Brand')]");
    private By brandSearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By brandSelect = By.xpath("//a[@id='bs-select-2-3']");
    private By unit = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By qtyNumberClear = By.xpath("//input[@name='min_qty']");
    private By qtyNumberEnter = By.xpath("//input[@name='min_qty']");
    private By tagsName = By.xpath("//span[@role='textbox']");
    private By flatRateRadiobutton = By.xpath("//label[normalize-space()='Flat Rate']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']");
    private By shippingCostInput = By.xpath("//input[@placeholder='Shipping cost']");
    private By shippingCostClear = By.xpath("//input[@placeholder='Shipping cost']");
    private By productQuantityRadioButton = By.xpath("//label[normalize-space()='Is Product Quantity Mulitiply']/following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']");
    private By lowStockClear = By.xpath("//input[@name='low_stock_quantity']");
    private By lowStockInput = By.xpath("//input[@name='low_stock_quantity']");
    private By galleryImagesClick = By.xpath("//div[@data-multiple='true']");
    private By galleryImagesFileName = By.xpath("//input[@placeholder='Search your files']");
    private By galleryImagesSelect = By.xpath("//div[@id='aiz-select-file']//div[1]//div[1]//div[1]//div[1]//img[1]");
    private By galleryImages = By.xpath("//button[normalize-space()='Add Files']");
    private By thumbnailImagesClick = By.xpath("(//div[contains(text(),'Browse')])[2]");
    private By thumbnailImagesFileName = By.xpath("//input[@placeholder='Search your files']");
    private By thumbnailImagesSelect = By.xpath("(//div[@title='lake.jpg'])[1]");
    private By thumbnailImages = By.xpath("//button[normalize-space()='Add Files']");
    private By showStockRadioButton = By.xpath("//label[normalize-space()='Show Stock With Text Only']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']");
    private By hideStockRadioButton = By.xpath("//label[normalize-space()='Hide Stock']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']");
    private By videoProviderClick = By.xpath("//div[contains(text(),'" + videoProvider + "')]");

    private By getVideoProviderSelect = By.xpath("//a[@id='bs-select-3-0']");
    private By videoLink = By.xpath("//input[@placeholder='Video Link']");
    private By featuredStatusRadioButton = By.xpath("//label[normalize-space()='Status']//following-sibling::div//label[@class='aiz-switch aiz-switch-success mb-0']");
    private By colorClick = By.xpath("//div[@class='col-md-1']");
    private By colorButtonClick = By.xpath("//button[@data-id='colors']");
    private By colorSearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By colorSelect = By.xpath("//span[contains(text(),'" + color + "')]");

    private By attributesClick = By.xpath("//button[@title='Nothing selected']//div[@class='filter-option-inner']");
    private By attributesSearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By attributesSelect = By.xpath("//span[normalize-space()='" + attributes + "']");

    private By fabricClick = By.xpath("//div[contains(text(),'Nothing selected')]");
    private By fabricSearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By fabricSelect = By.xpath("//span[normalize-space()='" + fabric + "']");

    private By flashClick = By.xpath("//div[contains(text(),'Choose Flash Title')]");
    private By flashSelect = By.xpath("//span[normalize-space()='" + flash + "']");

    private By flashDiscountClear = By.xpath("//input[@name='flash_discount']");
    private By flashDiscountInput = By.xpath("//input[@name='flash_discount']");
    private By discountTypeClick = By.xpath("//div[contains(text(),'Choose Discount Type')]");
    private By discountTypeSelect = By.xpath("//a[@id='bs-select-8-2']//span[@class='text'][normalize-space()='" + discountType + "']");

    private By shippingDays = By.xpath("//input[@placeholder='Shipping Days']");
    private By taxClear = By.xpath("//input[@placeholder='Tax']");
    private By taxInput = By.xpath("//input[@placeholder='Tax']");
    private By taxTypeClick = By.xpath("//div[@class='form-group col-md-6']//button[@title='Flat']");
    private By taxTypeSelect = By.xpath("//a[@id='bs-select-9-1']//span[@class='text'][normalize-space()='" + discountType + "']");
    private By unitPriceClear = By.xpath("//input[@placeholder='Unit price']");
    private By unitPriceInput = By.xpath("//input[@placeholder='Unit price']");
    private By dateClick = By.xpath("//input[@placeholder='Select Date']");
    private By dateFromClick = By.xpath("//div[@class='drp-calendar left']//td[@data-title='r4c4']");
    private By dateToClick = By.xpath("//div[@class='drp-calendar right']//td[@data-title='r1c3']");
    private By dateSelect = By.xpath("//button[@class='applyBtn btn btn-sm btn-primary']");
    private By discountClear = By.xpath("//input[@placeholder='Discount']");
    private By discountInput = By.xpath("//input[@placeholder='Discount']");
    private By discountStyleClick = By.xpath("//div[@class='col-md-3']//div[@class='filter-option-inner-inner'][normalize-space()='Flat']");
    private By discountStyleSelect = By.xpath("//span[normalize-space()='" + discountType + "']");
    private By externallink = By.xpath("//input[@placeholder='External link']");
    private By externallinkText = By.xpath("//input[@placeholder='External link button text']");
    private By descriptionInput = By.xpath("//div[@role='textbox']");
    private By pdfFileClick = By.xpath("//div[@data-type='document']//div[@class='form-control file-amount'][normalize-space()='Choose File']");
    private By pdfFileSearch = By.xpath("//input[@placeholder='Search your files']");
    private By pdfFileSelect = By.xpath("//i[@class='la la-file-text']");
    private By pdfFileAdd = By.xpath("//button[normalize-space()='Add Files']");
    private By metaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By metaDescription = By.xpath("//textarea[@name='meta_description']");
    private By metaImageClick = By.xpath("//label[normalize-space()='Meta Image']//following-sibling::div//div[@class='input-group-prepend']//div[normalize-space()='Browse']");
    private By metaImageSearch = By.xpath("//input[@placeholder='Search your files']");
    private By metaImageSelect = By.xpath("//div[@class='aiz-uploader-all clearfix c-scrollbar-light']//div[1]//div[1]//div[1]//div[1]");
    private By metaImageAdd = By.xpath("//button[normalize-space()='Add Files']");
    private By savebutton = By.xpath("//button[normalize-space()='Save & Publish']");

    private By searchProduct = By.xpath("//input[@id='search']");
    private By editProductIcon = By.xpath("//tbody/tr[1]/td[9]/a[2]/i[1]");
    private By updateProductButton = By.xpath("//button[normalize-space()='Update Product']");


    public void addProduct() {
        enterProductData();
    }

    public void editProduct() {
        editDataProduct();
    }

    public void editDataProduct() {
        WebUI.waitForElementClickable(searchProduct);
        WebUI.setElementText(searchProduct, ProductData.PRODUCTNAME);
        WebUI.sendKeyForElement(searchProduct);
        WebUI.waitForElementClickable(editProductIcon);
        WebUI.clickElement(editProductIcon);
        WebUI.clearElement(productName);
        WebUI.setElementText(productName, "ABC_Updated");
        WebUI.clearElement(unit);
        WebUI.setElementText(unit, "Unit_Updated");
        WebUI.clearElement(qtyNumberClear);
        WebUI.setElementText(qtyNumberEnter, "555");
        WebUI.clickElement(updateProductButton);
    }

    public void enterProductData() {
        WebUI.setElementText(productName, ProductData.PRODUCTNAME);
        WebUI.clickElement(categoryClick);
        WebUI.clickElement(categorySelect);
        WebUI.clickElement(brandClick);
        WebUI.setElementText(brandSearch, "HP");
        WebUI.clickElement(brandSelect);
        WebUI.setElementText(unit, "Pc");
        WebUI.clearElement(qtyNumberClear);
        WebUI.setElementText(qtyNumberEnter, "100");
        WebUI.setElementText(tagsName, "Hai");
        WebUI.clickElement(flatRateRadiobutton);
        WebUI.clearElement(shippingCostClear);
        WebUI.setElementText(shippingCostInput, "$60");
        WebUI.clickElement(productQuantityRadioButton);
        WebUI.clearElement(lowStockClear);
        WebUI.setElementText(lowStockInput, "200");
        WebUI.clickElement(galleryImagesClick);
        WebUI.setElementText(galleryImagesFileName, "dautay_resized");
        WebUI.clickElement(galleryImagesSelect);
        WebUI.clickElement(galleryImages);
        WebUI.clickElement(thumbnailImagesClick);
        WebUI.setElementText(thumbnailImagesFileName, "lake");
        WebUI.clickElement(thumbnailImagesSelect);
        WebUI.clickElement(thumbnailImages);
        WebUI.clickElement(showStockRadioButton);
        WebUI.clickElement(hideStockRadioButton);
        WebUI.clickElement(videoProviderClick);
        WebUI.clickElement(getVideoProviderSelect);
        WebUI.setElementText(videoLink, "https://www.youtube.com/watch?v=JZ9pHBEUWPo");
        WebUI.clickElement(featuredStatusRadioButton);
        WebUI.clickElement(colorClick);
        WebUI.clickElement(colorButtonClick);
        WebUI.setElementText(colorSearch, "red");
        WebUI.clickElement(colorSelect);
        WebUI.clickElement(attributesClick);
        WebUI.setElementText(attributesSearch, "Fabric");
        WebUI.clickElement(attributesSelect);
        WebUI.clickElement(fabricClick);
        WebUI.setElementText(fabricSearch, "Cot");
        WebUI.clickElement(fabricSelect);
        WebUI.clickElement(flashClick);
        WebUI.clickElement(flashSelect);
        WebUI.clearElement(flashDiscountClear);
        WebUI.setElementText(flashDiscountInput, "20");
        WebUI.clickElement(discountTypeClick);
        WebUI.clickElement(discountTypeSelect);
        WebUI.setElementText(shippingDays, "5");
        WebUI.clearElement(taxClear);
        WebUI.setElementText(taxInput, "15");
        WebUI.clickElement(taxTypeClick);
        WebUI.clickElement(taxTypeSelect);
        WebUI.clearElement(unitPriceClear);
        WebUI.setElementText(unitPriceInput, "100");
        WebUI.clickElement(dateClick);
        WebUI.clickElement(dateFromClick);
        WebUI.clickElement(dateToClick);
        WebUI.clickElement(dateSelect);
        WebUI.clearElement(discountClear);
        WebUI.setElementText(discountInput, "10");
        WebUI.clickElement(discountStyleClick);
        WebUI.clickElement(discountStyleSelect);
        WebUI.setElementText(externallink, "external link");
        WebUI.setElementText(externallinkText, "https://www.youtube.com/watch?v=orJSJGHjBLI");
        WebUI.setElementText(descriptionInput, "This is description of products");
        WebUI.clickElement(pdfFileClick);
        WebUI.setElementText(pdfFileSearch, "academic");
        WebUI.clickElement(pdfFileSelect);
        WebUI.clickElement(pdfFileAdd);
        WebUI.setElementText(metaTitle, "Hai Meta");
        WebUI.setElementText(metaDescription, "Description of Meta");
        WebUI.clickElement(metaImageClick);
        WebUI.setElementText(metaImageSearch, "dautay_resized");
        WebUI.clickElement(metaImageSelect);
        WebUI.clickElement(metaImageAdd);
        WebUI.clickElement(savebutton);

    }
}
