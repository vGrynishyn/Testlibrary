package oll.tv.pages;


import oll.tv.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }
}
