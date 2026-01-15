package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.ContactUsPage;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest {

    @Test(description = "Submit Contact Us form with file upload and verify success")
    public void submitContactUsForm() {
        HomePage home = new HomePage(driver);
        ContactUsPage contact = home.goToContactUs();

        contact.fillForm("Amit Test", TestData.uniqueEmail(), "Portfolio automation", "Hello from Selenium framework!")
                .uploadTempFile("File upload content from automation.")
                .submit();

        // Site often shows JS alert after submit
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ignored) { }

        Assert.assertTrue(contact.successText().toLowerCase().contains("success"),
                "Expected contact us success message.");

        contact.backToHome();
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"),
                "Expected to be back on home URL.");
    }
}
