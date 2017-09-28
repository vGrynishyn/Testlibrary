package oll.tv.pageobjects;

import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TariffsPage extends BasePage {

    @FindBy (xpath = "//*[@class=\"heading\"]/h1")
    private WebElement tariffsHeader;
    @FindBy( id="AuthForm")
    @CacheLookup
    private WebElement loginDialog;

    public TariffsPage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public boolean isTariffsHeaderExists(){
        return tariffsHeader.isDisplayed();
    }

    public boolean isLoginDialogDisplayed(){
        return loginDialog.isDisplayed();
    }
}