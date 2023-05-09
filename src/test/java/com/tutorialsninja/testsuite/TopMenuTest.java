package com.tutorialsninja.testsuite;


import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.LaptopAndNotebookPage;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    TopMenuPage topMenuPage;
    DesktopPage desktopPage;
    LaptopAndNotebookPage laptopAndNotebookPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        topMenuPage = new TopMenuPage();
        desktopPage = new DesktopPage();
        laptopAndNotebookPage = new LaptopAndNotebookPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        topMenuPage.hoverOverMainMenuBar("Laptops & Notebooks");
        topMenuPage.selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(laptopAndNotebookPage.getPageTitleText(), "Laptops & Notebooks");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        topMenuPage.hoverOverMainMenuBar("Desktops");
        topMenuPage.selectMenu("Show AllDesktops");
        Assert.assertEquals(desktopPage.getDesktopText(), "Desktops", "incorrect name ");
    }


}
