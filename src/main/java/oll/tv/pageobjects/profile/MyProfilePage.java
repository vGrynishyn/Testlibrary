package oll.tv.pageobjects.profile;

import oll.tv.pageobjects.BasePage;
import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BasePage {

    @FindBy(className = "logged")
    private WebElement myOllTV;
    @FindBy(xpath = "//*/a[@href=\"/auth/logout\"]")
    private WebElement logOut;
    @FindBy(xpath = "//*[@class='right centered-right']//*/a[@href='/account/subs']")
    private WebElement subscription;
    @FindBy(xpath = "//*[@class='right centered-right']//*/a[@href='/account/devices']")
    private WebElement myDevices;
    @FindBy(xpath = "//*[@class='b-purchase']//*/a[contains(@href,'/pack/')]/span")
    private WebElement purchasedTariff;
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

    public MyProfilePage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public MyProfilePage goToProfile(){
        myOllTV.click();
        return this;
    }

    public MyProfilePage goToMyDevices(){
        myDevices.click();
        return this;
    }

    public void logOut(){
        logOut.click();
    }

    public String getSubscribtionType(){
        subscription.click();
        String subscription = purchasedTariff.getText();
        purchasedTariff.click();
        return subscription;
    }

    public MyProfilePage setPayment(String sum){
        buttonRefill.click();
        sumField.clear();
        sumField.sendKeys(sum);
        submitPayment.click();
        return this;
    }

    public String getErrorMessageHint(){
        return errorHint.getText();
    }

    public String getErrorMessageHintColor(){
        return errorHint.getCssValue("color");
    }

}
