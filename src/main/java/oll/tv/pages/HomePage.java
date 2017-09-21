package oll.tv.pages;

import oll.tv.utils.Browser;
import oll.tv.utils.LogInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@class='scm-poster']")
    @CacheLookup
    private WebElement poster;

    public HomePage openHomePage(String URL){
        Browser.openWebPage(URL);
        if(!poster.isDisplayed()){
            LogInformation.error(String.format("Web page %s has not been loaded.", URL));
        }
        return this;
    }
}
