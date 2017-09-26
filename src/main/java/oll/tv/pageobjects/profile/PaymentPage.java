package oll.tv.pageobjects.profile;

import oll.tv.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(className = "profile-page b-profile-page ")       // //*[@class='profile-page b-profile-page ']
    private WebElement paymentPage;
    @FindBy(xpath = "//*[@class='logo-pay-carta']/../../td[@class='pay-section']//button[@class='b-pay-recharge']")
    private WebElement buttonRefill;
    @FindBy(xpath = "//*[@class='logo-pay-carta']/../../td[@class='pay-section']//*[@class='summ b-pay-summ']/input")
    private WebElement sumField;
    @FindBy(xpath = "//*[@class='logo-pay-carta']/../../td[@class='pay-section']//*[@class='active']/button[@class='submit b-payment-provider b-new-card']")
    private WebElement submitPayment;
    @FindBy(xpath = "//*[@class='logo-pay-carta']/../../td[@class='pay-section']//*[@class='under-summ-input-txt b-error-txt error-txt']")
    private WebElement errorHint;

    public void setPayment(String sum){
        buttonRefill.click();
        sumField.sendKeys(sum);
        submitPayment.click();
    }

    public String getErrorMessageHint(){
        return errorHint.getText();
    }


}
