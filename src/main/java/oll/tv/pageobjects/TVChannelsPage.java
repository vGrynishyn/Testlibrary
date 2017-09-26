package oll.tv.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TVChannelsPage extends BasePage{


    @FindBy(xpath = "//*[@class='tv-chan b-channels-list']/li[@class='news']")
    private List<WebElement> tariffchsnnel;


    public List<WebElement> getAmountOfTariffchsnnels(){
        ArrayList<WebElement> chsnnelList = new ArrayList<>();
        for(WebElement element : tariffchsnnel)
            chsnnelList.add(element);
        return chsnnelList;
    }
}