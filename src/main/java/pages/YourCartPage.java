package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import locators.YourCartLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(YourCartLocators.Checkout));
        checkout.click();
    }
    public Boolean assert_Text3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartLocators.AssertText3));
        return element.isDisplayed();
    }
}
