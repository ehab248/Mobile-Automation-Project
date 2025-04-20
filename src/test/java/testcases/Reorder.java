package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class Reorder {

    private HomePage homePage;

    @BeforeClass
    public void initPage() {
        homePage = new HomePage(BaseTest.driver);
    }

    @Test
    public void testAddElementToCard() {
        
        homePage.clickDisplayProducts();
        homePage.click_AddToCart3();
        homePage.Photo_4();
        homePage.scroll_Down();
        homePage.click_AddToCart4();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.removeFromCart4();
        homePage.backToProds();
        homePage.click_AddToCart5();
        homePage.click_YourCart();
        Assert.assertTrue(homePage.assert_Text2(), "HomePage Transfer was not successful");
    }
}
