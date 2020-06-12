package test.day4_findElements_checkbox_radio.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P02_FindElements_Apple {

    public static void main(String[] args) {
        //TC #02: FINDELEMENTS_APPLE
        // 1. Open Chrome browser
        // 2. Go to https://www.apple.com

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 3. Click to iPhone
        WebElement iPhoneButtonClick = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        //WebElement iPhoneButtonClick = driver.findElement(By.xpath("//li[4]//a"));
        iPhoneButtonClick.click();

        // 4. Print out the texts of all links
        int linksWithoutText = 0;
        int linksWithText = 0;

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
       for (WebElement eachLink : listOfLinks) {

           String textOfEachLink = eachLink.getText();

           if (textOfEachLink.isEmpty()) {
               linksWithoutText++;
           } else {
               System.out.println(textOfEachLink);
               linksWithText++;
           }
       }
        // 5. Print out how many link is missing text
        System.out.println("Number of links that does NOT have text: " + linksWithoutText);

        // 6. Print out how many link has text
        System.out.println("Number of links that have text: " + linksWithText);

        // 7. Print out how many total link
        System.out.println("Total links: " + listOfLinks.size());

    }
}
