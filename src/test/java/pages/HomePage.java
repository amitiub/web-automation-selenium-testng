package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class HomePage {

    WebDriverWait wait = new WebDriverWait(
            DriverManager.driver, Duration.ofSeconds(10));

    public HomePage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(css = "a[href='/products']")
    private WebElement productsLink;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartLink;

    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
    }

    public void clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    @FindBy(linkText = "Signup / Login")
    WebElement signupLogin;

    public void clickSignupLogin() {
        signupLogin.click();
    }
}
