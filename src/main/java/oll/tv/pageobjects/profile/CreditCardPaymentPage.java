package oll.tv.pageobjects.profile;

import oll.tv.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardPaymentPage extends BasePage {

    @FindBy(className = "c-payment-card__sum-text")
    private WebElement paymentSum;

    public String getPaymentSum(){
        return paymentSum.getText();
    }


}
