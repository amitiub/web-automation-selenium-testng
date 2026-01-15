package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(id = "search_product")
    private WebElement searchInput;

    @FindBy(id = "submit_search")
    private WebElement searchBtn;

    @FindBy(css = "a[href*='/product_details/']")
    private List<WebElement> viewProductLinks;

    @FindBy(css = ".productinfo.text-center a.add-to-cart")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".modal-content .btn.btn-success.close-modal")
    private WebElement continueShoppingBtn;

    @FindBy(css = ".modal-content a[href='/view_cart']")
    private WebElement viewCartBtn;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage search(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchBtn.click();
        return this;
    }

    public ProductDetailsPage openFirstProductDetails() {
        if (viewProductLinks.isEmpty()) {
            throw new IllegalStateException("No product details links found.");
        }
        safeClick(viewProductLinks.get(0));
        return new ProductDetailsPage(driver);
    }

    public ProductsPage addProductByIndexAndContinue(int index) {
        if (addToCartButtons.size() <= index) {
            throw new IllegalArgumentException("Not enough products on page to add index: " + index);
        }
        safeClick(addToCartButtons.get(index));
        try {
            safeClick(continueShoppingBtn);
        } catch (Exception e) {
            jsClick(continueShoppingBtn);
        }
        return this;
    }

    public CartPage addProductByIndexAndViewCart(int index) {
        if (addToCartButtons.size() <= index) {
            throw new IllegalArgumentException("Not enough products on page to add index: " + index);
        }
        safeClick(addToCartButtons.get(index));
        try {
            safeClick(viewCartBtn);
        } catch (Exception e) {
            jsClick(viewCartBtn);
        }
        return new CartPage(driver);
    }
}
