package test.day9_.Home_work;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC3_info_alert_practice {
    /*
    TC #3: Information alert practice
    1. Open browser
    2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    3. Click to “Click for JS Prompt” button
    4. Send “hello” text to alert
    5. Click to OK button from the alert
    6. Verify “You entered:  hello” text is displayed.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test_JS_prompt () {

        WebElement prompt_Alert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        prompt_Alert.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        String expectedText = "You entered: hello";
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualText.equals(expectedText));
        }


    }



















