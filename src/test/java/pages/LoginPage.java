package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class LoginPage extends BasePage {
    
    private By emailField=By.name("email");
    private By passwordField=By.name("password");
    private By loginButton=By.xpath("//button[@data-qa='login-button']");
    private By loginErrorMessage=By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void openLoginPage()
    {
        String url=ConfigReader.getProperty("url");
        driver.get(url);
    }

    public void enterEmail(String email)
    {
        type(emailField, email);
    }

    public void enterPassword(String password)
    {
        type(passwordField, password);
    }

    public void clickLogin()
    {
        click(loginButton);
    }

    public boolean isLoginPageDisplayed()
    {
        return driver.getCurrentUrl().contains("/login");
    }

    public boolean isLoginErrorDisplayed()
    {
        return getText(loginErrorMessage).contains("Your email or password is incorrect");
    }
}
