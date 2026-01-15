package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Login section
    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "p[style*='color: red']")
    private WebElement loginError;

    // Signup section
    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login(String email, String password) {
        loginEmail.clear();
        loginEmail.sendKeys(email);
        loginPassword.clear();
        loginPassword.sendKeys(password);
        loginButton.click();
        return this;
    }

    public String loginErrorText() {
        return loginError.getText().trim();
    }

    public SignupPage startSignup(String name, String email) {
        signupName.clear();
        signupName.sendKeys(name);
        signupEmail.clear();
        signupEmail.sendKeys(email);
        signupButton.click();
        return new SignupPage(driver);
    }
}
