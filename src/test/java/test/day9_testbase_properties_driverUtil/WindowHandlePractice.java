package test.day9_testbase_properties_driverUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.util.Set;
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

public class WindowHandlePractice extends TestBase {

    @Test
    public void multiple_window_test() {

        driver.get("https://www.amazon.com");

        //we are downcasting our driver to JavascriptExecutor to be able to use its methods.
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');")
        ;((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //5.Create a logic to switch to the tab where Etsy.com is open
       Set<String> windowHandles = driver.getWindowHandles(); //returns all the currently stored windows
        //windowHandle - randomly generated String and random number is assigned to every handle, used for identifying

        for (String each : windowHandles) {
            System.out.println("current title: " + driver.getTitle());
            driver.switchTo().window(each);//to switch one by one to other windows
            if (driver.getCurrentUrl().contains("etsy")) { //checking url:www.etsy.com
                //6.Assert: Title contains “Etsy”Lines to be pasted:
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }

        }



    }



}
