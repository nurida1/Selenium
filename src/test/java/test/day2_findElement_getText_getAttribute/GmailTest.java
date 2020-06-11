package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailTest {

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        driver.get("https://google.com");
//        driver.navigate().refresh();
//        String actualTitle = driver.getTitle();
//        if (actualTitle.equals("Google")) {
//            System.out.println("Title verification PASSED!");
//        }

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        String actualTitle = driver.getTitle();

        if (actualTitle.equals("Amazon")) {
            System.out.println("Title verification passed!");
        }else {
            System.out.println("Title verification failed!");
        }

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lipstick" + Keys.ENTER);

        //driver.findElement(By.name("identifier")).sendKeys("17nurida@gmail.com" + Keys.ENTER);
        Thread.sleep(40000);
        driver.close();
    }
}
