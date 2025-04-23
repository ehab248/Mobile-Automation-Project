package testcases;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import pages.AllureAttachments;

@Listeners({AllureTestNg.class})
@Epic("Login Module")
@Feature("Valid Login")
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Story("User logs in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "Login Test with valid credentials")
    @Description("This test verifies successful login with valid username and password")
    public void testLoginWithValidCredentials() throws InterruptedException {
        Allure.step("Wait for app to load");
        Thread.sleep(2000);
        AllureAttachments.saveLog("App loaded after 2 seconds");

        Allure.step("Fill in username");
        loginPage.fill_Username_Field();
        AllureAttachments.saveLog("Username entered");

        Allure.step("Fill in password");
        loginPage.fill_Password_Field();
        AllureAttachments.saveLog("Password entered");

        Allure.step("Click login button");
        loginPage.click_Login();
        AllureAttachments.saveLog("Login button clicked");

        Allure.step("Verify successful login by asserting text");
        boolean isSuccess = loginPage.assert_Text1();
        AllureAttachments.saveLog("Login success status: " + isSuccess);
        Assert.assertTrue(isSuccess, "Login was not successful");
    }

    @AfterMethod
    public void captureFailureDetails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureAttachments.saveLog("Test FAILED: " + result.getName());
            AllureAttachments.takeScreenshot(driver);
        }
    }
}
