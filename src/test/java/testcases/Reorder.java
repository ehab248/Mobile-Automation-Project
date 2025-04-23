package testcases;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import io.qameta.allure.testng.AllureTestNg;
import pages.AllureAttachments;

@Listeners({AllureTestNg.class})
@Epic("Cart Module")
@Feature("Reorder Functionality")
public class Reorder extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void initPage() {
        homePage = new HomePage(driver);
    }

    @Story("User adds and removes products before reordering")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 7, description = "Reorder by adding and removing products")
    @Description("This test simulates a reorder by adding products, removing one, and confirming the final cart.")
    public void testAddElementToCart() {
        Allure.step("Display all products");
        homePage.clickDisplayProducts();
        AllureAttachments.saveLog("Displayed all products");

        Allure.step("Add product to cart");
        homePage.click_AddToCart3();
        AllureAttachments.saveLog("Added product");

        Allure.step("View another product photo");
        homePage.Photo_4();
        AllureAttachments.saveLog("Viewed product photo");

        Allure.step("Scroll down and add second product");
        homePage.scroll_Down();
        homePage.click_AddToCart4();
        AllureAttachments.saveLog("Added second product");

        Allure.step("Remove second product from cart");
        homePage.removeFromCart4();
        AllureAttachments.saveLog("Removed product 4 from cart");

        Allure.step("Return to product list");
        homePage.backToProds();
        AllureAttachments.saveLog("Returned to product list");

        Allure.step("Add another product to cart");
        homePage.click_AddToCart5();
        AllureAttachments.saveLog("Added another product");

        Allure.step("Go to cart");
        homePage.click_YourCart();
        AllureAttachments.saveLog("Navigated to cart");

        Allure.step("Assert final cart page is displayed");
        Assert.assertTrue(homePage.assert_Text2(), "HomePage Transfer was not successful");
    }

    @AfterMethod
    public void captureFailureDetails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureAttachments.saveLog("Test FAILED: " + result.getName());
            AllureAttachments.takeScreenshot(driver);
        }
    }
}
