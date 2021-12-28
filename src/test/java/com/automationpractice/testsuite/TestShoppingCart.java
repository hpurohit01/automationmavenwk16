package com.automationpractice.testsuite;

import com.automationpractice.pages.*;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestShoppingCart extends TestBase {
    DressesPage dressesPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    SummerDressesPage summerDressesPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        dressesPage = new DressesPage();
        homePage = new HomePage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        summerDressesPage = new SummerDressesPage();
    }




    @Test
    @Parameters({"menu", "product", "expectedMessage"})
    public void verifyIfUserIsAbleToEmptyTheShoppingCart(String menu, String product, String expectedMessage) throws InterruptedException {
        new HomePage().selectMenu(menu);
        new DressesPage().selectProduct(product);
        new ProductPage().clickOnAddToCartButton();
        new ProductPage().clickOnProceedToCheckoutButton();
        new ShoppingCartPage().verifyNumberOfProducts();
        Thread.sleep(2000);
        new ShoppingCartPage().verifyDeleteButtonIsAvailable();
        Thread.sleep(2000);
        new ShoppingCartPage().clickOnDeleteButton();
        Thread.sleep(3000);
        new ShoppingCartPage().verifyMessageOfShoppingCartIsEmpty(expectedMessage);
    }




}
