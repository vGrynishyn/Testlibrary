package oll.tv.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//*[@class=\'cont-news-list left-col\']/h1" )
    private WebElement newsHeader;

    public boolean isHeaderExists() {
        return newsHeader.isDisplayed();
    }
}