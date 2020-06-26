package test.day8_alerts_iframes_windows.Home_work;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P6_Cybertek_registrationForm {
//TC#6: Cybertek registration form confirmation
// Note: Use JavaFaker when possible.
// 1. Open browser
// 2. Go to website: http://practice.cybertekschool.com/registration_form
// 3. Enter first name
// 4. Enter last name
// 5. Enter username
// 6. Enter email address
// 7. Enter password
// 8. Enter phone number
// 9. Select a gender from radio buttons
// 10. Enter date of birth
// 11. Select Department/Office
// 12. Select Job Title
// 13. Select programming language from checkboxes
// 14. Click to sign up button
// 15. Verify success message “You’ve successfully completed registration.” is displayed.

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test1 () {
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name ='firstname']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement userNameInput = driver.findElement(By.xpath("//input[@placeholder='username']"));
        WebElement emailAddress = driver.findElement(By.xpath("////input[@name='email']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement genderRadioButton = driver.findElement(By.xpath("//div[@class='radio']")); //???randomly click
        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
        Select departmentOffice = new Select(driver.findElement(By.xpath("//select[@name='department']")));  //?? dropdown
        Select jobTitle =new Select (driver.findElement(By.xpath("//select[@name='job_title']")));
        WebElement programmingLanguage = driver.findElement(By.xpath("//div[@class='form-check form-check-inline']"));
        WebElement signUp = driver.findElement(By.id("wooden_spoom"));
        //String actual = driver.findElement(By.xpath("//*[.='Well done!']/following-sibling::p")).getText();
        //WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']/p"));
        /*
        String expectedOption = "You've successfully completed registration!";
        Assert.assertTrue(driver.getPageSource().contains(expectedOption));
         */

        Faker faker = new Faker();
        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        userNameInput.sendKeys(faker.name().username());
        emailAddress.sendKeys(faker.internet().emailAddress());
        passwordInput.sendKeys(faker.internet().password());
        phoneNumberInput.sendKeys(faker.phoneNumber().cellPhone());
        genderRadioButton.click();
        dateOfBirth.sendKeys("01/02/1990");
        departmentOffice.selectByVisibleText("Accounting Office");
        jobTitle.selectByIndex(4);
        programmingLanguage.click();
        signUp.click();




    }
}
