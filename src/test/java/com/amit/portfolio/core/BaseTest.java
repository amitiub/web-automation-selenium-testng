package com.amit.portfolio.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional String browserFromSuite) {
        // Priority: TestNG <parameter name="browser"> (suite) -> -Dbrowser -> config.properties
        String browser = (browserFromSuite != null && !browserFromSuite.isBlank())
                ? browserFromSuite
                : Config.get("browser", "chrome");

        boolean headless = Config.getBoolean("headless", false);

        driver = DriverFactory.createDriver(browser, headless);
        DriverFactory.applyDefaults(driver);
        DriverManager.setDriver(driver);

        driver.get(Config.get("baseUrl", "https://automationexercise.com"));
    
        AdsUtil.hideAds(driver);
}

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try {
            if (driver != null) driver.quit();
        } finally {
            DriverManager.unload();
        }
    }
}
