package locators;


import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class CheckoutLocators {
    public static final By Firstname_Field = MobileBy.accessibilityId("test-First Name");
    public static final By Lastname_Field = MobileBy.accessibilityId("test-Last Name");
    public static final By Zip_Field = MobileBy.accessibilityId("test-Zip/Postal Code");
    public static final By Continue_Button = MobileBy.accessibilityId("test-CONTINUE");
    public static final By Scroll3 = MobileBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"FINISH\"))"
    );

    public static final By Finish = MobileBy.accessibilityId("test-FINISH");
    public static final By AssertText = MobileBy.androidUIAutomator("new UiSelector().text(\"CHECKOUT: COMPLETE!\")");

}
