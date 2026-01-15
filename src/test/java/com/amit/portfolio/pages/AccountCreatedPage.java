package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement heading;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueBtn;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String headingText() {
        return heading.getText().trim();
    }

    public HomePage continueToHome() {
        safeClick(continueBtn);
        return new HomePage(driver);
    }
}
