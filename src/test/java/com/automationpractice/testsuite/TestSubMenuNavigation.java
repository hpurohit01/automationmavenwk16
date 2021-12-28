package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SummerDressesPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSubMenuNavigation extends TestBase {

    HomePage homePage;
    SummerDressesPage summerDressesPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        summerDressesPage = new SummerDressesPage();
    }



    @Test
    @Parameters({"menu","subMenu","expectedText"})
    public void verifyIfUserIsAbleToNavigateToSummerDressesOptionAndIsAbleToViewItemFromTheSummerCollection(String menu, String subMenu, String expectedText){

        new HomePage().hoverMouseToMenu(menu);
        new HomePage().hoverMouseAndClickOnSubMenu(subMenu);
        new SummerDressesPage().verifyHeadingText(expectedText);
    }


    @Test
    @Parameters({"menu", "subMenu", "expectedText", "setMaxPrice"})
    public void verifyIfUserIsAbleToFilterPriceChangeAndSeeTheChangeInSearchResults(String menu, String subMenu, String expectedText, String setMaxPrice) {
        new HomePage().hoverMouseToMenu(menu);
        new HomePage().hoverMouseAndClickOnSubMenu(subMenu);
        new SummerDressesPage().verifyHeadingText(expectedText);
        new SummerDressesPage().setSliderPriceTo(setMaxPrice);
        new SummerDressesPage().verifyIfListedProductsAreWithInSelectedPriceRange(setMaxPrice);
    }
}
