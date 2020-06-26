package test.day6_testing_dropdowns.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC5_Non_selectedDropdown {

    //TC #5: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test5_selectValue_from_nonSelectDropdown () {

        WebElement nonDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));
        ////a[@id='dropdownMenuLink']
        nonDropdown.click();

        WebElement facebook = driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[4]"));
        facebook.click();

        String fbActualTitle = driver.getTitle();
        String fbExpectedTitle = "Facebook - Log In or Sign Up";

        Assert.assertEquals(fbActualTitle,fbExpectedTitle);

    }

    @AfterTest

    public void close() {
        driver.close();
    }







}
