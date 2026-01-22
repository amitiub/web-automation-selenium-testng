package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdHandler {

    public static void removeAds(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "var ads = document.querySelectorAll(\"iframe[id^='aswift'], iframe[src*='ads'], iframe[src*='doubleclick']\");" +
                            "for(var i=0; i<ads.length; i++){" +
                            "  ads[i].style.display='none';" +
                            "}"
            );
        } catch (Exception ignored) {
            // Ads may not be present – safe to ignore
        }
    }

    public static void closeAdsIfPresent() {
        try {
            DriverManager.driver.switchTo().frame(0);
            WebElement closeBtn = DriverManager.driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
            closeBtn.click();
            DriverManager.driver.switchTo().defaultContent();
        } catch (Exception ignored) {
            DriverManager.driver.switchTo().defaultContent();
        }
    }
}
