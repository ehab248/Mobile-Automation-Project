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
    public void testSort(){

        homePage.clickSort();
        homePage.click_High2Low();
      //  try {
       //     Thread.sleep(5000);
        //} catch (InterruptedException e) {
          //  throw new RuntimeException(e);
     //   }
        boolean resualt1 =homePage.comparePrices();
        Assert.assertTrue(resualt1,"The first price is not greater than or equal to the second price");
        homePage.clickSort();
        homePage.click_Low2High();
        boolean resualt2 =homePage.comparePrices();
        Assert.assertFalse(resualt2,"The first price is not less than or equal to the second price");


        homePage.clickSort();
        homePage.click_Z2A();

        boolean result3 = homePage.compareNames();
        Assert.assertTrue(result3,"The first name is not greater than or equal to the second name");

        homePage.clickSort();
        homePage.click_A2Z();
        boolean result4 = homePage.compareNames();
        Assert.assertFalse(result4,"The first name is not Less than or equal to the second name");

    }
    @Test(dependsOnMethods = "testSort")
    public void testAddElementToCard() {
        homePage.click_AddToCart1();
        homePage.scroll_Down();
        homePage.click_AddToCart2();
        homePage.click_YourCart();
        Assert.assertTrue(homePage.assert_Text2(), "HomePage Transfer was not successful");

    }
}

