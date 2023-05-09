package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {
    //Declaring WebElement type variables
    @CacheLookup
    @FindBy(xpath = "(//span[@class='hidden-xs hidden-sm hidden-md'])[3]")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;
    @CacheLookup
    @FindBy(xpath = "/li[@class='dropdown open']/ul/li[2]")
    WebElement loginLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement logoutText;
    @CacheLookup
    @FindBy(xpath = "//li[@class='dropdown open']/ul/li[5]")
    WebElement continueButtonLogout;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
    List<WebElement> listOfMyAccountOptions;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerLinkText;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement loginText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='pull-right']/a")
    WebElement accountLogoutContinueButton;

    public void clickOnLogOutButtonAfterAccountCreated() {
        accountLogoutContinueButton.click();
    }

    //Method to click on My Account
    public void clickOnMyAccountLink() {
        Reporter.log("Click on My Account Link " + myAccountLink.toString());
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS, "Click on My Account Link");
    }

    //Method to click on Register link
    public void clickOnRegisterLink() {
        Reporter.log("Click on Register Link " + registerLink.toString());
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS, "Click on Register Link");
    }

    //Method to click on Login link
    public void clickOnLoginLink() {
        Reporter.log("Click on Login Link " + loginLink.toString());
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS, "Click on Login Link");
    }

    //this method will select option from My account aoptions
    public void selectMyAccountOptions(String options) {
        Reporter.log("Select My Account Options " + listOfMyAccountOptions.toString());

        List<WebElement> accountOptionList = listOfMyAccountOptions;
        for (WebElement accountOptions : accountOptionList) {
            if (accountOptions.getText().equalsIgnoreCase(options)) {
                accountOptions.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "My Account Option selected is " + options);
    }

    //this method will get text
    public String getMyAccountText() {
        Reporter.log("My Account Text " + myAccountText.toString());
        CustomListeners.test.log(Status.PASS, "My Account text is " + myAccountText.getText());
        return myAccountText.getText();
    }

    //this method will get text
    public String getLogoutText() {
        Reporter.log("Logout Text " + logoutText.toString());
        CustomListeners.test.log(Status.PASS, "Logout Text is " + logoutText.getText());
        return logoutText.getText();
    }

    //this method will click on continue button
    public void clickContinueButtonLogout() {
        Reporter.log("Click on Logout Link " + continueButtonLogout.toString());
        clickOnElement(continueButtonLogout);
        CustomListeners.test.log(Status.PASS, "Click on Logout Link");

    }

    public String getTextForRegister() {
        Reporter.log("Login text " + registerLinkText.toString());
        CustomListeners.test.log(Status.PASS, "Login text");
        return registerLinkText.getText();
    }

    public String getLoginText() {
        Reporter.log("Login text " + loginText.toString());
        CustomListeners.test.log(Status.PASS, "Login text" + loginText.getText());
        return loginText.getText();
    }
}