package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.CartPage;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartRemoveTests extends BaseTest {

    @Test(description = "Add a product to cart, remove it, and verify cart is empty (or item count is 0)")
    public void removeItemFromCart() {
        HomePage home = new HomePage(driver);
        ProductsPage products = home.goToProducts();

        CartPage cart = products.addProductByIndexAndViewCart(0);
        Assert.assertTrue(cart.itemCount() >= 1, "Expected cart to have items before removal.");

        cart.removeFirstItem();

        // Some UI updates are async; do a simple re-check via navigation
        CartPage cartAgain = home.goToCart();
        Assert.assertTrue(cartAgain.itemCount() == 0 || cartAgain.isEmptyMessageDisplayed(),
                "Expected cart to be empty after removal.");
    }
}
