package testcases;


import base.BaseTest;
import org.testng.Assert;
import pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
Thread.sleep(3000);
        loginPage.fill_Username_Field();
        loginPage.fill_Password_FIeld();
        loginPage.click_Login();
        Assert.assertTrue(loginPage.assert_Text1(), "Login was not successful");

    }
}

