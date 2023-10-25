package automation.pom.test;

import automation.pom.pages.BaseTest;
import automation.pom.pages.HomePage;
import automation.pom.pages.LoginPage;
import automation.pom.pages.TransactionPage;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.*;

public class PaymentTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    TransactionPage transactionPage;
    Double beforePayment;

    @BeforeTest
    void setupBrowser() throws IOException {
        this.setup();
        loginPage = new LoginPage(driver, properties);
        homePage = new HomePage(driver, properties, wait);
        transactionPage = new TransactionPage(driver, properties, wait);
    }
    @BeforeMethod
    void loginUser() {
        loginPage.loginUser();
    }
    @AfterMethod
    void logoutUser() {
        homePage.logoutUser();
    }
    @Test (priority = 0)
    void checkAccountBalanceAfterPayment () throws IOException {
        double beforePayment = homePage.readBalance();
        homePage.takeAScreenShot("balanceBeforePayment");
        transactionPage.makeAPayment();
        double afterPayment = homePage.readBalance();   //kako da iskoristimo ovde Double amount iz metode choseAmountForPayment (Double amount)
        homePage.takeAScreenShot("balanceAfterPayment");
        assertNotEquals(beforePayment, afterPayment);   //ili nekad nece da se updatuje, ili jednostavno updatuje veoma sporo
    }
    @Test (priority = 1)
    void checkAccountBalanceAfterRelog () throws IOException {
        double afterRelog = homePage.readBalance();
        homePage.takeAScreenShot("balanceAfterRelog");
        assertNotEquals(beforePayment, afterRelog);
    }
    @AfterTest
    void tearDown() {
        this.cleanUp();
    }
}
