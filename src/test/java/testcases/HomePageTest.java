package testcases;

import base.BaseTest;
import org.testng.Assert;
import pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {

    private HomePage homePage;

    @BeforeClass
    public void initPage() {
        homePage = new HomePage(BaseTest.driver);
    }

    @Test
    public void testAddElementToCard() {
        homePage.click_AddToCart1();
        homePage.scroll_Down();
        homePage.click_AddToCart2();
        homePage.click_YourCart();
        Assert.assertTrue(homePage.assert_Text2(), "HomePage Transfer was not successful");

    }
}

