package test.day8_alerts_iframes_windows;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {

WebDriver driver;

@BeforeMethod
    public void setUp() {
    driver = WebDriverFactory.getDriver("chrome");
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
    public void p4_verifyOrder_test() {
    //Logging into smartbear
    SmartBearUtilities.login(driver);
    //Cal my method the verify if given name is in the list or not
    SmartBearUtilities.verifyOrder(driver, "Paul Brown");
}


@Test
    public void p5_print_names_cities_test() {
    SmartBearUtilities.login(driver);
    SmartBearUtilities.printNamesAndCities(driver);

}
}


















