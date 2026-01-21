package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class SignupLoginPage {

    public SignupLoginPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupBtn;

    //Login
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement logEmail;

    @FindBy(name = "password")
    WebElement loginPass;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;

    public void signIn(String loginEmail, String password) {
        logEmail.sendKeys(loginEmail);
        loginPass.sendKeys(password);
        loginBtn.click();
    }

    public void signup(String uname, String mail) {
        name.sendKeys(uname);
        email.sendKeys(mail);
        signupBtn.click();
    }

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    WebElement enterAccountInfoTitle;

    public boolean isEnterAccountInfoVisible() {
        return enterAccountInfoTitle.isDisplayed();
    }

}
