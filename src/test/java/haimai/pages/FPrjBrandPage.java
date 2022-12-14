package haimai.pages;

import haimai.helpers.Helpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FPrjBrandPage extends CommonPage {

    public FPrjBrandPage() {
    }
    private By brandName = By.xpath("//input[@placeholder='Name']");
    private By logoFileElement = By.xpath("//label[normalize-space()='Logo (120x80)']/following-sibling::div//div[normalize-space()='Choose File']");
    private By metaTitleBrand = By.xpath("//input[@placeholder='Meta Title']");
    private By metaDescriptionBrand = By.xpath("//textarea[@name='meta_description']");
    private By saveButtonBrand = By.xpath("//button[normalize-space()='Save']");
    private By searchBrand = By.xpath("//input[@id='search']");
    private By editBrandButton = By.xpath("(//i[@class='las la-edit'])[1]");
    private By delBrandButton = By.xpath("(//a[@title='Delete'])[1]");
    private By confirmDelBrandButton = By.xpath("//a[@id='delete-link']");
    private By brandMenuItem = By.xpath("//span[normalize-space()='Brand']");

    public void addBrandData(String name, String fileLogo, String logoName, String metaTitle, String metaDescription) {
        WebUI.setElementText(brandName, name);
        WebUI.clickElement(logoFileElement);

        UploadFileCMSPage uploadFileCMSPage = new UploadFileCMSPage();
        String filePathLogo = Helpers.getCurrentDir() + fileLogo;
        WebUI.sleep(3);
        uploadFileCMSPage.uploadFile(filePathLogo, logoName);
        WebUI.sleep(3);

        WebUI.setElementText(metaTitleBrand, metaTitle);
        WebUI.setElementText(metaDescriptionBrand, metaDescription);

        WebUI.clickElement(saveButtonBrand);

        verifyData(name);

    }

    public void searchBrand(String nameBrand) {
        WebUI.waitForElementClickable(searchBrand);
        WebUI.setElementText(searchBrand, nameBrand);
        WebUI.pressENTER();
    }

    public void verifyData(String name){
        searchBrand(name);
        By brandNameElement = By.xpath(" //td[normalize-space()='" + name + "']");
        boolean checkBrandName = WebUI.checkElementExist(brandNameElement);
        Assert.assertTrue(checkBrandName, "Fail to add/edit Brand");
    }
    public void editBrandData(String oldName, String nameEdit, String fileLogo, String logoName, String metaTitle, String metaDescription) {
        WebUI.waitForElementClickable(editBrandButton);
        WebUI.clickElement(editBrandButton);
        WebUI.clearElement(brandName);
        WebUI.setElementText(brandName, nameEdit);
        WebUI.clearElement(metaTitleBrand);
        WebUI.setElementText(metaTitleBrand, metaTitle);
        WebUI.clearElement(metaDescriptionBrand);
        WebUI.setElementText(metaDescriptionBrand, metaDescription);
        WebUI.clickElement(saveButtonBrand);

        WebUI.clickElement(brandMenuItem);
        verifyData(nameEdit);
    }

    public void delBrandData() {
        WebUI.waitForElementClickable(delBrandButton);
        WebUI.clickElement(delBrandButton);
        WebUI.clickElement(confirmDelBrandButton);
    }

}
