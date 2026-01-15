package com.amit.portfolio.core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {
    private ScreenshotUtil() {}

    public static Path takeScreenshot(WebDriver driver, String name) throws Exception {
        if (driver == null) throw new IllegalStateException("Driver is null - cannot take screenshot.");
        Path outDir = Path.of("target", "screenshots");
        Files.createDirectories(outDir);

        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String safe = name.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
        Path dest = outDir.resolve(safe + "_" + ts + ".png");

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), dest);
        return dest;
    }
}
