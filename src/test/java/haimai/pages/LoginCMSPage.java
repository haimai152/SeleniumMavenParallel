package haimai.pages;

import haimai.driver.DriverManagerMe;
import haimai.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginCMSPage extends CommonPage {

    public LoginCMSPage() {

    }

    private By loginLinkElement = By.xpath("//a[@class='text-reset d-inline-block opacity-60 py-2'][normalize-space()='Login']");
    private By inputEmail = By.id("email");
    private By inputPassword = By.name("password");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");
    private By popup = By.xpath("//button[@data-key='website-popup' and @data-value='removed']");
    private By errorMsgText = By.xpath("//span[@data-notify='message']");


    public CommonPage logIn(String email, String password) {
        WebUI.waitForPageLoaded();
        WebUI.waitForElementClickable(popup);
        popupClose();
        WebUI.waitForElementClickable(loginLinkElement);
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        WebUI.waitForElementClickable(loginButton);
        clickLoginButton();

        return new CommonPage();
    }

    public void verifyLogIn(String email, String password) {
        WebUI.waitForElementClickable(popup);
        popupClose();
        WebUI.waitForElementClickable(loginLinkElement);
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        WebUI.waitForElementClickable(loginButton);
        clickLoginButton();

        boolean checkAlertError = WebUI.checkElementExist(errorMsgText);
        Assert.assertTrue(checkAlertError, "No error displays.");

        Assert.assertEquals(WebUI.getElementText(errorMsgText), "Invalid login credentials", "Input data is incorrect");

    }

    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = DriverManagerMe.getDriver().findElement(errorMsgText);
        if (errorMsg.isDisplayed())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }

    public void clickLoginLink() {
        WebUI.clickElement(loginLinkElement);
    }

    public void clickLoginButton() {
        WebUI.clickElement(loginButton);
    }

    public void popupClose() {
        WebUI.clickElement(popup);
    }

    public void enterEmail(String email) {
        WebUI.setElementText(inputEmail, email);
    }

    public void enterPassword(String password) {
        WebUI.setElementText(inputPassword, password);
    }

}
