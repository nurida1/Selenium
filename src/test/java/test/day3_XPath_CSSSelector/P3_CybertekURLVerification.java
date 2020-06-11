package test.day3_XPath_CSSSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CybertekURLVerification {
    public static void main(String[] args) {

    //C #3: PracticeCybertek/ForgotPassword URL verification
    // 1.Open Chrome browser
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    // 2.Go to http://practice.cybertekschool.com/forgot_password
    driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
        String sentence = "this is a sentence";
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("anyemail@email.com");

    // 4.Click on Retrieve password
        // driver.findElement(By.id("form_submit")).click();
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

    // 5.Verify URL contains: Expected: “email_sent”
       String actualURL = driver.getCurrentUrl();
       String expectedInURL = "email_sent";
        System.out.println("The current URL: " + actualURL);

       if (actualURL.contains(expectedInURL)) {
           System.out.println("URL verification PASSED!");
       }else {
           System.out.println("URL verification FAILED!");
       }


    // 6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”
        //String confirmationMessage = driver.findElement(By.name("confirmation_message"));
        WebElement confirmationMessage =  driver.findElement(By.name("confirmation_message"));

        String actualMessage = confirmationMessage.getText();
        String expectedMessageText = "Your e-mail's been sent!";

        //System.out.println("actual message: " + actualMessage);

        if (actualMessage.equals(expectedMessageText)) {
            System.out.println("Confirmation message text verification PASSED!");
        }else {
            System.out.println("Confirmation message text verification FAILED!");
        }

        if (confirmationMessage.isDisplayed()) { //returns boolean
            System.out.println("Message is displayed, verification PASSED!"); //if true
        }else {
            System.out.println("Message is not displayed, verification FAILED!");
        }


    }
}
