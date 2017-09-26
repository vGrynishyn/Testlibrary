import oll.tv.pageobjects.LogInDialog;
import oll.tv.pageobjects.profile.CreditCardPaymentPage;
import oll.tv.pageobjects.profile.MyProfilePage;
import oll.tv.utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PaymentTest extends AbstractTest{

    private SoftAssert softAssert = new SoftAssert();

    @AfterMethod
    public void after(){
        Browser.closeBrowser();
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
                .setPayment(sumPayment);
        String setSum = new CreditCardPaymentPage().getPaymentSum();
        softAssert.assertEquals(setSum, sumPayment, "Verify ");
    }

}
