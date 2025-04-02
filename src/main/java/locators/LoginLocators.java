package locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginLocators {
    public static final By Username_Field = MobileBy.accessibilityId("test-Username");
    public static final By Password_Field = MobileBy.accessibilityId("test-Password");
    public static final By Login_Button = MobileBy.accessibilityId("test-LOGIN");
    public static final By AssertText1 = MobileBy.androidUIAutomator("new UiSelector().text(\"PRODUCTS\")");
}
