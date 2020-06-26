package test.day6_testing_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Dropdowns_Intro {

    WebDriver driver;

    @AfterMethod //this method will run after methods, that's why drive.close can be putted anywhere
    //checks for the annotations first
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @BeforeMethod
    public void setUp() {
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome"); //if I create WebDriver here I will not be able to use in other method, it will be local variable
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //String str = "something"; //local to this method, can not be used outside this method, that's why we initialize WebDriver variable based on class
    }

    @Test
    public void test1_default_value_verification() {

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String actualDefaultOfSimpleDropdown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown = "Please select an option";

        Assert.assertEquals(actualDefaultOfSimpleDropdown,expectedDefaultOfSimpleDropdown);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualDefaultOfStateDropdown = stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfStateDropdown = "Select a State";

        Assert.assertEquals(actualDefaultOfStateDropdown, expectedDefaultOfStateDropdown);

    }

    @Test
    public void test2_state_dropdown_verification() throws InterruptedException{
        //TC #2: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        //FIRST TWO STEPS ARE IMPLEMENTED BEFOREHEAD

        //locating state dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        //Selecting using.selectByValue(); method --> Expected the attribute value of "value" attribute.
        Thread.sleep(1000);
        stateDropdown.selectByValue("IL");

        //4. Select Virginia
        //Selecting using selectByVisibleText() method --> Expects us to pass the actual displayed text0
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Virginia");

        //5. Select California
        //Selecting using selectByIndex(); method --> Expects us to pass the index number of the option.
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOption = "California";
        String actualSelectedOption = stateDropdown.getFirstSelectedOption().getText();

        //we can keep one of bellow two options:
        //Assert.assertEquals(actualSelectedOption,expectedOption);
        Assert.assertTrue(actualSelectedOption.equals(expectedOption));

        //Use all Select options. (visible text, value, index)


    }


}