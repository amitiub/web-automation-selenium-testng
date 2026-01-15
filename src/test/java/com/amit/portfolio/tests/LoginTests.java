package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Verify invalid login shows an error message")
    public void invalidLoginShowsError() {
        HomePage home = new HomePage(driver);
        LoginPage login = home.goToLogin();

        login.login("invalid@example.com", "wrongPassword");
        String error = login.loginErrorText();

        Assert.assertTrue(error.toLowerCase().contains("your email or password is incorrect"),
                "Expected invalid login error message, but got: " + error);
    }
}
