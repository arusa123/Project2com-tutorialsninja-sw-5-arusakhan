package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencyLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[1]")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement showAllDesktopLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li[2]")
    WebElement laptopAndNotebookLink;
    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement showAllLaptopAndNotebook;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;
    @CacheLookup
    @FindBy(xpath = "//li[@class='dropdown open']/ul/li[2]")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement logoutLinkText;

    //this method will get logout text
    public String logOutText() {
        Reporter.log("Log out " + logoutLinkText.toString());
        CustomListeners.test.log(Status.PASS, "Logout " + logoutLinkText.getText());
        return logoutLinkText.getText();
    }

    //this method will click on register link
    public void clickOnRegisterLink() {
        Reporter.log("Link for registration " + registerLink.toString());
        clickOnElement(registerLink);
//        CustomListeners.test.log(Status.PASS, "link for registration " + registerLink.getText());
    }


    //this method will click on login
    public void clickOnloginLink() {
        Reporter.log("click on login link " + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "click on login link " + loginLink.getText());
        clickOnElement(loginLink);
        //CustomListeners.test.log(Status.PASS, "click on login link " + loginLink.getText());
    }

    //this method will click on my account link
    public void clickOnmyAccountLink() {
        Reporter.log("My account link  ");
        clickOnElement(myAccountLink);
//        CustomListeners.test.log(Status.PASS, "my account link " + myAccountLink.getText());

    }

    public void selectRequiredCurrency() {
        clickOnElement(currencyLink);
        clickOnElement(By.xpath("(//button[@class='currency-select btn btn-link btn-block'])[2]"));

    }

    public void hoverOnDesktop() {
        Reporter.log("desktop link  " + desktopLink.toString());
        mouseHoverToElement(desktopLink);
        CustomListeners.test.log(Status.PASS, "desktop link " + desktopLink.getText());
    }

    public void clickOnDesktoplink() {
        Reporter.log("show alldesktop link  " + showAllDesktopLink.toString());
        clickOnElement(showAllDesktopLink);
//        CustomListeners.test.log(Status.PASS, "Show all desktop link " + showAllDesktopLink.getText());
    }

    public void hoverOnLaptopsandNotebooks() {
        Reporter.log("Laptop and notebook link  " + laptopAndNotebookLink.toString());
        mouseHoverToElement(laptopAndNotebookLink);
        CustomListeners.test.log(Status.PASS, "Laptop and notebook link " + laptopAndNotebookLink.getText());

    }

    public void clickOnShowALLLaptopAndNotebook() {
        Reporter.log("show all Laptop and notebook link  " + showAllLaptopAndNotebook.toString());
        clickOnElement(showAllLaptopAndNotebook);
//        CustomListeners.test.log(Status.PASS, "show all Laptop and notebook link " + showAllLaptopAndNotebook.getText());

    }


}
