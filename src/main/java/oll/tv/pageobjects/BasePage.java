package oll.tv.pageobjects;


import oll.tv.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public abstract class BasePage {


    private WebDriver webDriver;

    @FindBy(className = "news")
    @CacheLookup
    protected WebElement newsAndPromotion;
    @FindBy(xpath = "//*[@class=\"price\"]/a")
    @CacheLookup
    protected WebElement tariffs;
    @FindBy(className = "login_g")
    @CacheLookup
    protected WebElement logIn;
    @FindBy(xpath = "//*[@class='container-inner']//*[@class='item1']")
    @CacheLookup
    private List<WebElement> headerItems;

    protected SoftAssert softAssert = new SoftAssert();



    public BasePage(){
       PageFactory.initElements(Driver.getWebDriver(), this);
    }

    public boolean isLogInButtonExists(){
        return logIn.isDisplayed();
    }

    public List<WebElement> getHeaderLinks(){
        ArrayList<WebElement> item = new ArrayList();
        for (WebElement element : headerItems) {
            item.add(element);
        }
        return item;
    }

    public List<String> getHeadersItemsTest(){
        ArrayList<String> item = new ArrayList();
        for (WebElement element : headerItems) {
            item.add(element.getText());
        }
        return item;
    }

    public void clickNewsAndPromotion(){
        newsAndPromotion.click();
    }

    public void clickTariffs(){
        tariffs.click();
    }

    public void openLoginDialog(){
        logIn.click();
    }

    public WebElement find(By first, By... rest) {
        WebElement element = webDriver.findElement(first);
        for (By b : rest) {
            element = element.findElement(b);
        }
        return element;
    }
}