package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginLink;

    @FindBy(css = "a[href='/products']")
    private WebElement productsLink;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartLink;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsLink;

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesLink;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutLink;

    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccountLink;

    @FindBy(css = "li a b")
    private WebElement loggedInAsLabel;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLogin() {
        signupLoginLink.click();
        return new LoginPage(driver);
    }

    public ProductsPage goToProducts() {
        productsLink.click();
        return new ProductsPage(driver);
    }

    public CartPage goToCart() {
        cartLink.click();
        return new CartPage(driver);
    }

    public ContactUsPage goToContactUs() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage goToTestCases() {
        testCasesLink.click();
        return new TestCasesPage(driver);
    }

    public HomePage logout() {
        logoutLink.click();
        return new HomePage(driver);
    }

    public AccountDeletedPage deleteAccount() {
        deleteAccountLink.click();
        return new AccountDeletedPage(driver);
    }

    public String loggedInAs() {
        return loggedInAsLabel.getText().trim();
    }
}
