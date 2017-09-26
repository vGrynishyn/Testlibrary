package oll.tv.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInDialog extends BasePage{

    @FindBy( id="AuthForm")
    private WebElement loginDialog;
    @FindBy(xpath = ".//*[@id='AuthForm_email']")
    private  WebElement userName;
    @FindBy(xpath = ".//*[@id='AuthForm_password']")
    private  WebElement password;
    @FindBy(xpath = ".//*[@id='AuthFormInput']/div[3]/input")
    private WebElement loginButton;
    @FindBy(className = "logged")
    private WebElement myOllTV;
    private static final String URL = "http://oll.tv";

    public boolean isLoginDialogDisplayed(){
        return loginDialog.isDisplayed();
    }

    public LogInDialog logIn(String user, String pass){
        new HomePage().openHomePage(URL)
                .openLoginDialog();
        userName.sendKeys(user);
        password.sendKeys(pass+ Keys.ENTER);
        return this;
    }

    public boolean isLoggedIn(){
        return myOllTV.isDisplayed();
    }
}