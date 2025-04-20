package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest  {

    private CheckoutPage checkoutPage;

    @BeforeClass
    public void initPage() {
        checkoutPage = new CheckoutPage(BaseTest.driver);
    }

    @Test
    public void testFillCheckoutForm() {

        checkoutPage.fill_FirstName();
        checkoutPage.fill_LastName();
        checkoutPage.fill_Zip();
        checkoutPage.click_Continue();
    }
    
    @Test(dependsOnMethods = "testFillCheckoutForm")
    public void test_TotalPriceCalculation() {
        double price1 = checkoutPage.assert_Price1();
        double price2 = checkoutPage.assert_Price2();
        checkoutPage.scroll_Down3();
        double total = checkoutPage.assert_TotPrice();
        Assert.assertEquals(price1 + price2, total, 0.01, "Total price is not equal to sum of item prices!");
        double tax = checkoutPage.assert_Tax();
        Assert.assertEquals(total*0.080043, tax, 0.01, "Tax is not 8% ");
        checkoutPage.click_Finish();
        Assert.assertTrue(checkoutPage.assert_Text4(), "Checkout Transfer was not successful");
        checkoutPage.clickBackHome();
    }

}