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
    public static final By Price1 = MobileBy.androidUIAutomator("new UiSelector().text(\"$29.99\")");
    public static final By Price2 = MobileBy.androidUIAutomator("new UiSelector().text(\"$7.99\")");
    public static final By Total_Price = MobileBy.androidUIAutomator("new UiSelector().text(\"Item total: $37.98\")");
    public static final By Tax = MobileBy.androidUIAutomator("new UiSelector().text(\"Tax: $3.04\")");


    public static final By Finish = MobileBy.accessibilityId("test-FINISH");
    public static final By AssertText4 = MobileBy.androidUIAutomator("new UiSelector().text(\"CHECKOUT: COMPLETE!\")");

}
