package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = ".product-information h2")
    private WebElement productName;

    @FindBy(css = ".product-information span span")
    private WebElement productPrice;

    @FindBy(css = ".product-information p")
    private WebElement productInfoLines; // multiple <p>, PageFactory maps first; we just validate presence

    @FindBy(css = "button.cart")
    private WebElement addToCartBtn;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String name() { return productName.getText().trim(); }
    public String price() { return productPrice.getText().trim(); }

    public ProductDetailsPage addToCart() {
        addToCartBtn.click();
        return this;
    }
}
