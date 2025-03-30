package testcases;


import base.BaseTest;
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
    public void testLoginWithValidCredentials() {

        loginPage.fill_Username_Field();
        loginPage.fill_Password_FIeld();
        loginPage.click_Login();
    }
}

