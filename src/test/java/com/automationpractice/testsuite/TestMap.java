package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.OurStoresPage;
import com.automationpractice.testbase.TestBase;
import com.automationpractice.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestMap extends TestBase {
    HomePage homePage;
    OurStoresPage ourStoresPage;

    @BeforeMethod(alwaysRun = true)
    public void initialisation() {
        homePage = new HomePage();
        ourStoresPage = new OurStoresPage();
    }


    @Test
    @Parameters({"infoLink"})
    public void verifyUserIsAbleToDragMapAndTakeScreenshot(String infoLink) throws IOException, InterruptedException {

        new HomePage().selectInformation(infoLink);
        new OurStoresPage().clickOKFromAlert();
        Thread.sleep(3000);
        Utility.takeScreenShot();
    }

}
