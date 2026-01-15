package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.components.FooterComponent;
import com.amit.portfolio.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionTests extends BaseTest {

    @Test(description = "Subscribe to newsletter from footer and verify success message")
    public void subscribeFromFooter() {
        HomePage home = new HomePage(driver);
        FooterComponent footer = new FooterComponent(driver);

        footer.subscribe(TestData.uniqueEmail());
        String msg = footer.subscribeSuccessText().toLowerCase();

        Assert.assertTrue(msg.contains("successfully subscribed"),
                "Expected subscribe success message, got: " + msg);
    }
}
