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
    public void testLoginWithValidCredentials() {

        checkoutPage.fill_FirstName();
        checkoutPage.fill_LastName();
        checkoutPage.fill_Zip();
        checkoutPage.click_Continue();
        checkoutPage.scroll_Down3();
        checkoutPage.click_Finish();
        Assert.assertTrue(checkoutPage.assert_Text(), "Login was not successful");

    }
}