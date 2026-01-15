package com.amit.portfolio.core;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final Waits waits;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, Config.getInt("explicitWaitSec", 15));
        PageFactory.initElements(driver, this);
    }

    protected void jsClick(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    protected void scrollIntoView(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }

    /**
     * Safer click that handles common overlays/ads that intercept clicks.
     */
    protected void safeClick(WebElement el) {
        AdsUtil.hideAds(driver);
        try {
            scrollIntoView(el);
            el.click();
        } catch (ElementClickInterceptedException e) {
            AdsUtil.hideAds(driver);
            try {
                scrollIntoView(el);
                jsClick(el);
            } catch (StaleElementReferenceException ex) {
                throw ex;
            }
        }
    }

    public String title() {
        return driver.getTitle();
    }
}
