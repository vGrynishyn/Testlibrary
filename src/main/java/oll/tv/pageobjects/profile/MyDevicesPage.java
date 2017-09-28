package oll.tv.pageobjects.profile;

import oll.tv.pageobjects.BasePage;
import oll.tv.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyDevicesPage extends BasePage {

    @FindBy(xpath = "//*[@class='user-device-name']")
    private List<WebElement> devices;

    public MyDevicesPage (){
        PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public List<WebElement> getDevicesList(){
        ArrayList<WebElement> list = new ArrayList<>();
        for (WebElement element : devices) {
            list.add(element);
        }
        return list;
    }

}
