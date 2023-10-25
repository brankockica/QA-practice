package automation.pom.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Properties properties;
    By logoutButton = By.cssSelector("[data-test='sidenav-signout']");
    By accountBalance = By.cssSelector("[data-test='sidenav-user-balance']");
    By newTransaction = By.cssSelector("[data-test='nav-top-new-transaction']");
    public HomePage (WebDriver driver, Properties properties, WebDriverWait wait){
        this.driver = driver;
        this.properties = properties;
        this.wait = wait;
    }
    public double readBalance (){
        return Double.parseDouble(driver.findElement(accountBalance).getText().replace("$", ""));
    }
    public void openNewTransaction() {
        driver.findElement(newTransaction).click();
    }
    public void logoutUser() {
        driver.findElement(logoutButton).click();
    }
    public void takeAScreenShot (String screenshotName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/main/java/automation/pom/" + screenshotName + ".png"));
    }
}
