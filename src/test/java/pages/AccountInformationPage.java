package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverManager;

public class AccountInformationPage {

    public AccountInformationPage() {
        PageFactory.initElements(DriverManager.driver, this);
    }

    @FindBy(id = "id_gender1")
    WebElement titleMr;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "newsletter")
    WebElement newsletter;

    @FindBy(id = "optin")
    WebElement offers;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement addressHome;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zip;

    @FindBy(id = "mobile_number")
    WebElement mobile;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createAccountBtn;

    public void fillAccountInformation(
            String pwd, String day, String month, String year) {

        titleMr.click();
        password.sendKeys(pwd);
        new Select(days).selectByVisibleText(day);
        new Select(months).selectByVisibleText(month);
        new Select(years).selectByVisibleText(year);

        newsletter.click();
        offers.click();
    }

    public void fillAddressDetails(
            String fName, String lName, String comp, String address, String countryName,
            String cityName, String stateName, String zipCode, String phone) {

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        company.sendKeys(comp);
        addressHome.sendKeys(address);
        new Select(country).selectByVisibleText(countryName);
        city.sendKeys(cityName);
        state.sendKeys(stateName);
        zip.sendKeys(zipCode);
        mobile.sendKeys(phone);

        createAccountBtn.click();
    }
}
