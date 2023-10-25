package automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
        driver = new ChromeDriver(options);
        //driver.get("https://app.qacademy.rs");
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @Test
    void testMultiXpath() throws InterruptedException {
        driver.get("https://app.qacademy.rs");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        List<WebElement> inputPolja = driver.findElements(By.xpath("//input"));
        for(int i=1; i <= inputPolja.size(); i++) {
            switch (i) {
                case 1 -> inputPolja.get(0).sendKeys("Username");
                case 2 -> inputPolja.get(1).sendKeys("123456");
                case 3 -> inputPolja.get(2).click();
                default -> {
                    }
            }
        }
        Thread.sleep(10000);
    }

    @Test
    void testSelectori() throws InterruptedException {
        driver.get("https://app.qacademy.rs");
        WebElement username     = driver.findElement(By.cssSelector("input[id='username']"));
        WebElement password     = driver.findElement(By.id("password"));
        //WebElement cbRemember = driver.findElement(By.className(".jss76"));   //class atribut se ovde pravi dinamicki za svaku iteraciju!
        WebElement cbRemember   = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement signIn       = driver.findElement(By.xpath("//button[@type='submit']"));

        username.sendKeys("brane");
        password.sendKeys("qwerty");
        cbRemember.click();
        signIn.click();
        WebElement newTransaction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='sidenav-toggle']/following-sibling::a")));
        newTransaction.click();
        WebElement user         = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='users-list']/li[9]")));
        user.click();
        WebElement amount       = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
        amount.sendKeys("-100");
        WebElement note         = driver.findElement(By.cssSelector("input[placeholder='Add a note']"));
        note.sendKeys("AutoTest");
        WebElement pay          = driver.findElement(By.cssSelector("button[data-test='transaction-create-submit-payment']"));
        pay.click();
        WebElement success      = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='MuiAlert-message']")));
        //Kako da pauziramo ovaj zeleni pop-up window u html, kad ga inspektujem izgubi se posle sekunde, i posle ga tretira kao invisible??



        Thread.sleep(5000);
    }
    @Test
    void testDomaci1() throws InterruptedException {
        driver.get("https://www.blic.rs/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        WebElement blicLink = driver.findElement(By.partialLinkText("postigli dogovor sa Fordom: Štrajka neće biti"));
        action.moveToElement(blicLink).perform();
        //Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, 500);");
        js.executeScript("window.scrollBy(0, -5800);");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        action.sendKeys(Keys.LEFT_CONTROL + "t" + Keys.LEFT_CONTROL + "t").perform();   //nece da napravi novi tab u browseru??
        action.sendKeys(Keys.LEFT_CONTROL + "w").perform();

        Thread.sleep(5000);



    }
    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
