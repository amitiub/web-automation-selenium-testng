package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class LoggedInHomePage {

    public LoggedInHomePage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInText;

    public boolean isLoggedInAsUserVisible(String username) {
        return loggedInText.getText().contains(username);
    }
}
