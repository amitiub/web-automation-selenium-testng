package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

    @FindBy(id = "id_gender1")
    private WebElement titleMrRadio;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement days;

    @FindBy(id = "months")
    private WebElement months;

    @FindBy(id = "years")
    private WebElement years;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipcode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public AccountCreatedPage completeSignup(String pwd) {
        // Minimal happy-path form fill (keeps locators maintainable)
        titleMrRadio.click();
        password.sendKeys(pwd);

        new Select(days).selectByVisibleText("10");
        new Select(months).selectByVisibleText("May");
        new Select(years).selectByVisibleText("1990");

        firstName.sendKeys("Amit");
        lastName.sendKeys("Das");
        address1.sendKeys("123 Test Street");
        new Select(country).selectByVisibleText("Canada");
        state.sendKeys("Ontario");
        city.sendKeys("Toronto");
        zipcode.sendKeys("M1M1M1");
        mobileNumber.sendKeys("1234567890");

        safeClick(createAccountButton);
        return new AccountCreatedPage(driver);
    }
}
