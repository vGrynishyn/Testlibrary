package oll.tv.pageobjects;

import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TVChannelsPage extends BasePage{


    @FindBy(xpath = "//*[@class='tv-chan b-channels-list']/li[@class='news']")
    private List<WebElement> tariffchsnnel;

    public TVChannelsPage(){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public List<WebElement> getAmountOfTariffchsnnels(){
        ArrayList<WebElement> chsnnelList = new ArrayList<>();
        for(WebElement element : tariffchsnnel)
            chsnnelList.add(element);
        return chsnnelList;
    }
}