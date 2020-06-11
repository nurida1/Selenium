package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_ZeroBank_HeaderVerification {
    public static void main(String[] args) {

        //TC #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        String actualHeader = driver.findElement(By.className("page-header")).getText();

        if (actualHeader.equals("Log in to ZeroBank")) {
            System.out.println("Header text verification PASSED!");
        }else {
            System.out.println("Header text verification FAILED!");
        }




    }

}
