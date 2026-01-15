package com.amit.portfolio.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ExtentManager {
    private static ExtentReports extent;

    private ExtentManager() {}

    public static synchronized ExtentReports getExtent() {
        if (extent == null) {
            try {
                Path outDir = Path.of("target", "extent-reports");
                Files.createDirectories(outDir);
                ExtentSparkReporter spark = new ExtentSparkReporter(outDir.resolve("ExtentReport.html").toString());
                spark.config().setDocumentTitle("Automation Exercise - Test Report");
                spark.config().setReportName("UI Automation Suite");

                extent = new ExtentReports();
                extent.attachReporter(spark);
                extent.setSystemInfo("Framework", "Selenium + TestNG + POM + PageFactory");
                extent.setSystemInfo("Base URL", Config.get("baseUrl", "https://automationexercise.com"));
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize ExtentReports", e);
            }
        }
        return extent;
    }

    public static synchronized void flush() {
        if (extent != null) extent.flush();
    }
}
