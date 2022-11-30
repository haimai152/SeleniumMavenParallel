package haimai.testcases;

import haimai.common.BaseTestParallel;
import haimai.helpers.Helpers;
import haimai.pages.UploadFileCMSPage;
import haimai.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class UploadFileCMS extends BaseTestParallel {

    @Test
    public void testUploadFileWithSendKeys() throws InterruptedException {
        WebUI.openURL("https://cgi-lib.berkeley.edu/ex/fup.html");
        WebUI.waitForPageLoaded();
        By inputFileUpload = By.xpath("//input[@name='upfile']");

        //DriverManager.getDriver().findElement(inputFileUpload).sendKeys(Helpers.getCurrentDir() + "datatest/Selenium4_Upload.png");
        WebUI.setElementText(inputFileUpload, Helpers.getCurrentDir() + "src/test/java/haimai/datatest/dautay_resized.jpg");

        // System.out.println(inputFileUpload);

        Thread.sleep(3000);
    }

    @Test
    public void testUploadFileInCategoryCMS() {
        UploadFileCMSPage uploadFileCMSPage = new UploadFileCMSPage();
        uploadFileCMSPage.loginCMS();
        uploadFileCMSPage.uploadFileInCategory();
    }

}
