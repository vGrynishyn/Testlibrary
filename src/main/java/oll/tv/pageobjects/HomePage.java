package oll.tv.pageobjects;

import oll.tv.utils.Browser;
import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@class='scm-poster']")
    @CacheLookup
    private WebElement poster;
    @FindBy(className = "header-bottom no-border-bottom")
    @CacheLookup
    private WebElement headerBottom;

    public HomePage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }


    public HomePage openHomePage(String URL){
        Browser.openWebPage(URL);
        softAssert.assertTrue(logIn.isDisplayed(), "Verification home page load successfully.");
        return this;
    }
}