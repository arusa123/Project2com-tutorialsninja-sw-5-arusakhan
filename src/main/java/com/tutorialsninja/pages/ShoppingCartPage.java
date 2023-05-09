package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement productNameText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingText;
    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Product 21']")
    WebElement productModelText;
    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement productPrice;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookTextinCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[4]/div/input")
    WebElement changeQuantity;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement updateCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement cartUpdatedSucessfullyText;
    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkoutButton;

    public void clickOnCheckoutButton() {
        Reporter.log("Click on guest checkout  Button " + checkoutButton.toString());
        clickOnElement(checkoutButton);
        CustomListeners.test.log(Status.PASS, "Click on guest checkout Button");
    }

    public String getShoppingCartUpdatedSuccesfully() {
        Reporter.log("The Shopping Cart Updated Text is " + cartUpdatedSucessfullyText.toString());
        CustomListeners.test.log(Status.PASS, "The Shopping Cart Updated Text is " + cartUpdatedSucessfullyText.getText());
        return getTextFromElement(cartUpdatedSucessfullyText);
    }

    public void clickOnTheUpdateCartButton() {
        Reporter.log("Update cart " + updateCart.toString());
        CustomListeners.test.log(Status.PASS, "Update cart button " + updateCart.getText());
        clickOnElement(updateCart);
    }

    public void updateQuantity(String qty) {
        clearTextFromField(changeQuantity);
        sendTextToElement(changeQuantity, qty);
    }


    public String getShoppingCartText() {
        Reporter.log("Shopping cart text " + shoppingText.toString());
        CustomListeners.test.log(Status.PASS, "shopping cart text " + shoppingText.getText());
        return shoppingText.getText();
    }

    public String getProductNameText() {
        Reporter.log("The product Name is " + productNameText.toString());
        CustomListeners.test.log(Status.PASS, "The product Name is " + productNameText.getText());
        return productNameText.getText();
    }

    public String getTextOfProductModel() {
        Reporter.log("The Model Name is " + productModelText.toString());
        CustomListeners.test.log(Status.PASS, "The Model Name is " + productModelText.getText());
        return productModelText.getText();
    }

    public String getPriceText(String price) {
        Reporter.log("The price is " + productPrice.toString());
        CustomListeners.test.log(Status.PASS, "The price is " + productPrice.getText());
        return productPrice.getText();
    }

    //this method will verify the macbook laptop text
    public String macBookLaptopText() {
        Reporter.log("Macbook text " + macBookTextinCart.toString());
        CustomListeners.test.log(Status.PASS, "Macbook text " + macBookTextinCart.getText());
        return macBookTextinCart.getText();
    }

}
