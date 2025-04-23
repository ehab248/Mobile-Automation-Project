package testcases;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.YourCartPage;
import io.qameta.allure.testng.AllureTestNg;
import pages.AllureAttachments;

@Listeners({AllureTestNg.class})
@Epic("Cart Module")
@Feature("Cart Checkout")
public class YourCartTest extends BaseTest {

    private YourCartPage yourCartPage;

    @BeforeClass
    public void initPage() {
        yourCartPage = new YourCartPage(driver);
    }

    @Story("User proceeds to checkout from cart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4, description = "Scroll and proceed to checkout from cart page")
    @Description("This test scrolls down the cart page and verifies successful navigation to the checkout screen")
    public void testAddElementToCart() {
        Allure.step("Scroll down to checkout section");
        yourCartPage.scroll_Down2();
        AllureAttachments.saveLog("Scrolled to checkout area");

        Allure.step("Click checkout button");
        yourCartPage.click_Checkout();
        AllureAttachments.saveLog("Clicked on Checkout");

        Allure.step("Verify navigation to checkout page");
        Assert.assertTrue(yourCartPage.assert_Text3(), "YourCart Transfer was not successful");
    }

    @AfterMethod
    public void captureFailureDetails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureAttachments.saveLog("Test FAILED: " + result.getName());
            AllureAttachments.takeScreenshot(driver);
        }
    }
}


