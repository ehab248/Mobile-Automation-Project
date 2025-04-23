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
@Epic("Home Module")
@Feature("Product Sorting & Cart")
public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void initPage() {
        homePage = new HomePage(driver);
    }

    @Story("User tests product sorting functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, description = "Test sorting by price and name")
    @Description("This test verifies the sorting of products by price (High to Low, Low to High) and name (Z to A, A to Z)")
    public void testSort() {

        Allure.step("Click sort and select High to Low");
        homePage.clickSort();
        homePage.click_High2Low();
        AllureAttachments.saveLog("Sorting: High to Low");
        boolean resualt1 = homePage.comparePrices();
        Assert.assertTrue(resualt1, "The first price is not greater than or equal to the second price");

        Allure.step("Click sort and select Low to High");
        homePage.clickSort();
        homePage.click_Low2High();
        AllureAttachments.saveLog("Sorting: Low to High");
        boolean resualt2 = homePage.comparePrices();
        Assert.assertFalse(resualt2, "The first price is not less than or equal to the second price");

        Allure.step("Click sort and select Z to A");
        homePage.clickSort();
        homePage.click_Z2A();
        AllureAttachments.saveLog("Sorting: Z to A");
        boolean result3 = homePage.compareNames();
        Assert.assertTrue(result3, "The first name is not greater than or equal to the second name");

        Allure.step("Click sort and select A to Z");
        homePage.clickSort();
        homePage.click_A2Z();
        AllureAttachments.saveLog("Sorting: A to Z");
        boolean result4 = homePage.compareNames();
        Assert.assertFalse(result4, "The first name is not Less than or equal to the second name");
    }

    @Story("User adds products to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority =3, dependsOnMethods = "testSort", description = "Add two elements to cart and verify")
    @Description("This test adds two products to the cart and verifies the cart content")
    public void testAddElementToCart() {
        Allure.step("Add first item to cart");
        homePage.click_AddToCart1();
        AllureAttachments.saveLog("First item added to cart");

        Allure.step("Scroll down");
        homePage.scroll_Down();
        AllureAttachments.saveLog("Scrolled down to view second item");

        Allure.step("Add second item to cart");
        homePage.click_AddToCart2();
        AllureAttachments.saveLog("Second item added to cart");

        Allure.step("Click on cart icon");
        homePage.click_YourCart();
        AllureAttachments.saveLog("Navigated to cart");

        Allure.step("Verify items in cart");
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

