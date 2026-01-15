package com.amit.portfolio.pages;

import com.amit.portfolio.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContactUsPage extends BasePage {

    @FindBy(css = "input[data-qa='name']")
    private WebElement name;

    @FindBy(css = "input[data-qa='email']")
    private WebElement email;

    @FindBy(css = "input[data-qa='subject']")
    private WebElement subject;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(name = "upload_file")
    private WebElement uploadFile;

    @FindBy(css = "input[data-qa='submit-button']")
    private WebElement submitBtn;

    @FindBy(css = ".status.alert.alert-success")
    private WebElement successAlert;

    @FindBy(css = "a.btn.btn-success")
    private WebElement homeBtn;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage fillForm(String nm, String em, String sub, String msg) {
        name.clear(); name.sendKeys(nm);
        email.clear(); email.sendKeys(em);
        subject.clear(); subject.sendKeys(sub);
        message.clear(); message.sendKeys(msg);
        return this;
    }

    public ContactUsPage uploadTempFile(String content) {
        try {
            Path tmp = Files.createTempFile("automation_exercise_upload_", ".txt");
            Files.writeString(tmp, content);
            uploadFile.sendKeys(tmp.toFile().getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create/upload temp file", e);
        }
        return this;
    }

    public ContactUsPage submit() {
        // Site triggers an alert confirm; Selenium will need to accept it in test.
        safeClick(submitBtn);
        return this;
    }

    public String successText() {
        return successAlert.getText().trim();
    }

    public HomePage backToHome() {
        homeBtn.click();
        return new HomePage(driver);
    }
}
