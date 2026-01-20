package tests;

import pages.HomePage;
import utils.DriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExtentManager;

public class CartTests extends BaseTest {

    @Test
    public void TC13_addProductsToCart() {

        ExtentManager.test =
                ExtentManager.extent.createTest("Add Products To Cart");

        HomePage homePage = new HomePage();
        homePage.clickProducts();

        // (later: add product methods here)
        Assert.assertTrue(true);
    }


    @Test
    public void TC14_verifyProductQuantityInCart() {
        ExtentManager.test = ExtentManager.extent.createTest("Verify Product Quantity In Cart");
        DriverManager.driver.findElement(org.openqa.selenium.By.linkText("Cart")).click();
        Assert.assertTrue(true);
    }
}
