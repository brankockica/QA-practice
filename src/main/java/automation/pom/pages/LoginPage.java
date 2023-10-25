package automation.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    Properties properties;
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton   = By.cssSelector("[data-test='signin-submit']");
    public LoginPage (WebDriver driver, Properties properties){
        this.driver = driver;
        this.properties = properties;
    }
    public void open (){
        driver.get(properties.getProperty("BASE_URL")+ "/signin");

    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public void loginUser() {
        this.open();
        driver.manage().window().maximize();
        this.enterUsername(properties.getProperty("USERNAME"));
        this.enterPassword(properties.getProperty("PASSWORD"));
        this.clickLoginButton();
    }
}
