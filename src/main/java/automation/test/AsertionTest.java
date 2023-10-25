package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static org.testng.Assert.*;

public class AsertionTest {
    WebDriver driver;
    WebDriverWait wait;

    Properties properties;
    double balanceAfterPaymentExpected;

    @BeforeTest
    void browserSetup () throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.get("https://app.qacademy.rs");
        properties = new Properties();
        FileInputStream configFile = new FileInputStream("src/main/config.properties");
        properties.load(configFile);

    }
    @BeforeMethod
    void loginUser() {
        driver.get(properties.getProperty("BASE_URL"));
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

        WebElement username     = driver.findElement(By.cssSelector("input[id='username']"));
        WebElement password     = driver.findElement(By.id("password"));
        WebElement signInButton = driver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys(properties.getProperty("USERNAME"));
        password.sendKeys(properties.getProperty("PASSWORD"));
        signInButton.click();
    }
    @AfterMethod
    void logoutUser() {
        WebElement logoutButton = driver.findElement(By.cssSelector("[data-test='sidenav-signout']"));
        logoutButton.click();
    }
    @Test (priority = 1, description = "Test should check the payment method using negative number")
    public void vezbaAssertion() throws InterruptedException, IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        WebElement myAccount    = driver.findElement(By.cssSelector("[data-test='sidenav-user-settings']"));
        String userSettingsLink  = myAccount.getAttribute("href");
        WebElement homeButton   = driver.findElement(By.cssSelector("[data-test='sidenav-home']"));
        assertTrue(homeButton.isDisplayed());
        File srcFile1 = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile1, new File("src/main/java/automation/beforePayment.png"));
        WebElement newTransaction   = driver.findElement(By.cssSelector("[data-test='nav-top-new-transaction']"));
        WebElement userBalance  = driver.findElement(By.cssSelector("[data-test='sidenav-user-balance']"));
        double balanceBeforePayment = Double.parseDouble(userBalance.getText().replace("$", ""));
        double paymentNegative      = -2;
        balanceAfterPaymentExpected  = balanceBeforePayment - paymentNegative;
        //Thread.sleep(4000);
        newTransaction.click();

        WebElement userToPay    = driver.findElement(By.xpath("//*[@data-test='users-list']/li[9]"));
        userToPay.click();

        WebElement amount       = driver.findElement(By.id("amount"));
        WebElement note         = driver.findElement(By.cssSelector("[placeholder='Add a note']"));
        WebElement pay          = driver.findElement(By.cssSelector("[data-test='transaction-create-submit-payment']"));
        assertFalse(pay.isEnabled());
        //amount.sendKeys(String.valueOf(paymentNegative));   // mora string da bude, pa vadimo value iz double-a
        amount.sendKeys("" + paymentNegative);   // moze i krace?
        note.sendKeys("AutoTest");
        pay.click();
        WebElement popUpSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MuiAlert-message")));
        assertTrue(popUpSuccess.isDisplayed());

        homeButton.click();
        myAccount.click();
        homeButton.click();

        driver.navigate().refresh();
        WebElement userBalance1  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='sidenav-user-balance']")));
        assertTrue(userBalance1.isDisplayed());
        File srcFile2 = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File("src/main/java/automation/afterPayment.png"));
        //double balanceAfterPaymentActual = Double.parseDouble(userBalance1.getText().replace("$", ""));
        //assertEquals(balanceAfterPaymentActual, balanceAfterPaymentExpected);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(userSettingsLink);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

        WebElement userBalance2  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='sidenav-user-balance']")));
        double balanceAfterPaymentActual = Double.parseDouble(userBalance2.getText().replace("$", ""));
        assertEquals(balanceAfterPaymentActual, balanceAfterPaymentExpected);
        //Desi se da failuje ovaj assert nekad, tipa kad ostane u drugom prozoru logovano ili kad se ne izloguje i zatvori prozor
        //Onda mora da se loguje ispocetka i izloguje, i test posle prolazi posle iz drugog puta?? i posle opet failuje
        //kao da mu ostaje nesto? ali ne bi trebalo zbog driver.quit()?
        //Cak sam mu stavio i novi loader sa za balance
        //Mozda mu getuje Text pre nego sto uspe da se promeni value posle paymenta? ***Proveri*** mozda da napravi screenshot?
        //Nece da updatuje value za userbalance posle paymenta nekad, proverio preko thread.sleep i screenshota
        //* *  *A sledeci put kad otvori nalog updatovano je * *  *
        //Nece da prodje ni u new tabu *** Istina je negde tamo ***

    }
    @Test (priority = 2, description = "Test should verify the success of payment")
    public void proveraBalance () throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        WebElement userBalance3  = driver.findElement(By.cssSelector("[data-test='sidenav-user-balance']"));
        double balanceAfterPaymentActual = Double.parseDouble(userBalance3.getText().replace("$", ""));
        File srcFile3 = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile3, new File("src/main/java/automation/balanceAfterLogin.png"));
        assertEquals(balanceAfterPaymentActual, balanceAfterPaymentExpected);
    }
    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
