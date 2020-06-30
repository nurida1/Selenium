package test.day9_testbase_properties_driverUtil.Home_work;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;

public class WindowHandleWarmup {
    /*
    TC-WarmUp# : Window Handlepractice1.
    Create a new class called: WindowHandleWarmup
    2.Create new test and make set ups
    3.Go to : https://www.amazon.com
    4.Copy paste the lines from below into your class
    5.Create a logic to switch to the tab where Etsy.com is open
    6.Assert: Title contains “Etsy”Lines to be pasted:
    ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');")
    ;((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    These lines will simple open new tabs using something called JavaScriptExecut and get those pages. We will learn JavaScriptExecutor later as well
     */

    WebDriver driver;

    @Test
    public void test1 () {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');")
        ;
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

   Set<String> windowHandles =  driver.getWindowHandles();
    for (String each : windowHandles) {
        driver.switchTo().window(each);
        if (driver.getTitle().contains("Etsy")) {
            Assert.assertTrue(driver.getTitle().contains("Etsy"));
            break;
        }

    }

    }
}
