package oll.tv.pageobjects.profile;

import oll.tv.pageobjects.BasePage;
import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardPaymentPage extends BasePage{

    private static final String CREDIT_CARD_FRAME = "b-frame";

    @FindBy(xpath = "//*[@class='c-payment-card__sum-text']/strong")
    private WebElement paymentSum;
    @FindBy(className = "c-payment-card__wrapper")
    private WebElement ccWrapper;


    public CreditCardPaymentPage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public boolean isExists(){
        return ccWrapper.isDisplayed();
    }


    public String getPaymentSum(){
        Driver.getWebDriver().switchTo().frame(CREDIT_CARD_FRAME);
        return paymentSum.getText();
    }


}
