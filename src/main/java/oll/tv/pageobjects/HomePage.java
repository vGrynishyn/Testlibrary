package oll.tv.pageobjects;

import oll.tv.utils.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@class='scm-poster']")
    @CacheLookup
    private WebElement poster;

    public HomePage openHomePage(String URL){
        Browser.openWebPage(URL);
        softAssert.assertTrue(poster.isDisplayed(), "Verification home page load successfully.");
        return this;
    }

    public boolean isPosterExists(){
        return poster.isDisplayed();
    }

}