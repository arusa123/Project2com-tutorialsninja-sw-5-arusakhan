package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LaptopAndNotebookPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortBy;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='MacBook']")
    WebElement macBook;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement pageTitle;

    public void sortByPriceLowToHigh() {
        Reporter.log("Price (Low > High) " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Price (Low > High)");
        CustomListeners.test.log(Status.PASS, "Price (Low > High)" + sortBy);
    }

    public void clickOnMacBookLaptop() {
        Reporter.log("macbook " + macBook.toString());
        clickOnElement(macBook);
        CustomListeners.test.log(Status.PASS, "macbook" + macBook);
    }

    //this method will get the text of the page title
    public String getPageTitleText() {
        Reporter.log("Page title " + macBook.toString());
        CustomListeners.test.log(Status.PASS, "Page title" + sortBy);
        return pageTitle.getText();
    }

}
