import oll.tv.pageobjects.LogInDialog;
import oll.tv.pageobjects.profile.MyProfilePage;
import oll.tv.pageobjects.TVChannelsPage;
import oll.tv.utils.Browser;
import oll.tv.utils.LogInformation;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.xml.dom.ParentSetter;

public class ProfileTests extends AbstractTest{

    private SoftAssert softAssert = new SoftAssert();

    private static final String TARIFF_NAME = "Эфир";
    private static final String AMOUNT_MORE = "Максимальная сумма - 2500 грн";
    private static final String AMOUNT_LESS = "Минимальная сумма - 20 грн";
    private static final String HINT_COLOR = "rgb(255, 79, 0)";


    @AfterMethod
    public void after(){
        Browser.closeBrowser();
    }

   /*
  [TestLink] OL001-6:Check amount of chsnnels in profile and tariffs
    */
    @Test
    public void checkAmountOfchsnnelsInProfileAndTariffsTest(){
        LogInformation.info("//------------Start checkAmountOfchsnnelsInProfileAndTariffsTest");
        new LogInDialog().logIn(USER_NAME, PASS);
        String tariffName = new MyProfilePage()
                                    .goToProfile()
                                    .getSubscribtionType();
        int numOfTariffchsnnels = new TVChannelsPage()
                                        .getAmountOfTariffchsnnels()
                                        .size();
        softAssert.assertEquals(tariffName, TARIFF_NAME, "Verify expected teriff name.");
        softAssert.assertEquals(numOfTariffchsnnels, 48, "Verify expected number of chsnnels.");
        LogInformation.info("//------------Finished checkAmountOfchsnnelsInProfileAndTariffsTest");
        softAssert.assertAll();
    }

    /*
    [TestLink] OL001-7:Payment more than ₴2500
     */
    @Test
    @Parameters({"sumPayment"})
    public void paymentMoreThan2500Test(@Optional("2550") String sumPayment){
        new LogInDialog().logIn(USER_NAME, PASS);
        String hintMessage = new MyProfilePage()
                                    .goToProfile()
                                    .setPayment(sumPayment)
                                    .getErrorMessageHint();
        String hintColor = new MyProfilePage().getErrorMessageHintColor();
        softAssert.assertEquals(hintMessage, AMOUNT_MORE, "Verify expected error message if payment sum more than 2500");
        softAssert.assertEquals(hintColor , HINT_COLOR , "Verify hint color");
        softAssert.assertAll();
    }

    /*
[TestLink] OL001-8:Payment less than ₴20
 */
    @Test
    @Parameters({"sumPayment"})
    public void paymentLessThan20Test(@Optional("10") String sumPayment){
        new LogInDialog().logIn(USER_NAME, PASS);
        String hintMessage = new MyProfilePage()
                                .goToProfile()
                                .setPayment(sumPayment)
                                .getErrorMessageHint();
        String hintColor = new MyProfilePage().getErrorMessageHintColor();
        softAssert.assertEquals(hintMessage, AMOUNT_LESS, "Verify expected error message if payment sum less than 20");
        softAssert.assertEquals(hintColor , HINT_COLOR , "Verify hint color");
        softAssert.assertAll();
    }

}
