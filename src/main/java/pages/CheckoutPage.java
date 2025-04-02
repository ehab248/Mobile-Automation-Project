package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import locators.CheckoutLocators;
import locators.HomePageLocators;
import locators.LoginLocators;
import locators.YourCartLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    private AndroidDriver driver;

    public CheckoutPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void fill_FirstName() {
        WebElement firstnameField = driver.findElement(CheckoutLocators.Firstname_Field);
        firstnameField.sendKeys("Ehab");
    }

    public void fill_LastName() {
        WebElement lastnameField = driver.findElement(CheckoutLocators.Lastname_Field);
        lastnameField.sendKeys("Hussein");
    }
    public void fill_Zip() {
        WebElement zipField = driver.findElement(CheckoutLocators.Zip_Field);
        zipField.sendKeys("2455");
    }

    public void click_Continue() {
        WebElement continueButton = driver.findElement(CheckoutLocators.Continue_Button);
        continueButton.click();
    }
    public void scroll_Down3() {
        driver.findElement(CheckoutLocators.Scroll3);
    }
    public void click_Finish() {
        WebElement finish = driver.findElement(CheckoutLocators.Finish);
        finish.click();
    }
    public Boolean assert_Text4() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.AssertText4));
        return element.isDisplayed();

    }
}