package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators declared in the same class
    private static final By
            USERNAME = By.id("user-name"),
            PASSWORD = By.id("password"),
            LOGIN_BUTTON = By.id("login-button"),
            ERROR_MESSAGE = By.cssSelector("[data-test='error']"),
            INVENTORY_TITLE = By.className("title");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(USERNAME, username);
        type(PASSWORD, password);
        click(LOGIN_BUTTON);
    }

    public String getErrorMessage() {
        return getText(ERROR_MESSAGE);
    }

    public String getPageTitle() {
        return getText(INVENTORY_TITLE);
    }
}