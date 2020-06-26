package test.day6_testing_dropdowns.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC4_Multiple_SelectDropdown {
    /*
            TC #4: Selecting value from multiple select dropdown
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select all the options from multiple select dropdown.
        4. Print out all selected values.
        5. Deselect all values.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //3. Select all the options from multiple select dropdown.
    @Test
    public void Test1_SelectAll() {
            Select languages = new Select (driver.findElement(By.xpath("//select[@name='Languages']")) );
            //        4. Print out all selected values.
            //Getting all of the options from dropdown and storing them into list of web elements
            List <WebElement> allOptions = languages.getOptions();

            //Looping through the options and selecting them
            for (WebElement option : allOptions) {
                option.click();
                System.out.println("Selected: " + option.getText());

                //Doing the assertion after selecting
                Assert.assertTrue(option.isSelected() );
            }
            //        5. Deselect all values.
            languages.deselectAll();

            //Asserting they are de-selected
        for (WebElement option1 : allOptions)   {
            Assert.assertFalse(option1.isSelected());
        }

        driver.close();
        //Use all Select options
        }
}

