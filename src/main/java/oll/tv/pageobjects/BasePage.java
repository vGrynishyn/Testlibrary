package oll.tv.pageobjects;


import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public abstract class BasePage {

    @FindBy(className = "news")
    @CacheLookup
    protected WebElement newsAndPromotion;
    @FindBy(xpath = "//*[@class=\"price\"]/a")
    @CacheLookup
    protected WebElement tariffs;
    @FindBy(className = "login_g")
    @CacheLookup
    protected WebElement logIn;



    protected SoftAssert softAssert = new SoftAssert();

    public BasePage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public void clickNewsAndPromotion(){
        newsAndPromotion.click();
    }

    public void clickTariffs(){
        tariffs.click();
    }

    public void clickLogIn(){
        logIn.click();
    }
}