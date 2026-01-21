package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.AdHandler;
import utils.DriverManager;
import utils.ExtentManager;

public class LoginTests extends BaseTest {

    @Test
    public void SignInToSite() {

        ExtentManager.test =
                ExtentManager.extent.createTest("Sign in into the site");

        // Step 1: Home → Signup/Login
        HomePage homePage = new HomePage();
        homePage.clickSignupLogin();
        ExtentManager.test.info("Navigated to Signup/Login page");

        SignupLoginPage signupPage = new SignupLoginPage();
        signupPage.signIn("amit.iub@gmail.com", "amitkd123");

        // Step 8: Verify Logged In
        LoggedInHomePage loggedInHome = new LoggedInHomePage();
        Assert.assertTrue(
                loggedInHome.isLoggedInAsUserVisible("Amit KD"),
                "User logged in successfully"
        );

        ExtentManager.test.pass("Sign in flow completed");
    }
}
