import oll.tv.pageobjects.LogInDialog;
//import CreditCardPaymentPage;
import oll.tv.pageobjects.profile.CreditCardPaymentPage;
import oll.tv.pageobjects.profile.MyDevicesPage;
import oll.tv.pageobjects.profile.MyProfilePage;
import oll.tv.utils.Browser;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PaymentTest extends AbstractTest{

    private SoftAssert softAssert = new SoftAssert();

    @AfterMethod
    public void after(){
        Browser.closeBrowser();
        softAssert.assertAll();
    }

    /*
    [TestLink] OL001-9:Check insert pay sum and sum on CreditCard Page
    */
    @Test
    @Parameters({"sumPayment"})
    public void checkInsertPaySumAndSumOnCCPage(@Optional("100") String sumPayment){
        new LogInDialog().logIn(USER_NAME, PASS);
        new MyProfilePage()
                .goToProfile()
                .goToProfile()
                .setPayment(sumPayment);
        String setSum = new CreditCardPaymentPage().getPaymentSum();
        softAssert.assertEquals(setSum, sumPayment, "Verify payment sum");
    }

}
