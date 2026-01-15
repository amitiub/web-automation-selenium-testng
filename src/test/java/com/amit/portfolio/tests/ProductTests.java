package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.ProductDetailsPage;
import com.amit.portfolio.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(description = "Search for a product keyword and open first product details")
    public void searchAndOpenProductDetails() {
        HomePage home = new HomePage(driver);
        ProductsPage products = home.goToProducts();

        products.search("top"); // broad keyword to reduce flakiness
        ProductDetailsPage details = products.openFirstProductDetails();

        Assert.assertFalse(details.name().isBlank(), "Expected product name on details page.");
        Assert.assertFalse(details.price().isBlank(), "Expected product price on details page.");
    }

    @Test(description = "Add two different products to cart and verify cart has items")
    public void addTwoProductsToCart() {
        HomePage home = new HomePage(driver);
        ProductsPage products = home.goToProducts();

        products.addProductByIndexAndContinue(0)
                .addProductByIndexAndViewCart(1);

        Assert.assertTrue(home.goToCart().itemCount() >= 1, "Expected at least one cart item.");
    }
}
