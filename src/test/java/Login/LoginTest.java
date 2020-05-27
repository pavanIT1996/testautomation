package Login;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class LoginTest extends BaseTest {

    @Test
    public void testSucceesfulLogin() {
        LoginPage loginPage = homepage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage=loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains(
                "You logged into a secure area!"),
                        "Alert text is incorrect");
    }
}
