package com.tutorialsninja.testsuite;


import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DesktopTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        homePage = new HomePage();
        shoppingCartPage = new ShoppingCartPage();
        homePage = new HomePage();
        desktopPage = new DesktopPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        homePage.hoverOnDesktop();
        homePage.clickOnDesktoplink();
        desktopPage.sortListByZtoA();
        Assert.assertEquals(desktopPage.afterSortingTheProducts(), desktopPage.beforeSortTheProducts(), "Name: Z to A");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.selectRequiredCurrency();
        homePage.hoverOnDesktop();
        homePage.clickOnDesktoplink();
        desktopPage.sortListByZtoA();
        desktopPage.clickOnHPLP3065();
        Assert.assertEquals(desktopPage.getTextOfTheLaptop(), "HP LP3065", "incorrect name ");
        desktopPage.selectDateAndYearOnCalendar("November", "2022");
        desktopPage.selectDateOnCalendar("30");
        desktopPage.enterQuantityRequired("1");
        desktopPage.clickAddToCart();
        Thread.sleep(500);
        Assert.assertEquals(desktopPage.getAddToCartText(), "Success: You have added HP LP3065 to your shopping cart!\n" + "×", "error");
        desktopPage.clickOnShoppingCartLink();
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping Cart  (1.00kg)", "Incorrect message");
        Assert.assertEquals(shoppingCartPage.getProductNameText(), "HP LP3065", "Incorrect laptop name ");
        Assert.assertEquals(shoppingCartPage.getTextOfProductModel(), "Product 21");
        Assert.assertEquals(shoppingCartPage.getPriceText("£74.73"), "£74.73", "Price is not correct");

    }
}