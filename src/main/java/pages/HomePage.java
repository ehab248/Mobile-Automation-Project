package pages;


import base.BasePage;
import locators.HomePageLocators;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        WebElement addToCart1 = wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.Add_To_Cart1));
        addToCart1.click();
    }

    public void scroll_Down() {
        driver.findElement(HomePageLocators.Scroll);
    }

    public void click_AddToCart2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCart2 = wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.Add_To_Cart2));
        addToCart2.click();
    }
    public void click_YourCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement yourCart = wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.Your_Cart));
        yourCart.click();
    }

    public Boolean assert_Text2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.AssertText2));
      return element.isDisplayed();

    }
    public void clickSort() {

        WebElement sort = driver.findElement(HomePageLocators.sortIcon);
        sort.click();
    }
    public void click_Z2A() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.From_Z2A));
        WebElement z2a = driver.findElement(HomePageLocators.From_Z2A);
        z2a.click();
    }
    public void click_A2Z() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.From_A2Z));
        WebElement a2z = driver.findElement(HomePageLocators.From_A2Z);
        a2z.click();
    }
    public void click_High2Low () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.From_High2Low));
        WebElement h2l = driver.findElement(HomePageLocators.From_High2Low);
        h2l.click();
    }
    public void click_Low2High () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.From_Low2High));
        WebElement l2h = driver.findElement(HomePageLocators.From_Low2High);
        l2h.click();
    }




    public boolean compareNames() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.FirstElementTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.SecondElementTitle));

        String firstText = driver.findElement(HomePageLocators.FirstElementTitle).getText().trim();
        String secondText = driver.findElement(HomePageLocators.SecondElementTitle).getText().trim();
        return firstText.compareToIgnoreCase(secondText) >= 0;
    }
    public boolean comparePrices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.FirstElementPrice));
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.SecondElementPrice));

        String firstText = driver.findElement(HomePageLocators.FirstElementPrice).getText().trim().replaceFirst("$","");
        String secondText = driver.findElement(HomePageLocators.SecondElementPrice).getText().trim().replaceFirst("$","");
        return firstText.compareToIgnoreCase(secondText) >= 0;
    }




}

