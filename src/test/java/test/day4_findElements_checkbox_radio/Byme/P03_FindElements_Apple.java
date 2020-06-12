package test.day4_findElements_checkbox_radio.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class P03_FindElements_Apple {
    public static void main(String[] args) {
        //TC #03: FINDELEMENTS_APPLE
        // 1. Open Chrome browser
        // 2. Go to https://www.apple.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");

        // 3. Click to all of the headers one by one a. Mac, iPad, iPhone, Watch, TV, Music, Support
        WebElement mac = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        mac.click();
        driver.navigate().back();

        WebElement iPad = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));
        iPad.click();
        driver.navigate().back();

        WebElement iPhone = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iPhone.click();
        driver.navigate().back();

        WebElement watch = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']"));
        watch.click();
        driver.navigate().back();

        WebElement tv = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tv']"));
        tv.click();
        driver.navigate().back();

        WebElement music = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-music']"));
        music.click();
        driver.navigate().back();

        WebElement support = driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-support']"));
        support.click();
        driver.navigate().back();

        // 4. Print out how many links on each page with the titles of the pages


        // 5. Loop through all


        // 6. Print out how many link is missing text TOTAL


        // 7. Print out how many link has text TOTAL


        // 8. Print out how many total link TOTAL


    }
}
