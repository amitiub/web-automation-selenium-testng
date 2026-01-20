package tests;

import utils.DriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.ExtentManager;

public class SubscriptionTests extends BaseTest {

    @Test
    public void TC11_verifySubscriptionHomePage() {
        ExtentManager.test = ExtentManager.extent.createTest("Verify Subscription Home Page");
        CartPage cart = new CartPage();
        cart.subscribe("amit+" + System.currentTimeMillis() + "@gmail.com");
        Assert.assertTrue(cart.isSubscriptionVisible());
    }

    @Test
    public void TC12_verifySubscriptionCartPage() {
        ExtentManager.test = ExtentManager.extent.createTest("Verify Subscription Cart Page");
        DriverManager.driver.findElement(org.openqa.selenium.By.linkText("Cart")).click();
        CartPage cart = new CartPage();
        cart.subscribe("amit+" + System.currentTimeMillis() + "@gmail.com");
        Assert.assertTrue(cart.isSubscriptionVisible());
    }
}
