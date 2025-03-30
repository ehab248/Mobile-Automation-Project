package pages;


import base.BasePage;
import locators.HomePageLocators;
import locators.LoginLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void click_AddToCart1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCart1 = driver.findElement(HomePageLocators.Add_To_Cart1);
        addToCart1.click();
    }

    public void scroll_Down() {
     driver.findElement(HomePageLocators.Scroll);
}

    public void click_AddToCart2() {
        WebElement addToCart2 = driver.findElement(HomePageLocators.Add_To_Cart2);
        addToCart2.click();
    }
    public void click_YourCart() {
      WebElement yourCart = driver.findElement(HomePageLocators.Your_Cart);
      yourCart.click();
    }
}

