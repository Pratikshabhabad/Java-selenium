package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
    }

    protected void type(By locator,String text)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected void click(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected String getText(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
