
import oll.tv.pageobjects.HomePage;
import oll.tv.pageobjects.NewsPage;
import oll.tv.pageobjects.TariffsPage;
import oll.tv.pageobjects.LogInDialog;
import oll.tv.utils.Browser;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Tests {

    private SoftAssert softAssert = new SoftAssert();
    private static final String URL = "http://oll.tv";
    private static final String USER_NAME = "vgrinishin@gmail.com";
    private static final String PASS = "V7020233";

//    @BeforeMethod
//    public void before(){
//        Browser.openWebPage(URL);
//    }

    @AfterMethod
    public void after(){
        Browser.closeBrowser();
    }

    @Test
    public void openHomePageTest(){
        boolean b = new HomePage().openHomePage(URL)
                .isPosterExists();
        softAssert.assertTrue(b, "Verification home page load successfully.");
    }

    @Test
    public void checkHeaderLinksTest(){
        new HomePage().openHomePage(URL)
                .clickNewsAndPromotion();
        softAssert.assertTrue(new NewsPage().isHeaderExists(), "Verify news and promotions load successfully.");
        new NewsPage().clickTariffs();
        softAssert.assertTrue(new TariffsPage().isTariffsHeaderExists(), "Verify tariffs load successfully.");
        new TariffsPage().clickLogIn();
        softAssert.assertTrue(new TariffsPage().isLoginDialogDisplayed(), "Verify logIn load successfully.");
    }

    @Test
    public void logInTest(){
        boolean b = new LogInDialog().logIn(USER_NAME, PASS)
                .isLoggedIn();
        softAssert.assertTrue(b);
    }
}
