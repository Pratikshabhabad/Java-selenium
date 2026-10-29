package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {
    private static final Logger logger=LoggerFactory.getLogger(Hooks.class);

    @Before 
    public void setup()
    {
       // System.out.println("Hooks Executed");
       ConfigReader.loadProperties();
        DriverFactory.initializeDriver();
        logger.info("Test setup completed successfully");
    }

    @After 
    public void quitDriver(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            byte[] screenshot=((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png","Failure Screenshot");
            logger.info("Failure screenshot attached");
        }
        else{
            logger.info("Test scenario Passed:{}",scenario);
        }
        DriverFactory.quitDriver();

        logger.info("Browser closed...");
    }
}
