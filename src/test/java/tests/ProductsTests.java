package tests;

import utils.DriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utils.ExtentManager;

public class ProductsTests extends BaseTest {

    @Test
    public void TC09_verifyAllProductsAndDetails() {

        ExtentManager.test =
                ExtentManager.extent.createTest("Verify All Products");

        HomePage homePage = new HomePage();
        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage();
        Assert.assertTrue(
                productsPage.isAllProductsVisible(),
                "All Products page should be visible"
        );
    }

    @Test
    public void TC10_searchProduct() {

        ExtentManager.test =
                ExtentManager.extent.createTest("Search Product");

        HomePage homePage = new HomePage();
        homePage.clickProducts();

        ProductsPage productsPage = new ProductsPage();
        productsPage.searchProduct("Dress");

        Assert.assertTrue(
                productsPage.isProductListVisible(),
                "Searched products should be visible"
        );
    }

}
