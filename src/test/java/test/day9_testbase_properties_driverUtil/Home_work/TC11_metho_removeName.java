package test.day9_testbase_properties_driverUtil.Home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;

public class TC11_metho_removeName {
    //TC #11 : Create a method called removeName()
    // 1. Accepts two parameters: WebDriver, String name
    // 2. Method will remove the given name from the list of Smartbear
    // 3. Create a new TestNG test, and call your method.
    // 4. Assert that your method removed the given name
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
    @Test
    public void test_removeName ()  {
        SmartBearUtilities.login(driver);
        SmartBearUtilities.removeName(driver, "Clare Jefferson");

        String actualName = "Clare Jefferson";
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));
        for (WebElement each : names) {
            Assert.assertFalse(each.getText().contains(actualName));
            }
        }
    }
