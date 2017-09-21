package oll.tv.browser;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import oll.tv.utils.Driver.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {
    private WebDriver driver;

    public WebDriver getDriver(){
        return this.driver;
    }

    public Chrome(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(BrowserType.findByName(BrowserType.CHROME.getName()).getOptions());
        this.driver = new ChromeDriver(options);
    }
}
