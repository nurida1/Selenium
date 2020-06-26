package test.day8_alerts_iframes_windows;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
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

}
