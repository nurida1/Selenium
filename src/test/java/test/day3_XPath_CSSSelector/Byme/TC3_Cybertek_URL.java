package test.day3_XPath_CSSSelector.Byme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_Cybertek_URL {

    public static void main(String[] args) {

//        TC #3: PracticeCybertek/ForgotPassword URL verification
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

//        2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

//        3. Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("17nurida@gmail.com");  //By name
        //By tagName: driver.findElement(By.tagName("input")).sendKeys("17nurida@gmail.com");

//        4. Click on Retrieve password
        //driver.findElement(By.id("form_submit")).click();
        driver.findElement(By.className("radius")).click();

//        5. Verify URL contains:  Expected: “email_sent”
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        if (actualURL.contains(expectedURL)) {
            System.out.println("URL verification PASSED!");
        } else {
            System.out.println("URL verification FAILED");
        }

//        6. Verify textbox displayed the content as expected. Expected: “Your e-mail’s been sent!”
//        Hint: You need to use getText method for this practice.
        WebElement h4 = driver.findElement(By.tagName("h4"));
//        WebElement h4 = driver.findElement(By.name("confirmation_message"));

        String actualText = h4.getText();
        String expectedText = "Your e-mail's been sent!";

        if (actualText.equals(expectedText)) {
            System.out.println("Textbox verification PASSED!");
        }else {
            System.out.println("Textbox verification FAILED!");
        }

    }

    }


