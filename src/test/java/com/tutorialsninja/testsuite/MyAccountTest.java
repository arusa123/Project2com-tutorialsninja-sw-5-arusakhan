package com.tutorialsninja.testsuite;


import com.tutorialsninja.customlistener.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {
    HomePage homePage;
    MyAccountPage myAccountPage;
    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.clickOnRegisterLink();
        Assert.assertEquals(myAccountPage.getTextForRegister(), "Register Account", "Incorrect");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnmyAccountLink();
        homePage.clickOnRegisterLink();
        registerPage.sendTextFirstNameField("Prime");
        registerPage.sendTextLastNameField("Testing");
        registerPage.sendTextEmailField("Prime");
        registerPage.sendTexTelephoneField("02089653876");
        registerPage.sendTextPasswordField("prime");
        registerPage.sendTextConfirmPasswordField("prime");
        registerPage.selectSubscribeButtons("Yes");
        registerPage.clickOnPrivacyButton();
        registerPage.clickOnContinueButton();
        Assert.assertEquals(registerPage.getAccountCreatedMessage(), "Your Account Has Been Created!");
        registerPage.clickOnContinueButtonAfterAccountCreation();
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.clickContinueButtonLogout();
        Assert.assertEquals(myAccountPage.getLogoutText(), "Account Logout");
        myAccountPage.clickOnLogOutButtonAfterAccountCreated();

    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnmyAccountLink();
        homePage.clickOnloginLink();
        Assert.assertEquals(myAccountPage.getLoginText(), "Returning Customer", "error");
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnmyAccountLink();
        homePage.clickOnloginLink();
        loginPage.sendTextToEmailAddressField("prime22@gmail.com");
        loginPage.sendTextToPasswordField("Prime123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(myAccountPage.getMyAccountText(), "My Account", "Error");
        myAccountPage.clickOnMyAccountLink();
        myAccountPage.clickContinueButtonLogout();
        Assert.assertEquals(myAccountPage.getLogoutText(), "Account Logout");
        registerPage.clickOnContinueButtonAfterAccountCreation();


    }
}