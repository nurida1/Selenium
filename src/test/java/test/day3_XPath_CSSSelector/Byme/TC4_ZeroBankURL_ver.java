package test.day3_XPath_CSSSelector.Byme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_ZeroBankURL_ver {
    public static void main(String[] args) {

//        TC #4: Zero Bank URL verification
//        1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

//        3. Get attribute value of href from the “forgot your password” link
        //System.out.println( driver.getAttribute("href"));

        String attributeValue = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
//        4. Verify attribute value contains Expected: “/forgot-password.html”

        if (attributeValue.contains("/forgot-password.html")) {
            System.out.println("Attribute value verification PASSED!");
        }else {
            System.out.println("Attribute value verification FAILED!");
        }

//        SOLUTION: NEXT PAGE. Try to solve yourself before looking at the solution.
//                Hint: Locate the “Forgot your password ?” link, and use getAttribute value method to get the link behind the attribute within.




    }


}
