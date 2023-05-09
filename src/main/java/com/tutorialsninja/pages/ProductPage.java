package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement addToShoppingLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> dateList;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;

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
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement addToShoppingCart;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement laptopAddedSucessfullyText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement selectQuantity;

    public void enterQuantityRequired(String quantity) {
        Reporter.log("Clear text " + selectQuantity.toString());
        clearTextFromField(selectQuantity);
        // Reporter.log("Send quantity " + quantity + " to firstname field " + selectQuantity.toString());
        sendTextToElement(selectQuantity, quantity);
        //  CustomListeners.test.log(Status.PASS, "Quantity is " + quantity);
    }

    //   this method will add the item in the cart
    public void clickAddToCart() {
//        Reporter.log("Add to cart" + addToCart.toString());
//        CustomListeners.test.log(Status.PASS, "Add to cart" + addToCart);
        clickOnElement(addToCart);

    }

    //this metod will click on the shopping link
    public void clickOnShoppingCartLink() {
        Reporter.log("Add to shopping cart" + addToShoppingCart.toString());
        clickOnElement(addToShoppingCart);
        CustomListeners.test.log(Status.PASS, "Add to shopping cart" + addToShoppingCart);

    }

    //this method will verify the macbook text
    public String getMacBookLaptopText() {
        Reporter.log("Macbook text" + macBookText.toString());
        CustomListeners.test.log(Status.PASS, "Macbook text" + macBookText);
        return macBookText.getText();
    }

    public String getMacBookAddedSuccessfullyText() {
        Reporter.log("Macbook add successfully" + laptopAddedSucessfullyText.toString());
        CustomListeners.test.log(Status.PASS, "Macbook add successfully" + laptopAddedSucessfullyText);
        return laptopAddedSucessfullyText.getText();
    }

    public String getAddToCartText() {
        Reporter.log("add to cart text" + addToShoppingLink.toString());
        CustomListeners.test.log(Status.PASS, "add to cart text" + addToShoppingLink);
        return addToShoppingLink.getText();
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
        //CustomListeners.test.log(Status.PASS, "Selected Date is " + date);

    }


}
