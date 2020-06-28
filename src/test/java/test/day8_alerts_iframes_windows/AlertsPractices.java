package test.day8_alerts_iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {

/*
TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.
 */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void p1_information_alert_test() {
        //Locating the alert button to be able to click.
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //Clicking to the alert button so that the alert should pop-up
        infoAlertButton.click();

        //1 - Create the Alert instance and switch to it
        Alert alert = driver.switchTo().alert();

        //2-Use "alert" to accept the alert.
        alert.accept();

        //locating result web element
        WebElement resultText = driver.findElement(By.id("result"));

        //Asserting the result text is displayed
        Assert.assertTrue(resultText.isDisplayed());
    }

    @Test
    public void p2_confirmation_alert_test() {
        WebElement confirmationALertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationALertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();//cancel
        //alert.accept(); accept

        //locating result web element
        WebElement resultText = driver.findElement(By.xpath("p[@id = 'result']"));
        //WebElement resultText2 = driver.findElement(By.id="result");

        //Asserting the result text is displayed
        Assert.assertTrue(resultText.isDisplayed());


    }












/*
TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed
 */

}
