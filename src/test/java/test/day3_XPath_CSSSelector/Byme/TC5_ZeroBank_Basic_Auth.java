package test.day3_XPath_CSSSelector.Byme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_ZeroBank_Basic_Auth {
    public static void main(String[] args) {
//        TC #5: Basic authentication Zero Bank
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

//        3. Enter username: username
        driver.findElement(By.name("user_login")).sendKeys("username");

//        4. Enter password: password
        driver.findElement(By.name("user_password")).sendKeys("password");

//        5. Click sign in button
        driver.findElement(By.name("submit")).click();

//        6. Verify username is displayed on the page
       String username = driver.findElement(By.linkText("username")).getText();
       if (username.equals("username")) {
           System.out.println("Username verification PASSED!");
       }else {
           System.out.println("Username verification FAILED!");
       }

//        7. Verify the title Zero – Account Summary
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Zero - Account Summary")) {
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }
//        8. Verify the link Account Summary’s href value contains: “account-summary”
//        Print out results in validation formats

       String AccountSummaryHref = driver.findElement(By.linkText("Account Summary")).getAttribute("href");

        if (AccountSummaryHref.contains("account-summary")) {
            System.out.println("Account Summary link verification PASSED!");
        }else {
            System.out.println("Account Summary link verification FAILED!");
        }

    }
}
