package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passworField = By.id("password");
    private By LoginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passworField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(LoginButton).click();
        return new SecureAreaPage(driver);
    }
}
