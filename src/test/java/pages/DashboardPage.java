package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "main-sidebar")
    WebElement main_sidebar;

    @FindBy(xpath = "//a[@title='Contact Manage']")
    WebElement contact_manage_link;

    @FindBy(css = "a[class='btn btn-shadow btn-info compose-btn add-contact']")
    WebElement add_contact;

    @FindBy(id = "checkbox-4-03")
    WebElement default_tag_checkbox;

    @FindBy(name = "number")
    WebElement number_input;

    @FindBy(name = "email")
    WebElement email_input;

    @FindBy(name = "first_name")
    WebElement first_name_input;

    @FindBy(name = "last_name")
    WebElement last_name_input;

    @FindBy(name = "birthday")
    WebElement birthday_input;

    @FindBy(name = "city")
    WebElement city_input;

    @FindBy(name = "state")
    WebElement state_input;

    @FindBy(name = "zip")
    WebElement zip_input;

    @FindBy(name = "country")
    WebElement country_input;

    @FindBy(name = "address")
    WebElement address_input;

    @FindBy(xpath = "//button[normalize-space()='Add Contact']")
    WebElement add_contact_submit;

    @FindBy(xpath = "//tbody//tr[@role='row']//td[2]")
    List<WebElement> number_column;

    @FindBy(xpath = "//tbody//tr[@role='row']//td[5]")
    List<WebElement> email_column;

    public String dashboard_page_title = "| Dashboard";

    public void open_add_contact_modal() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(main_sidebar).build().perform();
        actions.moveToElement(contact_manage_link).click().build().perform();
        add_contact.click();
        Thread.sleep(10000);
    }

    public void add_contact(String number, String email, String first_name, String last_name, String birthday,
                            String city, String state, String zip, String country, String address) throws InterruptedException {
        default_tag_checkbox.click();
        number_input.sendKeys(number);
        email_input.sendKeys(email);
        first_name_input.sendKeys(first_name);
        last_name_input.sendKeys(last_name);
        birthday_input.sendKeys(birthday);
        city_input.sendKeys(city);
        state_input.sendKeys(state);
        zip_input.sendKeys(zip);
        country_input.sendKeys(country);
        address_input.sendKeys(address);
        add_contact_submit.click();
        Thread.sleep(10000);
    }

    public boolean is_contact_added(String number, String email) {
        ArrayList<String> number_column_data = new ArrayList<>();
        ArrayList<String> email_column_data = new ArrayList<>();
        for (WebElement element : number_column) {
            number_column_data.add(element.getText());
        }
        for (WebElement element : email_column) {
            email_column_data.add(element.getText());
        }

        System.out.println("Expected: " + number + "," + email);
        System.out.println(number_column_data + "\n" + email_column_data);
        return number_column_data.contains(number) && email_column_data.contains(email);
    }


}
