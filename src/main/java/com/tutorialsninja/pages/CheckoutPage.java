package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Checkout")
    WebElement checkoutText;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckout;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement email;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;


    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement contiuneCheckout;
    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[3]/div[2]/div[1]/p[2]/textarea[1]")
    WebElement commentField;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement termAndConditionsCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonInCommentSection;
    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[3]/div[2]/div/div[1]")
    WebElement paymentErrorMessage;


    public void sendTextToAddCommentBox(String comment) {
        Reporter.log("Comment field " + commentField.toString());
        sendTextToElement(commentField, comment);
        CustomListeners.test.log(Status.PASS, "Comment field  " + commentField);
    }

    public void clickOnTermAndConditionsCheckBox() {
        Reporter.log("Terms and condition " + termAndConditionsCheckBox.toString());
        clickOnElement(termAndConditionsCheckBox);
        CustomListeners.test.log(Status.PASS, "Terms and condition  " + termAndConditionsCheckBox);
    }

    public void clickOnContinueButtonInCommentSection() {
        Reporter.log("continue " + continueButtonInCommentSection.toString());
        clickOnElement(continueButtonInCommentSection);
        CustomListeners.test.log(Status.PASS, "continue " + continueButtonInCommentSection);
    }

    public String getPaymentErrorMessage() {
        Reporter.log("payment message " + paymentErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Payment message  " + paymentErrorMessage);
        return paymentErrorMessage.getText();
    }


    //this method will click on continue
    public void contiuneToCheckout() {
        Reporter.log("contiune checkout " + contiuneCheckout.toString());
        clickOnElement(contiuneCheckout);
        CustomListeners.test.log(Status.PASS, "continue checkout" + contiuneCheckout);
    }

    public void sendTextToFirstNameField(String fName) {
        Reporter.log("first name " + firstName.toString());
        sendTextToElement(firstName, fName + getAlphaNumericString(2));
        CustomListeners.test.log(Status.PASS, "first name " + firstName);
    }

    public void sendTextToLastNameField(String lname) {
        Reporter.log("Last name " + lastName.toString());
        sendTextToElement(lastName, lname + getAlphaNumericString(2));
        CustomListeners.test.log(Status.PASS, "last  name " + lastName);
    }

    public void sendTextToEmailField(String uEmail) {
        Reporter.log("Email " + email.toString());
        sendTextToElement(email, uEmail + getAlphaNumericString(2) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Email " + email);
    }

    public void sendTextToTelephoneField(String tele) {
        Reporter.log("Telephone " + telephone.toString());
        sendTextToElement(telephone, tele);
        CustomListeners.test.log(Status.PASS, "Telephone " + telephone);
    }

    public void sendTextToAddressField(String add) {
        Reporter.log("Address " + address.toString());
        sendTextToElement(address, add);
        CustomListeners.test.log(Status.PASS, "Address " + address);
    }

    public void sendTextToCityField(String uCty) {
        Reporter.log("City " + city.toString());
        sendTextToElement(city, uCty);
        CustomListeners.test.log(Status.PASS, "City " + city);
    }

    public void sendTextToPostCOdeField(String pCode) {
        Reporter.log("post code " + postcode.toString());
        sendTextToElement(postcode, pCode + getAlphaNumericString(1));
        CustomListeners.test.log(Status.PASS, "Post code " + postcode);
    }

    //this method will send country name
    public void selectCountry(String uCountry) {
        Reporter.log("Country " + country.toString());
        selectByVisibleTextFromDropDown(country, uCountry);
        CustomListeners.test.log(Status.PASS, "country " + country);
    }

    //this method will send region
    public void selectRegion(String uRegion) {
        Reporter.log("region " + region.toString());
        selectByVisibleTextFromDropDown(region, uRegion);
        CustomListeners.test.log(Status.PASS, "region " + region);
    }

    //this method will get the checkout text
    public String getCheckoutText() {
        Reporter.log("checkout text " + checkoutText.toString());
        CustomListeners.test.log(Status.PASS, "checkout text" + checkoutText);
        return checkoutText.getText();
    }

    //this method will get new customer text
    public String getNewCustomerText() {
        Reporter.log("new customer text " + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "new customer text" + newCustomerText);
        return newCustomerText.getText();
    }

    //this method will click on guestCheckout
    public void clickOnGuestCheckout() {
        Reporter.log("guest checkout  " + guestCheckout.toString());
        clickOnElement(guestCheckout);
        CustomListeners.test.log(Status.PASS, "guest checkout " + guestCheckout);
    }


    //this method will click on the contiune button
    public void clickOnContinueButton() {
        Reporter.log("click on continue  " + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "click on continue " + continueButton);
    }


}
