package stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import testData.LoginTestData;

public class LoginStepsDefinition {
    private static final Logger logger=LoggerFactory.getLogger(LoginStepsDefinition.class);
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("user is on login page")
    public void user_is_on_login_page()
    {
        loginPage=new LoginPage(DriverFactory.getDriver());
        loginPage.openLoginPage();
        logger.info("Opening Login Page");   
    }

    @When("user enters valid {string} and {string}")
    public void user_enters_valid_username_password(String email,String password)
    {
        //String email=LoginTestData.getEmail();
        //String password=LoginTestData.getPassword();
        logger.info("Entering login Credentials");
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        logger.info("Login form Submitted");

    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully()
    {
        homePage=new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(homePage.isHomePageDisplayed(),"Login Failed:user not redirected homepage");
        Assert.assertTrue(homePage.isUserLoggedIn(),"Login Failed: user is not logged in");
        logger.info("verifying successful login");
    }

    @And("user should be able to logout")
    public void user_should_be_able_to_logout()
    {
        homePage.logout();
        Assert.assertTrue(homePage.isLogoutSuccessful(),"Logout Failed:User was not redirected to login page");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password()
    {
        String invalidEmail=LoginTestData.getInvalidEmail();
        String invalidPassword=LoginTestData.getInvalidPassword();
        loginPage.enterEmail(invalidEmail);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLogin();
    }

    @Then("login error message should be displayed")
    public void login_error_message_should_be_displayed()
    {
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),"Login error message not displayed");
    }
}
