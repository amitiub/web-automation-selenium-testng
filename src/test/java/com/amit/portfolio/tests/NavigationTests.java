package com.amit.portfolio.tests;

import com.amit.portfolio.core.BaseTest;
import com.amit.portfolio.pages.HomePage;
import com.amit.portfolio.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test(description = "Verify Test Cases page opens from header navigation")
    public void testCasesPageOpens() {
        HomePage home = new HomePage(driver);
        TestCasesPage tc = home.goToTestCases();
        Assert.assertTrue(tc.headingText().toLowerCase().contains("test cases"),
                "Expected heading to contain 'Test Cases'.");
    }
}
