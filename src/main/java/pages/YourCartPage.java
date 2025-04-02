package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import locators.HomePageLocators;
import locators.LoginLocators;
import locators.YourCartLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage extends BasePage {
    private AndroidDriver driver;

    public YourCartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void scroll_Down2() {
        driver.findElement(YourCartLocators.Scroll2);
    }
    public void click_Checkout() {
        WebElement checkout = driver.findElement(YourCartLocators.Checkout);
        checkout.click();
    }
    public Boolean assert_Text() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver.findElement(LoginLocators.AssertText).isDisplayed();

    }
}
