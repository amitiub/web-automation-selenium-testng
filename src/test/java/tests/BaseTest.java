package tests;

import org.testng.annotations.*;
import utils.AdHandler;
import utils.DriverManager;
import utils.ExtentManager;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        ExtentManager.init();
    }

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.driver.get("https://automationexercise.com/");
        AdHandler.removeAds(DriverManager.driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentManager.flush();
    }
}
