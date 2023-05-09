package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopMenuPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul//li//a")
    List<WebElement> topMenu;


    public void selectMenu(String menu) {
        List<WebElement> menuList = topMenu;
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(menu)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = topMenu;
        }
    }

    public void hoverOverMainMenuBar(String mainMenu) {
        Actions actions = new Actions(driver);
        List<WebElement> menuList = topMenu;
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(mainMenu)) {
                    actions.moveToElement(list).build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = topMenu;
        }
    }
}

