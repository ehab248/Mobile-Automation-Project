package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import locators.CheckoutLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    private AndroidDriver driver;
    WebDriverWait wait;
    public CheckoutPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;

        if (driver == null) {
            throw new IllegalArgumentException("Driver is null in CheckoutPage constructor!");
        }

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void fill_FirstName() {
        WebElement firstnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Firstname_Field));
        firstnameField.sendKeys("Ehab");
    }

    public void fill_LastName() {
        WebElement lastnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Lastname_Field));
        lastnameField.sendKeys("Hussein");
    }

    public void fill_Zip() {
        WebElement zipField = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Zip_Field));
        zipField.sendKeys("2455");
    }

    public void click_Continue() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.Continue_Button));
        continueButton.click();
    }

    public void scroll_Down3() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Scroll3));
    }

    public void click_Finish() {
        WebElement finish = wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.Finish));
        finish.click();
    }

    public Boolean assert_Text4() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.AssertText4));
        return element.isDisplayed();


    }
    public double assert_Price1() {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Price1));
        String price1Text = element.getText();


        String Price1_value = price1Text.replace("$", "");

        double price1Value = Double.parseDouble(Price1_value);

        return price1Value;
    }
    public double assert_Price2() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Price2));
        String price2Text = element.getText();


        String Price2_value = price2Text.replace("$", "");

        double price2Value = Double.parseDouble(Price2_value);

        return price2Value;
    }

    public double assert_TotPrice() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Total_Price));
        String Totprice = element.getText();


        String TotPrice_value = Totprice.replace("Item total: $", "");

        return Double.parseDouble(TotPrice_value);
    }
    public double assert_Tax() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutLocators.Tax));
        String Tax = element.getText();


        String Tax_value = Tax.replace("Tax: $", "");

        return Double.parseDouble(Tax_value);
    }

    public void clickBackHome() {
        WebElement backHomeButton = wait.until(ExpectedConditions.elementToBeClickable(CheckoutLocators.backHome));
        backHomeButton.click();
    }
}