package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "tr.cart_product")
    private List<WebElement> cartRows;

    @FindBy(css = "a.cart_quantity_delete")
    private List<WebElement> deleteButtons;

    @FindBy(css = "a.check_out")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = "#empty_cart .text-center")
    private WebElement emptyCartMsg;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int itemCount() {
        return cartRows.size();
    }

    public boolean hasItems() {
        return itemCount() > 0;
    }

    public CartPage removeFirstItem() {
        if (deleteButtons.isEmpty()) return this;
        safeClick(deleteButtons.get(0));
        return this;
    }

    public boolean isEmptyMessageDisplayed() {
        try {
            return emptyCartMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }
}
