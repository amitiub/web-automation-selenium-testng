package com.amit.portfolio.core;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Path;

public class TestListener implements ITestListener {
    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getExtent(); // init
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getExtent().createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getTestClass().getName());
        TEST.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST.get().pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TEST.get().fail(result.getThrowable());

        try {
            Path screenshot = ScreenshotUtil.takeScreenshot(DriverManager.getDriver(), result.getMethod().getMethodName());
            TEST.get().fail("Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshot.toString()).build());
        } catch (Exception e) {
            TEST.get().warning("Failed to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (result.getThrowable() != null) {
            TEST.get().skip(result.getThrowable());
        } else {
            TEST.get().skip("Skipped");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flush();
    }
}
