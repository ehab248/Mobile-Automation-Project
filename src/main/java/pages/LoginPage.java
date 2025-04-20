package pages;


import base.BasePage;
import locators.LoginLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
       super(driver);
        this.driver = driver;
    }

    public void fill_Username_Field() {
        WebElement usernameField = driver.findElement(LoginLocators.Username_Field);
        usernameField.sendKeys("standard_user");
    }

    public void fill_Password_Field() {
        WebElement passwordField = driver.findElement(LoginLocators.Password_Field);
        passwordField.sendKeys("secret_sauce");
    }

    public void click_Login() {
        WebElement loginButton = driver.findElement(LoginLocators.Login_Button);
        loginButton.click();
    }
    public Boolean assert_Text1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.AssertText1));
        return element.isDisplayed();
    }

}
