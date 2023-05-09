package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement titleOfDesktop;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement laptopName;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='HP LP3065']")
    WebElement laptopText;
    @CacheLookup
    @FindBy(css = "i[class='fa fa-calendar']")
    WebElement calendarButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[2]")
    WebElement monthYearSelect;

    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']/div[1]/table/thead/tr[1]/th[3]")
    WebElement nextMonthAndYearButtonInCalendar;


    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker']//div//table//td")
    List<WebElement> datesInCalendar;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement selectQuantity;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement addToShoppingCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement addToShoppingLink;

    public void clickAddToCart() {
//        Reporter.log("Add to cart" + addToCart.toString());
//        CustomListeners.test.log(Status.PASS, "Add to cart" + addToCart);
        clickOnElement(addToCart);
    }

    public void clickOnShoppingCartLink() {
        Reporter.log("Add to shopping cart" + addToShoppingCart.toString());
        clickOnElement(addToShoppingCart);
        // CustomListeners.test.log(Status.PASS, "Add to shopping cart" + addToShoppingCart);

    }

    public String getAddToCartText() {
        Reporter.log("add to cart text" + addToShoppingLink.toString());
        CustomListeners.test.log(Status.PASS, "add to cart text" + addToShoppingLink);
        return addToShoppingLink.getText();
    }


    public void enterQuantityRequired(String quantity) {
        Reporter.log("Clear text " + selectQuantity.toString());
        clearTextFromField(selectQuantity);
        // Reporter.log("Send quantity " + quantity + " to firstname field " + selectQuantity.toString());
        sendTextToElement(selectQuantity, quantity);
        //  CustomListeners.test.log(Status.PASS, "Quantity is " + quantity);
    }


    //this method will get the page title text
    public String getDesktopText() {
        Reporter.log("Title " + titleOfDesktop.toString());
        CustomListeners.test.log(Status.PASS, "Title" + titleOfDesktop);
        return titleOfDesktop.getText();
    }

    public ArrayList beforeSortTheProducts() {
        List<WebElement> products = listOfProducts;
        ArrayList<String> originalProductList = new ArrayList<>();
        for (WebElement list : products) {
            originalProductList.add(list.getText());
        }
        return originalProductList;
    }

    public ArrayList afterSortingTheProducts() {

        Collections.reverse(beforeSortTheProducts());
        System.out.println(beforeSortTheProducts());
        List<WebElement> products = listOfProducts;
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement newList : products) {
            afterSortList.add(newList.getText());
        }
        return afterSortList;
    }

    public void clickOnHPLP3065() {
        Reporter.log("Laptop name " + laptopName.toString());
        clickOnElement(laptopName);
        CustomListeners.test.log(Status.PASS, "Laptop name" + laptopName);
    }

    public String getTextOfTheLaptop() {
//        Reporter.log("Laptop text " + laptopText.toString());
//        CustomListeners.test.log(Status.PASS, "Laptop text" + laptopText);
        return laptopText.getText();
    }

    public void selectDateAndYearOnCalendar(String month, String year) {
        // Reporter.log("Clicking on Calender Button " + calendarButton.toString());
        clickOnElement(calendarButton);
        while (true) {
            String monthYear = getTextFromElement(monthYearSelect);
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextMonthAndYearButtonInCalendar);
            }

        }
        //  CustomListeners.test.log(Status.PASS, "Click on Calender Button");

    }

    //This method will select the date
    public void selectDateOnCalendar(String date) {
        //  Reporter.log("Select Date " + datesInCalendar.toString());
        List<WebElement> allDates = datesInCalendar;
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;

            }
        }
    }

    //CustomListen
    public void sortListByZtoA() {
        Reporter.log("Sort By " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
        CustomListeners.test.log(Status.PASS, "Sort by" + sortBy);
    }

    public void listAtoZ() {
        Reporter.log("A -Z " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Name (A - Z)");
        CustomListeners.test.log(Status.PASS, "Sort by" + sortBy);
    }

}


