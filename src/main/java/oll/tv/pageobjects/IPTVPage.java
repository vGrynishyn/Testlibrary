package oll.tv.pageobjects;

import oll.tv.utils.Browser;
import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class IPTVPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"b-channel-div b-item-clicks-stat chan-chan\"]")
    @CacheLookup
    private List<WebElement> tvChannelList;
    @FindBy(xpath = "//*[@class='pp-content']//*[@class='pp-but-big']")
    @CacheLookup
    private WebElement buySubscriptionButton;

    public IPTVPage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public IPTVPage openTVChannelPage(String URL){
        Browser.openWebPage(URL);
        getHeaderLinks().get(1).click();
        return this;
    }

    public List<WebElement> getListOfChannelsLinks(){
        ArrayList<WebElement> channelList = new ArrayList();
        for (WebElement element : tvChannelList) {
            channelList.add(element);
        }
        return channelList;
    }

    public boolean isSubscriptionButtonExists(){
        return buySubscriptionButton.isDisplayed();
    }
}
