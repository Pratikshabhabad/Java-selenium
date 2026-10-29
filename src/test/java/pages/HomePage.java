package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constants.Constants;

public class HomePage extends BasePage{
    private By LoggedInUser=By.xpath("//a[contains(.,' Logged in as ')]");
    private By logoutLink=By.xpath("//a[contains(.,' Logout')]");

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isHomePageDisplayed()
    {
        return driver.getCurrentUrl().equals(Constants.BASE_URL+"/");
    }

    public boolean isUserLoggedIn()
    {
        return getText(LoggedInUser).contains("Logged in as");
    }

    public void logout()
    {
        click(logoutLink);
    }

    public boolean isLogoutSuccessful()
    {
        return driver.getCurrentUrl().contains("/login");
    }

}
