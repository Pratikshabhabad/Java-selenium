package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory{
    private static final Logger logger=LoggerFactory.getLogger(DriverFactory.class);
    private static WebDriver driver;

    public static void initializeDriver()
    {
        if(driver!=null)
        {
            throw new IllegalStateException("Webdriver is already initialize");
        }

        logger.info("Initialize Chrome Browser");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Chrome browser initialized successfully");
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void quitDriver()
    {
        if(driver!=null)
        {
            driver.quit();
            driver=null;
        }
    }
}