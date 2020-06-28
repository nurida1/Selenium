package test.day8_alerts_iframes_windows.Home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC8_Cybertek_month_DropdownListOfDefault {

     /*
    TC#8: Cybertek “month” dropdown list of default values verification
 1. Do both verifications in the same test
 2. Verify list of months are correct as expected.
 o Expected: Options should contain all 12 months of the year.
     */

    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test2_driverMonthsList() {

        Select actualMonth = new Select(driver.findElement(By.id("month")));
        List<WebElement> months = actualMonth.getOptions();

        List<String > expectedMonths = Arrays.asList("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");

        List <String> monthList = new ArrayList<>();
        for (WebElement each: months) {
            monthList.add(each.getText());
        }

        Assert.assertEquals(monthList,expectedMonths);
    }
}
