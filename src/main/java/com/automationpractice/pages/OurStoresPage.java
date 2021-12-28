package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OurStoresPage extends Utility {
    public OurStoresPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okButton;

    //@CacheLookup
    @FindBy(css = "#map")
    WebElement mapArea;

    @FindBy(xpath = "//div[@id='map']")
    WebElement mapAreaByXpath;

    public void clickOKFromAlert() {
        if (okButton.isDisplayed()) {
            doClickOnElement(okButton);
        }
    }
}