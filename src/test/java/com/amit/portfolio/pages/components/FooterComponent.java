package com.amit.portfolio.pages.components;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterComponent extends BasePage {

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmail;

    @FindBy(id = "subscribe")
    private WebElement subscribeBtn;

    @FindBy(css = ".alert-success.alert")
    private WebElement subscribeSuccess;

    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void subscribe(String email) {
        scrollToFooter();
        subscribeEmail.clear();
        subscribeEmail.sendKeys(email);
        safeClick(subscribeBtn);
    }

    public String subscribeSuccessText() {
        return subscribeSuccess.getText().trim();
    }
}
