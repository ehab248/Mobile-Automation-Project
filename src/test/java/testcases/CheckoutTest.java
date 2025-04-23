package testcases;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.CheckoutPage;
import io.qameta.allure.testng.AllureTestNg;
import pages.AllureAttachments;

@Listeners({AllureTestNg.class})
@Epic("Checkout Module")
@Feature("Checkout Flow")
public class CheckoutTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeClass
    public void initPage() {
        checkoutPage = new CheckoutPage(driver);
    }

    @Story("User fills the checkout form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5, description = "Fill checkout form with user details")
    @Description("This test fills in the user's first name, last name, and zip code then proceeds to continue.")
    public void testFillCheckoutForm() {
        Allure.step("Fill in first name");
        checkoutPage.fill_FirstName();
        AllureAttachments.saveLog("First name entered");

        Allure.step("Fill in last name");
        checkoutPage.fill_LastName();
        AllureAttachments.saveLog("Last name entered");

        Allure.step("Fill in zip code");
        checkoutPage.fill_Zip();
        AllureAttachments.saveLog("Zip code entered");

        Allure.step("Click continue");
        checkoutPage.click_Continue();
        AllureAttachments.saveLog("Clicked continue to move to next checkout step");
    }

    @Story("User completes checkout and verifies totals")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6, dependsOnMethods = "testFillCheckoutForm", description = "Verify total price and tax, then finish checkout")
    @Description("This test verifies that the total price is correct and that the tax is calculated properly, then completes the checkout.")
    public void test_TotalPriceCalculation() {
        Allure.step("Get price of first item");
        double price1 = checkoutPage.assert_Price1();
        AllureAttachments.saveLog("Price 1: " + price1);

        Allure.step("Get price of second item");
        double price2 = checkoutPage.assert_Price2();
        AllureAttachments.saveLog("Price 2: " + price2);

        Allure.step("Scroll down to total");
        checkoutPage.scroll_Down3();
        AllureAttachments.saveLog("Scrolled down to total price section");

        Allure.step("Get total price");
        double total = checkoutPage.assert_TotPrice();
        AllureAttachments.saveLog("Total displayed: " + total);

        Allure.step("Assert total = price1 + price2");
        Assert.assertEquals(price1 + price2, total, 0.01, "Total price is not equal to sum of item prices!");

        Allure.step("Get and verify tax (8%)");
        double tax = checkoutPage.assert_Tax();
        AllureAttachments.saveLog("Tax displayed: " + tax);
        Assert.assertEquals(total * 0.080043, tax, 0.01, "Tax is not 8%");

        Allure.step("Click finish button");
        checkoutPage.click_Finish();
        AllureAttachments.saveLog("Clicked finish");

        Allure.step("Verify order success screen");
        Assert.assertTrue(checkoutPage.assert_Text4(), "Checkout Transfer was not successful");

        Allure.step("Return to home page");
        checkoutPage.clickBackHome();
        AllureAttachments.saveLog("Returned to home");
    }

    @AfterMethod
    public void captureFailureDetails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureAttachments.saveLog("Test FAILED: " + result.getName());
            AllureAttachments.takeScreenshot(driver);
        }
    }
}
