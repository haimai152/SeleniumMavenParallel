package haimai.pages;

import haimai.helpers.ExcelHelpers;
import haimai.helpers.Helpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;

import java.util.Hashtable;

public class FPrjCategoryPage extends CommonPage {
    ExcelHelpers excelHelpers;

    public FPrjCategoryPage() {
        excelHelpers = new ExcelHelpers();
    }

    private By addNewCategoryButton = By.xpath("//span[normalize-space()='Add New category']");
    private By categoryName = By.xpath("//input[@id='name']");
    private By parentCategoryField = By.xpath("//div[contains(text(),'No Parent')]");
    private By parentCategorySearch = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By parentCategorySelect = By.xpath("//span[normalize-space()='Computer & Accessories']");
    private By orderNumber = By.xpath("//input[@id='order_level']");
    private By typeField = By.xpath("//button[@title='Physical']");
    private By typeDigital = By.xpath("//span[normalize-space()='Digital']");
    private By typePhysical = By.xpath("//span[normalize-space()='Physical']");
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


    public void addCategory(Hashtable<String, String> data) {
        clickAddCategoryButton();
        enterCategoryData(data);
    }

    public void clickAddCategoryButton() {
        WebUI.waitForElementClickable(addNewCategoryButton);
        WebUI.clickElement(addNewCategoryButton);
    }

    public void enterCategoryData(Hashtable<String, String> dataPage) {
        WebUI.setElementText(categoryName, dataPage.get("name"));
        WebUI.clickElement(parentCategoryField);
        WebUI.setElementText(parentCategorySearch, dataPage.get("parentCat"));
        By parentCatSelected = By.xpath("//span[normalize-space()='" + dataPage.get("parentCat") + "']");
        WebUI.clickElement(parentCatSelected);
        WebUI.setElementText(orderNumber, dataPage.get("orderingNumber"));
        WebUI.clickElement(typeField);
        if (dataPage.get("type").equals("Digital")) {
            WebUI.clickElement(typeDigital);
        } else {
            WebUI.clickElement(typePhysical);
        }

        WebUI.clickElement(chooseFile);
        UploadFileCMSPage uploadFileCMSPage = new UploadFileCMSPage();
        String filePathLogo = Helpers.getCurrentDir() + dataPage.get("bannerFilePath");
        WebUI.sleep(3);
        uploadFileCMSPage.uploadFile(filePathLogo, dataPage.get("bannerFileName"));
        WebUI.sleep(3);

        WebUI.clickElement(iconField);
        String filePathIcon = Helpers.getCurrentDir() + dataPage.get("iconFilePath");
        String fileNameIcon = "lake";
        uploadFileCMSPage.uploadFile(filePathIcon, dataPage.get("iconFileName"));
        WebUI.sleep(3);

        WebUI.setElementText(metaTitle, dataPage.get("metaTitle"));
        WebUI.setElementText(metaDescription, dataPage.get("metaDes"));

        WebUI.clickElement(filterAttributesField);
        WebUI.setElementText(filterAttributesSearch, dataPage.get("filterAtt"));
        By filterAttSelected = By.xpath("//a[@role='option']//span[normalize-space()='" + dataPage.get("filterAtt") + "']");
        WebUI.clickElement(filterAttSelected);

        WebUI.clickElement(saveButton);
        WebUI.sleep(3);
    }

}
