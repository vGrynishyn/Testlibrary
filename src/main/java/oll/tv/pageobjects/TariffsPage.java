package oll.tv.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TariffsPage extends BasePage {

    @FindBy (xpath = "//*[@class=\"heading\"]/h1")
    private WebElement tariffsHeader;
    @FindBy( id="AuthForm")
    @CacheLookup
    private WebElement loginDialog;


    public boolean isTariffsHeaderExists(){
        return tariffsHeader.isDisplayed();
    }

    public boolean isLoginDialogDisplayed(){
        return loginDialog.isDisplayed();
    }
}