package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.CartPage;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(description = "Add first product to cart and verify cart has at least one item")
    public void addProductToCart() {
        HomePage home = new HomePage(driver);
        ProductsPage products = home.goToProducts();

        CartPage cart = products.addProductByIndexAndViewCart(0);

        Assert.assertTrue(cart.hasItems(),
                "Expected cart to have at least one item.");
    }
}
