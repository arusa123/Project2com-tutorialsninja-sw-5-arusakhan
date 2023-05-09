package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButtonLogout;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement loginButton;

    public String getReturningCustomerText() {
        Reporter.log("Returning customer text" + returningCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "Returning customer text" + returningCustomerText);
        return returningCustomerText.getText();
    }

    public String getAccountLogoutText() {
        Reporter.log("Account log out text" + accountLogoutText.toString());
        CustomListeners.test.log(Status.PASS, "Account logout text" + accountLogoutText);
        return accountLogoutText.getText();
    }

    public void clickOnContinueButtonLogout() {
        Reporter.log("continue button for logout" + continueButtonLogout.toString());
        clickOnElement(continueButtonLogout);
        CustomListeners.test.log(Status.PASS, "Contiune button for logout" + continueButtonLogout);
    }

    public void sendTextToEmailAddressField(String emailId) {
        Reporter.log("send text to email field" + continueButtonLogout.toString());
        sendTextToElement(emailAddress, emailId);
        CustomListeners.test.log(Status.PASS, "send text to email field" + emailAddress);
    }

    public void sendTextToPasswordField(String lPassword) {
        Reporter.log("continue button for logout" + continueButtonLogout.toString());
        sendTextToElement(password, lPassword);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on Login Button ");
    }
}
