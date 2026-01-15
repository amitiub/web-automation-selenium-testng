package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.AccountCreatedPage;
import com.amit.portfolio.pages.AccountDeletedPage;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.LoginPage;
import com.amit.portfolio.pages.SignupPage;
import com.amit.portfolio.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test(description = "Create a new account and then delete it (happy path)")
    public void signupAndDeleteAccount() {
        HomePage home = new HomePage(driver);
        LoginPage login = home.goToLogin();

        String email = TestData.uniqueEmail();
        SignupPage signup = login.startSignup("Amit Test", email);

        AccountCreatedPage created = signup.completeSignup("Password@123");
        Assert.assertTrue(created.headingText().toUpperCase().contains("ACCOUNT CREATED"),
                "Account Created page not shown.");

        HomePage loggedInHome = created.continueToHome();

        // Site shows "Logged in as <name>"
        Assert.assertTrue(loggedInHome.loggedInAs().length() > 0, "Expected Logged in label to have text.");

        AccountDeletedPage deleted = loggedInHome.deleteAccount();
        Assert.assertTrue(deleted.headingText().toUpperCase().contains("ACCOUNT DELETED"),
                "Account Deleted page not shown.");
    }
}
