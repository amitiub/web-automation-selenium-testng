package com.amit.portfolio.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public final class AdsUtil {
    private AdsUtil() {}

    /**
     * AutomationExercise sometimes shows ad iframes (aswift_*) that can intercept clicks.
     * This utility hides/removes common ad containers to make tests more stable.
     */
    public static void hideAds(WebDriver driver) {
        if (driver == null) return;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script =
                    "(function(){"
                            + "const selectors=["
                            + "\"iframe[id^='aswift_']\","
                            + "\"iframe[name^='aswift_']\","
                            + "\"iframe[id^='google_ads_iframe']\","
                            + "\"iframe[src*='doubleclick']\","
                            + "\"ins.adsbygoogle\","
                            + "\"div[id^='google_ads_iframe']\""
                            + "];"
                            + "selectors.forEach(sel=>{"
                            + "document.querySelectorAll(sel).forEach(el=>{"
                            + "try{el.style.display='none';el.style.visibility='hidden';el.style.height='0px';el.style.width='0px';el.remove();}catch(e){}"
                            + "});"
                            + "});"
                            + "})();";
            js.executeScript(script);
        } catch (Exception ignored) {
        }
    }
}
