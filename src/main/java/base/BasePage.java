package base;

import io.appium.java_client.android.AndroidDriver;
import pages.JsonData;

public class BasePage {
    protected AndroidDriver driver;
    public JsonData testData;

    public BasePage(AndroidDriver driver) {
        testData = new JsonData("data");
        this.driver = driver;
    }

}