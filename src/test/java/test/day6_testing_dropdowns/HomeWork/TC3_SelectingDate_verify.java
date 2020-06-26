package test.day6_testing_dropdowns.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC3_SelectingDate_verify {
    /*
            #3: Selecting date on dropdown and verifying
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select “December 1st, 1921” and verify it is selected.
        Select year using : visible text
        Select month using : value attribute
        Select day using : index number
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1_Dec1 () throws Exception{
        //3. Select “December 1st, 1921” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        //Select year using : visible text
        yearDropdown.selectByVisibleText("1921");
        String expectedYear = "1921";
        Thread.sleep(3000);
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        Assert.assertTrue(expectedYear.equals(actualYear));

        //Select month using : value attribute
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        String expectedMonth = "December";
        Thread.sleep(3000);
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth,expectedMonth);

        //Select day using : index number
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        Thread.sleep(3000);
        String expectedDay = "1";
        String actualDay = dayDropdown.getFirstSelectedOption().getText();
        Assert.assertTrue(actualDay.equals(expectedDay));

    }

    @AfterMethod
            public void TearDown () throws Exception {
        Thread.sleep(10000);
        driver.close();
    }

}
