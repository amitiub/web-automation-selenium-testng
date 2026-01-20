package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.AdHandler;
import utils.DriverManager;
import utils.ExtentManager;

public class RegistrationTests extends BaseTest {

    @Test
    public void TC01_fullHappyPathRegistration() {

        ExtentManager.test =
                ExtentManager.extent.createTest("Full Happy Path Registration");

        // Step 1: Home → Signup/Login
        HomePage homePage = new HomePage();
        homePage.clickSignupLogin();
        ExtentManager.test.info("Navigated to Signup/Login page");

        // Step 2: Signup (Name + Email)
        String email = "amit+" + System.currentTimeMillis() + "@gmail.com";
        SignupLoginPage signupPage = new SignupLoginPage();
        signupPage.signup("Amit Kumar", email);
        ExtentManager.test.info("Signup initiated with email: " + email);

        // Step 3: Verify Enter Account Info page
        Assert.assertTrue(
                signupPage.isEnterAccountInfoVisible(),
                "Enter Account Information page not displayed"
        );

        // Step 4: Fill Account Information
        AccountInformationPage accountInfo = new AccountInformationPage();
        accountInfo.fillAccountInformation(
                "password123",
                "10",
                "May",
                "1990"
        );
        ExtentManager.test.info("Account information filled");

        // Step 5: Fill Address Details & Create Account
        accountInfo.fillAddressDetails(
                "Amit",
                "Kumar",
                "CGI",
                "Brock Road",
                "Canada",
                "Pickering",
                "Ontario",
                "M1M1M1",
                "1234567890"
        );
        ExtentManager.test.info("Address information filled");

        // Step 6: Verify Account Created
        AccountCreatedPage accountCreated = new AccountCreatedPage();
        Assert.assertTrue(
                accountCreated.isAccountCreatedVisible(),
                "Account Created message not displayed"
        );
        ExtentManager.test.pass("Account created successfully");

        // Step 7: Continue to Home
        AdHandler.removeAds(DriverManager.driver);
        accountCreated.clickContinue();

        // Step 8: Verify Logged In
        LoggedInHomePage loggedInHome = new LoggedInHomePage();
        Assert.assertTrue(
                loggedInHome.isLoggedInAsUserVisible("Amit Kumar"),
                "User not logged in successfully"
        );

        ExtentManager.test.pass("Full happy path registration flow completed");
    }
}
