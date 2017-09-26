
import oll.tv.pageobjects.*;
import oll.tv.utils.Browser;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FunctionalityTests extends AbstractTest {

    private SoftAssert softAssert = new SoftAssert();


    private Collection<String> ExpectedItemNames =  Arrays.asList("Телеканалы", "Фильмы","Премиум Кино","Сериалы","Программы","Детям","Футбол LIVE","Футбол Лучшее","Музыка","Радио");

//    @BeforeMethod
//    public void before(){
//        Browser.openWebPage(URL);
//    }


    @AfterMethod
    public void after(){
        Browser.closeBrowser();
    }

    /*
    [TestLink]  OL001-1:Checking loading Home Page
     */
    @Test
    public void openHomePageTest(){
        boolean isPosterExists = new HomePage().openHomePage(URL)
                .isPosterExists();
        softAssert.assertTrue(isPosterExists, "Verification home page load successfully.");
    }

    /*
    [TestLink]  OL001-2:Check top header link surf correctly
    */
    @Test
    public void checkHeaderLinksTest(){
        new HomePage().openHomePage(URL)
                .clickNewsAndPromotion();
        softAssert.assertTrue(new NewsPage().isHeaderExists(), "Verify news and promotions load successfully.");
        new NewsPage().clickTariffs();
        softAssert.assertTrue(new TariffsPage().isTariffsHeaderExists(), "Verify tariffs load successfully.");
        new TariffsPage().openLoginDialog();
        softAssert.assertTrue(new TariffsPage().isLoginDialogDisplayed(), "Verify logIn load successfully.");
    }

    /*
    [TestLink] OL001-3:Log In test
    */
    @Test
    public void logInTest(){
        boolean isLoggedIn = new LogInDialog().logIn(USER_NAME, PASS)
                .isLoggedIn();
        softAssert.assertTrue(isLoggedIn);
    }

    /*
    [TestLink] OL001-4:Check bottom header has correct amount of links
    */
    @Test
    public void checkHeaderItemsTest(){
        List<String> headerItems = new HomePage()
                .openHomePage(URL)
                .getHeadersItemsTest();
        softAssert.assertEquals(headerItems.size(), ExpectedItemNames.size(), "Verify amount of header itens");
        softAssert.assertTrue(headerItems.containsAll(ExpectedItemNames), "Verify names of header itens");
    }

    /*
     [TestLink] OL001-5: Try to play video without login
    */
    @Test
    public void tryToPlayVideoWithoutLoginTest(){
        new IPTVPage().openTVChannelPage(URL)
                .getListOfChannelsLinks()
                .get(1)
                .click();
        softAssert.assertTrue(new IPTVPage().isSubscriptionButtonExists(), "Verifying that user should have subscriptions to watch ipChanels");
    }
}
