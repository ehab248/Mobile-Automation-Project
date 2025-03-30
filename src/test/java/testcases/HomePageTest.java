package testcases;

import base.BaseTest;
import pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {  // ❌ مش هنخليه extends BaseTest

    private HomePage homePage;

    @BeforeClass
    public void initPage() {
        homePage = new HomePage(BaseTest.driver);  // ✅ استخدم driver من BaseTest
    }

    @Test
    public void testAddElementToCard() {
        homePage.click_AddToCart1();
        homePage.scroll_Down();
        homePage.click_AddToCart2();
        homePage.click_YourCart();
    }
}

