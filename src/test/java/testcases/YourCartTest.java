package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YourCartPage;

public class YourCartTest {
    private YourCartPage yourCartPage;

    @BeforeClass
    public void initPage() {
        yourCartPage = new YourCartPage(BaseTest.driver);
    }
    @Test
    public void testAddElementToCard() {
        yourCartPage.scroll_Down2();
        yourCartPage.click_Checkout();
        Assert.assertTrue(yourCartPage.assert_Text3(), "YourCart Transfer was not successful");
    }
}

