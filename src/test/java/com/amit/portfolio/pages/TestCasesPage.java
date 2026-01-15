package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage {

    @FindBy(css = ".title.text-center")
    private WebElement heading;

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public String headingText() {
        return heading.getText().trim();
    }
}
