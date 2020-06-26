package test.day8_alerts_iframes_windows.Home_work;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P5_printNamesAndCities {
//Practice #5: Method: printNamesAndCities
// • Create a method named printNamesAndCities in SmartBearUtils class.
// • Method takes WebDriver object.
// • This method should simply print all the names in the List of All Orders.
// • Create a new TestNG test to test if the method is working as expected.
// • Output should be like:
// • Name1: name , City1: city
// • Name2: name , City2: city

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
    }

    @Test
    public void test() {
        SmartBearUtilities.printNamesAndCities(driver);
    }


}
