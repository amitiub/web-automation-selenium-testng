package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AdHandler;
import utils.DriverManager;

import java.time.Duration;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    //@FindBy(xpath = "//h2[text()='All Products']")
    //WebElement allProductsTitle;

    @FindBy(id = "search_product")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='features_items']")
    WebElement productList;

    public void closeAds() {
        AdHandler.closeAdsIfPresent();
        AdHandler.removeAds(DriverManager.driver);
    }

    public boolean isAllProductsVisible() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(15));

        // Verify Products page loaded
        wait.until(ExpectedConditions.urlContains("/products"));

        // Verify product list is visible
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(".features_items")))
                .isDisplayed();
    }

    public void searchProduct(String productName) {

        WebDriverWait wait = new WebDriverWait(
                DriverManager.driver, Duration.ofSeconds(10));

        closeAds();
        // Type search text
        wait.until(ExpectedConditions.visibilityOf(searchBox))
                .clear();
        searchBox.sendKeys(productName);

        // Scroll button into view (important)
        ((JavascriptExecutor) DriverManager.driver)
                .executeScript("arguments[0].scrollIntoView(true);", searchBtn);

        // Click using JS to bypass ad iframe
        ((JavascriptExecutor) DriverManager.driver)
                .executeScript("arguments[0].click();", searchBtn);
    }

    public boolean isProductListVisible() {
        return productList.isDisplayed();
    }
}
