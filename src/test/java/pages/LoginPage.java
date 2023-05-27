package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email-1")
    WebElement email_input;

    @FindBy(id = "password-1")
    WebElement password_input;

    @FindBy(id = "checkbox-1")
    WebElement checkbox;

    @FindBy(id = "m_login_signin_submit")
    WebElement login_submit_button;

    public void login(String email, String password) {
        email_input.sendKeys(email);
        password_input.sendKeys(password);
        checkbox.click();
        login_submit_button.click();
    }

}
