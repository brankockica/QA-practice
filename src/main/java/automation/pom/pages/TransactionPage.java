package automation.pom.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class TransactionPage {
    WebDriver driver;
    Properties properties;
    WebDriverWait wait;
    By paymentTarget = By.xpath("//*[@data-test='users-list']/li[9]");
    By amountField  = By.id("amount");
    By noteField    = By.cssSelector("[placeholder='Add a note']");
    By payButton    = By.cssSelector("[data-test='transaction-create-submit-payment']");
    By successWindow = By.className("MuiAlert-message");
    Double amount;

    public TransactionPage(WebDriver driver, Properties properties, WebDriverWait wait) {
        this.driver = driver;
        this.properties = properties;
        this.wait = wait;
    }
    public void open() {
        driver.get(properties.getProperty("BASE_URL")+ "/transaction/new");
    }
    public void choseUserForPayment () {
        driver.findElement(paymentTarget).click();
    }
    public void choseAmountForPayment (Double amount) {
        driver.findElement(amountField).sendKeys("" + amount);
    }
    public void writeNote (String note) {
        driver.findElement(noteField).sendKeys(note);
    }
    public void clickPay() {
        driver.findElement(payButton).click();
    }
    public void checkForPaymentSuccess () {
        WebElement popUpGreen = wait.until(ExpectedConditions.visibilityOfElementLocated(successWindow));
        assertTrue(popUpGreen.isDisplayed());
    }

    public void makeAPayment() {
        this.open();
        this.choseUserForPayment();
        this.choseAmountForPayment(-3.0);
        this.writeNote("Pom Test");
        this.clickPay();
        this.checkForPaymentSuccess();
    }
}
