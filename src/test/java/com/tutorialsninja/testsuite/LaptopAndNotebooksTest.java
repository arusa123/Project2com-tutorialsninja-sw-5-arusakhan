package com.tutorialsninja.testsuite;


import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LaptopAndNotebooksTest extends BaseTest {
    //object creation
    HomePage homePage;
    LaptopAndNotebookPage laptopAndNotebookPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        homePage = new HomePage();
        shoppingCartPage = new ShoppingCartPage();
        laptopAndNotebookPage = new LaptopAndNotebookPage();
        productPage = new ProductPage();
        checkoutPage = new CheckoutPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        homePage.selectRequiredCurrency();
        homePage.hoverOnLaptopsandNotebooks();
        homePage.clickOnShowALLLaptopAndNotebook();
        laptopAndNotebookPage.sortByPriceLowToHigh();
        laptopAndNotebookPage.clickOnMacBookLaptop();
        Assert.assertEquals(productPage.getMacBookLaptopText(), "MacBook");
        productPage.clickAddToCart();
        Assert.assertEquals(productPage.getMacBookAddedSuccessfullyText(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Incorrect name");
        productPage.clickOnShoppingCartLink();
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping Cart  (0.00kg)", "error");
        Assert.assertEquals(shoppingCartPage.macBookLaptopText(), "MacBook");
        shoppingCartPage.updateQuantity("2");
        shoppingCartPage.clickOnTheUpdateCartButton();
        Assert.assertEquals(shoppingCartPage.getShoppingCartUpdatedSuccesfully(), "Success: You have modified your shopping cart!\n" + "×", "error");
        Assert.assertEquals(shoppingCartPage.getPriceText("£737.45"), "£737.45");
        shoppingCartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkoutPage.getCheckoutText(), "Checkout", "error");
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.getNewCustomerText(), "New Customer", "error");
        checkoutPage.clickOnGuestCheckout();
        checkoutPage.clickOnContinueButton();
        checkoutPage.sendTextToFirstNameField("prime");
        checkoutPage.sendTextToLastNameField("Testing");
        checkoutPage.sendTextToEmailField("prime");
        checkoutPage.sendTextToTelephoneField("020876229");
        checkoutPage.sendTextToAddressField("1 London Road ");
        checkoutPage.sendTextToCityField("London");
        checkoutPage.sendTextToPostCOdeField("HA1 2TB");
        checkoutPage.selectCountry("United Kingdom");
        checkoutPage.selectRegion("Greater London");
        checkoutPage.contiuneToCheckout();
        checkoutPage.sendTextToAddCommentBox("Please Delivery on time");
        checkoutPage.clickOnTermAndConditionsCheckBox();
        checkoutPage.clickOnContinueButtonInCommentSection();
        Assert.assertEquals(checkoutPage.getPaymentErrorMessage(), "Warning: No Payment options are available. Please contact us for assistance!", "error");

    }


}