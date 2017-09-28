package oll.tv.pageobjects;

import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//*[@class=\'cont-news-list left-col\']/h1" )
    private WebElement newsHeader;

    public NewsPage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public boolean isHeaderExists() {
        return newsHeader.isDisplayed();
    }
}