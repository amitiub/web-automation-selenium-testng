package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(id = "susbscribe_email")
    WebElement subscribeEmail;

    @FindBy(id = "subscribe")
    WebElement subscribeBtn;

    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionTitle;

    @FindBy(className = "cart_quantity")
    WebElement quantity;

    public void subscribe(String email) {
        subscribeEmail.sendKeys(email);
        subscribeBtn.click();
    }

    public boolean isSubscriptionVisible() {
        return subscriptionTitle.isDisplayed();
    }

    public String getQuantity() {
        return quantity.getText();
    }
}
