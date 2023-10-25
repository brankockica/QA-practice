package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.*;

public class AsertionTestTwo {
    WebDriver driver;
    WebDriverWait wait;
    Properties properties;

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
    @Test
    void bankAccounts () {
        WebElement bankAccButton = driver.findElement(By.cssSelector("[data-test='sidenav-bankaccounts']"));
        bankAccButton.click();
        List<WebElement> bAccountList = driver.findElements(By.cssSelector("[data-test='bankaccount-list']"));
        int numberOfAccount     =bAccountList.size();   // ZASTO nam prikazuje da je size 1, kad ima 6 elementa u listi
        System.out.println(numberOfAccount);
        assertEquals(numberOfAccount, 6);

    }
    @Test
    void deleteAccount () {
        WebElement bankAccButton = driver.findElement(By.cssSelector("[data-test='sidenav-bankaccounts']"));
        bankAccButton.click();
        WebElement bankAccDeleteButton = driver.findElement(By.xpath("//button[@data-test='bankaccount-delete'][1]"));
        //desava mi se ovde kod xpath selektora da kad hocu da izaberem [0] ili [1] posto ima dva elementa baguje i prikazuje samo na [1]
        //isto kao sto nam se desilo ono jednom na predavanju kad smo trazili u htmlu element. ZASTO
        assertTrue(bankAccDeleteButton.isEnabled());
    }
    @AfterTest
    void tearDown () {
        driver.quit();
    }

}
