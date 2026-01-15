package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.AccountCreatedPage;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.LoginPage;
import com.amit.portfolio.pages.SignupPage;
import com.amit.portfolio.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test(description = "Signup, logout, and verify user is redirected to login page")
    public void logoutRedirectsToLogin() {
        HomePage home = new HomePage(driver);
        LoginPage login = home.goToLogin();

        String email = TestData.uniqueEmail();
        SignupPage signup = login.startSignup("Amit Test", email);
        AccountCreatedPage created = signup.completeSignup("Password@123");
        HomePage loggedIn = created.continueToHome();

        loggedIn.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Expected to be on /login after logout.");
    }
}
