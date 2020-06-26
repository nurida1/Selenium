package test.day8_alerts_iframes_windows.Home_work;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P4_verifyOrder {
    //PRACTICE #4: Method: verifyOrder
    // • Create a method named verifyOrder in SmartBearUtils class.
    // • Method takes WebDriver object and String(name).
    // • Method should verify if given name exists in orders.
    // • This method should simply accepts a name(String), and assert whether given name is in the list or not. • Create a new TestNG test to test if the method is working as expected.

    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }


    @Test
    public void test () {

        SmartBearUtilities.verifyOrder(driver, "Charles Dodgeson");

    }



}
