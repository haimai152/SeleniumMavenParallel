package haimai.pages;

import haimai.helpers.ExcelHelpers;
import haimai.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Hashtable;

public class FPrjCheckAddedProOnUserPage extends CommonPage {
    ExcelHelpers excelHelpers;

    public FPrjCheckAddedProOnUserPage() {
        excelHelpers = new ExcelHelpers();
    }

    private By searchProductElement = By.xpath("//input[@id='search']");
    private By searchProductButton = By.xpath("//div[@class='input-group-append d-none d-lg-block']//button[@type='submit']");
    private By PopUp = By.xpath("//button[@data-key='website-popup']");

//    private By adminButton = By.xpath("//span[normalize-space()='Admin']");
//    private By logoutButton = By.xpath("//a[@href='https://cms.anhtester.com/logout']");

    public void checkAddedProduct(String productName) {
        WebUI.clickElement(PopUp);
        WebUI.waitForElementVisible(searchProductElement);
        WebUI.clickElement(searchProductElement);
        WebUI.setElementText(searchProductElement, productName);
        WebUI.clickElement(searchProductButton);
        By searchResultProductName = By.xpath("(//a[contains(text(),'" + productName + "')])[1]");
        Boolean existsProductSearch = WebUI.checkElementExist(searchResultProductName);
        if (existsProductSearch) {
            WebUI.clickElement(searchResultProductName);
        } else {
            Assert.assertTrue(existsProductSearch, "Product could not be found");
        }

    }

    public void checkDetailProduct(Hashtable<String, String> dataPage) {
        WebElement nameProduct = WebUI.getWebElement(By.xpath("//h1[normalize-space()='" + dataPage.get("productName") +"']"));
        String nameProdElement = nameProduct.getText();
        System.out.println("Product name is " + nameProdElement);
        Assert.assertTrue(nameProdElement.equals(dataPage.get("productName")), "Product name is incorrect");

        WebElement priceElement = WebUI.getWebElement(By.xpath("//div[@class='fs-20 opacity-60']//del[contains(text(),'$200.00')]"));
        String splitStPrice = WebUI.splitDot(priceElement.getText());
        String priceString = splitStPrice.substring(1, splitStPrice.length()-4);
        boolean comparePrice = priceString.equals(dataPage.get("unitPrice"));
        Assert.assertTrue(comparePrice, "Price is not the same as inputted price");
        System.out.println("----- Compare price is done -----" + comparePrice);

        WebElement priceDisElement = WebUI.getWebElement(By.xpath("//div[@class='row no-gutters my-2']//div[@class='col-sm-10']//div"));
        int discount = Integer.parseInt(dataPage.get("discount"));
        int inputtedPrice = Integer.parseInt(dataPage.get("unitPrice"));
        int inputtedPriceDis;
        String splitStPriceDis = WebUI.splitDot(priceDisElement.getText());
        String priceDisText = splitStPriceDis.substring(1,splitStPriceDis.length()-4);
        //Calculate the price for discount
        if(dataPage.get("discountType").equals("Percent")) {inputtedPriceDis = inputtedPrice-(discount*inputtedPrice)/100;}
        else {inputtedPriceDis = inputtedPrice- inputtedPrice-discount;}
        Assert.assertTrue(Integer.parseInt(priceDisText)==inputtedPriceDis, "Price Discount is not correct");
        System.out.println("----- Compare price discount is done -----");

        WebElement quantityElement = WebUI.getWebElement(By.xpath("//div[@class='avialable-amount opacity-60']"));
        String quantityText = quantityElement.getText();
        String quantitySplit =WebUI.splitSpace(quantityText);
        int l =quantitySplit.length();
        String finalQuantity = quantitySplit.substring(1,l);
        Assert.assertTrue(finalQuantity.equals(dataPage.get("quantity")), "Quantity is incorrect");

    }
}
