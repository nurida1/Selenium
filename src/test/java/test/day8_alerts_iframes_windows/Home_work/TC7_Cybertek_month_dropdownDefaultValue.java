package test.day8_alerts_iframes_windows.Home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDateTime;

public class TC7_Cybertek_month_dropdownDefaultValue {
 /*
    TC#7: Cybertek “month” dropdown default value
    1. Open browser
    2. Go to website: http://practice.cybertekschool.com/dropdown
    3. Verify default value is always showing the current month
    o Expected: If currently in June, should show June selected.
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test1_dropdown() {
        Select actualMonth = new Select(driver.findElement(By.id("month")));
        String actualText = actualMonth.getFirstSelectedOption().getText();

        String expectedMonth = LocalDateTime.now().getMonth().name();
        Assert.assertEquals(actualText,expectedMonth);

    }






}
