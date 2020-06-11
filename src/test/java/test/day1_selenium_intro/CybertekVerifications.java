package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC	#2:	Cybertek	verifications
1. Open	Chrome	browser
2. Go	to	https://practice.cybertekschool.com
3. Verify	URL	contains
Expected:	cybertekschool
4. Verify	title:
							Expected:	Practice
 */
public class CybertekVerifications   {

    public static void main(String[] args) throws Exception  {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(3000);

        String actualURL =  driver.getCurrentUrl();
        String expectedURL = "cybertekschool";

        if (actualURL.contains(expectedURL)) {
            System.out.println("URL verification Passed!");
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification Passed!");
        }

        Thread.sleep(3000);
        driver.close();





    }



}
