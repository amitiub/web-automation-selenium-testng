package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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
}
