package com.automationpractice.testsuite;

import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAccountCreation extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void initialisation(){
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        myAccountPage = new MyAccountPage();
    }


    @Test
    @Parameters({"firstName", "lastName", "password", "address", "city", "state", "postal", "country", "phone"})
    public void verifyIfUserIsAbleToCreateAccountSuccessfully(String firstName, String lastName, String password,
                                                              String address, String city, String state, String postal,
                                                              String country, String phone) {
        new HomePage().clickOnSignInLink();
        new SignInPage().fillInEmailToCreateAccount();
        new SignInPage().clickOnCreateAccountButton();
        new CreateAccountPage().enterYourFirstName(firstName);
        new CreateAccountPage().enterYourLastName(lastName);
        new CreateAccountPage().enterYourPassword(password);
        new CreateAccountPage().enterYourAddress(address);
        new CreateAccountPage().enterYourCity(city);
        new CreateAccountPage().selectYourState(state);
        new CreateAccountPage().enterYourPostalCode(postal);
        new CreateAccountPage().selectYourCountry(country);
        new CreateAccountPage().selectYourState(state);
        new CreateAccountPage().enterYourPhoneNumber(phone);
        new CreateAccountPage().clickOnRegisterButton();
        new MyAccountPage().verifyAccountNameText(firstName);
    }

}
