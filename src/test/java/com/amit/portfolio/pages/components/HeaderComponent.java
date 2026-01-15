package com.amit.portfolio.pages.components;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {

    @FindBy(css = "a[href='/']")
    private WebElement homeLink;

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

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void goHome() { homeLink.click(); }
    public void goToLogin() { signupLoginLink.click(); }
    public void goToProducts() { productsLink.click(); }
    public void goToCart() { cartLink.click(); }
    public void goToContactUs() { contactUsLink.click(); }
    public void goToTestCases() { testCasesLink.click(); }
    public void logout() { logoutLink.click(); }
}
