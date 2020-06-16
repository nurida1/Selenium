package test.day4_findElements_checkbox_radio.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_FindElements_Apple2 {
    public static void main(String[] args) throws Exception {
        //TC #03: FINDELEMENTS_APPLE
        // 1. Open Chrome browser
        // 2. Go to https://www.apple.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // 3. Click to all of the headers one by one a. Mac, iPad, iPhone, Watch, TV, Music, Support
        // 4. Print out how many links on each page with the titles of the pages
        // 5. Loop through all

        int totalLinksWithTitle = 0;
        int totalLinksWithoutTitle = 0;
        int GrandTotL;

        for (int i = 0; i < 7; i++) {
            List<WebElement> headerLinks = Arrays.asList(driver.findElement(By.xpath("//ul[@class='ac-gn-list']//li[2]")),
                    driver.findElement(By.xpath("//ul[@class='ac-gn-list']//li[3]")),
                    driver.findElement(By.xpath("//ul[@class='ac-gn-list']//li[4]")),
                    driver.findElement(By.xpath("//ul[@class='ac-gn-list']//li[5]")),
                    driver.findElement(By.xpath("//ul[@class='ac-gn-list']//li[6]")),
                    driver.findElement(By.xpath("//ul[@class='ac-gn-list']//li[7]")),
                    driver.findElement(By.xpath("//ul[@class='ac-gn-list']//li[8]")));

            headerLinks.get(i).click();
            String title = driver.getTitle();
            System.out.println(title);
            int linksWithTitle = 0;
            int linksWithoutTitle = 0;
            int totalLinks = 0;

            List<WebElement> links = driver.findElements(By.xpath("//body//a"));
            totalLinks = links.size();

            for (WebElement each : links) {
                String linkText = each.getText();
                if (title.contains(linkText)) {
                    linksWithTitle++;;
                } else {
                    linksWithoutTitle++;
                }
            }
            driver.navigate().back();

            // 6. Print out how many link is missing text TOTAL
            System.out.println("Links without title text: " + linksWithoutTitle);

            // 7. Print out how many link has text TOTAL
            System.out.println("Links with title text: " + linksWithTitle);

            // 8. Print out how many total link TOTAL
            System.out.println("Total links: " +totalLinks);
        }
    }
}