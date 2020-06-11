package test.day3_XPath_CSSSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeroBankURLVerification {

    public static void main(String[] args) {

        //TC #4: Zero Bank URLverification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Get attribute value of href from the “forgot your password”link
       //WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password ?"));
        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot"));
        // 4.Verify attribute value contains
        // Expected: “/forgot-password.html”
        // SOLUTION: NEXT PAGE.
        String actualHrefValue = forgotPasswordLink.getAttribute("href");
        String expectedInHrefValue = "/forgot-password.html";

        System.out.println("actualHrefValue = " +actualHrefValue);
        // Try to solve yourself before looking at the solution.Hint: Locate the “Forgot your password ?” link,
        // and use getAttribute value method to get the link behind the attribute within.

        if (actualHrefValue.contains(expectedInHrefValue)) {
            System.out.println("Href value verification PASSED!");
        }else {
            System.out.println("Href value verification FAILED!");
        }

        System.out.println("Is forgot password displayed? " + forgotPasswordLink.isDisplayed());

    }
}
