package locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomePageLocators {



    public static final By Add_To_Cart1 = MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    public static final By Scroll = MobileBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"© 2025 Sauce Labs. All Rights Reserved.\"))"
    );

    public static final By Add_To_Cart2 = MobileBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")");
    public static final By Your_Cart = MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
    public static final By AssertText2 = MobileBy.androidUIAutomator("new UiSelector().text(\"YOUR CART\")");


}