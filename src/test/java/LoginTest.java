import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(
                loginPage.getPageTitle(),
                "Products",
                "Login was not successful");
    }

    @Test
    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "wrong_password");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match"),
                "Expected error message was not displayed");
    }
}