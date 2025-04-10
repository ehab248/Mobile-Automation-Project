package locators;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomePageLocators {


    public static final By Add_To_Cart1 = MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    public static final By Scroll = MobileBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"© 2025 Sauce Labs. All Rights Reserved.\"))"
    );
    public static final By sortIcon = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)");
    public static final By From_Z2A = AppiumBy.androidUIAutomator("new UiSelector().text(\"Name (Z to A)\")");
    public static final By From_A2Z = AppiumBy.androidUIAutomator("new UiSelector().text(\"Name (A to Z)\")");
    public static final By From_High2Low = AppiumBy.androidUIAutomator("new UiSelector().text(\"Price (high to low)\")");
    public static final By From_Low2High = AppiumBy.androidUIAutomator("new UiSelector().text(\"Price (low to high)\")");

    public static final By Add_To_Cart2 = MobileBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")");
    public static final By Your_Cart = MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
    public static final By AssertText2 = MobileBy.androidUIAutomator("new UiSelector().text(\"YOUR CART\")");

    public static final By FirstElementTitle = AppiumBy.xpath("((//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]//android.widget.TextView[@content-desc=\"test-Item title\"])");
    public static final By SecondElementTitle = AppiumBy.xpath("((//android.view.ViewGroup[@content-desc=\"test-Item\"])[2]//android.widget.TextView[@content-desc=\"test-Item title\"])");
    public static final By FirstElementPrice = AppiumBy.xpath("((//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]//android.widget.TextView[@content-desc=\"test-Price\"])");
    public static final By SecondElementPrice = AppiumBy.xpath("((//android.view.ViewGroup[@content-desc=\"test-Item\"])[2]//android.widget.TextView[@content-desc=\"test-Price\"])");

}
