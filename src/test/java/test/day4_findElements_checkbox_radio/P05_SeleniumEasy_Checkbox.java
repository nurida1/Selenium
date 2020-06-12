package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Checkbox {
    public static void main(String[] args) throws Exception{

//        TC #2: SeleniumEasy Checkbox Verification – Section 1
//        1. Open Chrome browser
//        2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

//        3. Verify “Success – Check box is NOT checked” message is NOT displayed.
       WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        //WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));

       WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));
       //WebElement message = driver.findElement(By.xpath("//div[.='Success - Check box is checked']"));

        if (!successCheckbox.isSelected() && !successMessage.isDisplayed()) {
            System.out.println("Default value verification PASSED!");
        }else {
            System.out.println("Default value verification FAILED!");
        }

//        4. Click to checkbox under “Single Checkbox Demo” section
        Thread.sleep(3000);
        successCheckbox.click();

//        5. Verify “Success – Check box is checked” message is displayed.
        if (successCheckbox.isSelected() && successMessage.isDisplayed()) {
            System.out.println("Success - Check box is checked and message is displayed. Verification PASSED!");
        }else {
            System.out.println("Success - Check box is checked and message is displayed. Verification FAILED!");

        }

    }

}
