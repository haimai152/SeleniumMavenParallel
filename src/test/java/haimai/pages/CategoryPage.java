package haimai.pages;

import haimai.datatest.CategoryData;
import haimai.helpers.Helpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;

public class CategoryPage extends CommonPage {


    public CategoryPage() {
    }

    private By addNewCategoryButton = By.xpath("//span[normalize-space()='Add New category']");
    private By categoryName = By.xpath("//input[@id='name']");
    private By parentCategoryField = By.xpath("//div[contains(text(),'No Parent')]");
    private By parentCategorySearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By parentCategorySelect = By.xpath("//span[normalize-space()='Computer & Accessories']");
    private By orderNumber = By.xpath("//input[@id='order_level']");
    private By typeField = By.xpath("//button[@title='Physical']");
    private By typeSelect = By.xpath("//span[normalize-space()='Digital']");
    private By bannerField = By.xpath("(//div[contains(text(),'Choose File')])[1]");
    private By chooseFile = By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div//div[normalize-space()='Choose file']");
    private By bannerSearchFile = By.xpath("//input[@placeholder='Search your files']");
    //private By bannerSearchFileEnter = By.xpath("//input[@placeholder='Search your files']");
    private By bannerClickFile = By.xpath("(//div[@class='card-file-thumb'])[1]");
    private By bannerSelectFile = By.xpath("//button[normalize-space()='Add Files']");
    //private By iconField = By.xpath("//div[@class='input-group']//div[normalize-space()='Choose File']");
    private By iconField = By.xpath("//label[normalize-space()='Icon (32x32)']/following-sibling::div//div[normalize-space()='Choose file']");
    private By iconSearchFile = By.xpath("//input[@placeholder='Search your files']");
    // private By iconSearchFileEnter = By.xpath("//input[@placeholder='Search your files']");
    private By iconClickFile = By.xpath("(//div[@title='lake.jpg'])[1]");
    private By iconSelectFile = By.xpath("//button[normalize-space()='Add Files']");
    private By metaTitle = By.xpath("//input[@placeholder='Meta Title']");
    private By metaDescription = By.xpath("//textarea[@name='meta_description']");
    private By filterAttributesField = By.xpath("//button[@title='Nothing selected']");
    private By filterAttributesSearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By filterAttributesSelect = By.xpath("//a[@role='option']//span[normalize-space()='Size']");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");


    public void addCategory() {
        clickAddCategoryButton();
        enterCategoryData();
    }

    public void clickAddCategoryButton() {
        WebUI.waitForElementClickable(addNewCategoryButton);
        WebUI.clickElement(addNewCategoryButton);
    }

    public void enterCategoryData() {
        WebUI.setElementText(categoryName, CategoryData.CATEGORYNAME);
        WebUI.clickElement(parentCategoryField);
        WebUI.setElementText(parentCategorySearch, "Computer");
        WebUI.clickElement(parentCategorySelect);
        WebUI.setElementText(orderNumber, "10");
        WebUI.clickElement(typeField);
        WebUI.clickElement(typeSelect);

        WebUI.clickElement(chooseFile);
//        WebUI.setElementText(bannerSearchFile, "dautay_resized");
//        WebUI.clickElement(bannerClickFile);
//        WebUI.clickElement(bannerSelectFile);

        UploadFileCMSPage uploadFileCMSPage = new UploadFileCMSPage();
        String filePathBanner = Helpers.getCurrentDir() + "src\\test\\java\\haimai\\datatest\\dautay_resized.jpg";
        String fileNameBanner = "dautay_resized";
        uploadFileCMSPage.uploadFile(filePathBanner, fileNameBanner);
        WebUI.sleep(3);

        WebUI.clickElement(iconField);
        String filePathIcon = Helpers.getCurrentDir() + "src\\test\\java\\haimai\\datatest\\lake.jpg";
        String fileNameIcon = "lake";
        uploadFileCMSPage.uploadFile(filePathIcon, fileNameIcon);
        WebUI.sleep(3);
//        WebUI.setElementText(iconSearchFile, "lake");
//        WebUI.clickElement(iconClickFile);
//        WebUI.clickElement(iconSelectFile);

        WebUI.setElementText(metaTitle, "meta title");
        WebUI.setElementText(metaDescription, "meta description");

        WebUI.clickElement(filterAttributesField);

        WebUI.setElementText(filterAttributesSearch, "size");
        WebUI.clickElement(filterAttributesSelect);

        WebUI.clickElement(saveButton);
        WebUI.sleep(3);
    }

}
