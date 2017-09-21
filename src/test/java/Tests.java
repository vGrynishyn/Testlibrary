
import oll.tv.pages.HomePage;
import oll.tv.utils.Browser;
import org.testng.annotations.Test;

public class Tests {

   // private HomePage homepage;

//    @BeforeMethod
//    public void initPageObjects() {
//        homepage = PageFactory.initElements(driver, HomePage.class);
//    }

    @Test
    public void openHomePageTest(){
        new HomePage().openHomePage("http://oll.tv");
        Browser.closeBrowser();
        //homepage.openHomePage("http://oll.tv");
        }
}
