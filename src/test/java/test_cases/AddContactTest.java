package test_cases;

import driver.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class AddContactTest extends BaseDriver {

    @Test(priority = 1)
    public void login_test() throws InterruptedException {
        LoginPage login_page = new LoginPage(driver);
        DashboardPage dashboard_page = new DashboardPage(driver);

        String email = "test@orangetoolz.com";
        String password = "8Kh8nTe*^jdk";
        login_page.login(email, password);

        Thread.sleep(2000);
        String current_page_title = driver.getTitle();
        Assert.assertEquals(current_page_title, dashboard_page.dashboard_page_title);
    }

    @Test(priority = 2)
    public void add_contact_test() throws InterruptedException {
        DashboardPage dashboard_page = new DashboardPage(driver);
        dashboard_page.open_add_contact_modal();

        String number = "017169956564";
        String email = "abc12@gmail.com";
        String first_name = "Abc";
        String last_name = "Xyz";
        String birthday = "2013-11-04";
        String city = "Dhaka";
        String state = "Dhaka";
        String zip_code = "1230";
        String country = "Bangladesh";
        String address = "abc, xyz";

        dashboard_page.add_contact(number, email, first_name, last_name, birthday,
                city, state, zip_code, country, address);

        Thread.sleep(3000);
        Assert.assertTrue(dashboard_page.is_contact_added(number, email));

    }

}
