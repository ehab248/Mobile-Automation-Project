package locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class YourCartLocators {

    public static final By Scroll2 = MobileBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"CHECKOUT\"))"
    );

    public static final By Checkout = MobileBy.accessibilityId("test-CHECKOUT");
    public static final By AssertText = MobileBy.androidUIAutomator("new UiSelector().text(\"CHECKOUT: INFORMATION\")");


}