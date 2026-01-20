package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class AccountCreatedPage {

    public AccountCreatedPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedText;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueBtn;

    public boolean isAccountCreatedVisible() {
        return accountCreatedText.isDisplayed();
    }

    public void clickContinue() {
        continueBtn.click();
    }
}
