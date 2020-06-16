package test.day4_findElements_checkbox_radio.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.Arrays;
import java.util.List;

public class P03_FindElements_Apple {
    /*
    public static void main(String[] args) throws Exception{


        //INCORRECT:
        //TC #03: FINDELEMENTS_APPLE
        // 1. Open Chrome browser
        // 2. Go to https://www.apple.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // 3. Click to all of the headers one by one a. Mac, iPad, iPhone, Watch, TV, Music, Support
        // 4. Print out how many links on each page with the titles of the pages
        // 5. Loop through all

        Thread.sleep(30000);

        List<WebElement> headerList = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li//a//span"));
        int linkWithTitle=0;
        int linkWithoutTitle=0;

        Thread.sleep(1000);
        for (int i =0; i < headerList.size(); i++ ) {
            headerList.get(i).click();

            Thread.sleep(5000);
            List<WebElement> links = driver.findElements(By.xpath("//body//a"));
            String title = driver.getTitle();
            for (WebElement each : links) {
                if (each.getText().contains(title)) {
                    linkWithTitle++;
                    System.out.println(each.getAttribute("value") + linkWithTitle);
                } else {
                    linkWithoutTitle++;
                }
            }
            driver.navigate().back();
        }

            // 6. Print out how many link is missing text TOTAL
            System.out.println("Links without title text: " + linkWithoutTitle);

            // 7. Print out how many link has text TOTAL
            System.out.println("Links with title text: " + linkWithTitle);

            // 8. Print out how many total link TOTAL
            System.out.println("Total links: " + linkWithoutTitle + linkWithTitle);
        }
    }

     */

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            //1.Open Chrome browser
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            //2.Go to https://www.apple.com
            driver.get("https://www.apple.com");
            // 3.Click to all of the headers one by one a.Mac, iPad, iPhone, Watch, TV, Music, Support
            List<WebElement> headerLinks = Arrays.asList(driver.findElement(By.xpath("(//a[starts-with(@class,'ac-gn-link ac-gn-link')])[4]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class,'ac-gn-link ac-gn-link')])[5]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class,'ac-gn-link ac-gn-link')])[6]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class,'ac-gn-link ac-gn-link')])[7]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class,'ac-gn-link ac-gn-link')])[8]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class,'ac-gn-link ac-gn-link')])[9]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class,'ac-gn-link ac-gn-link')])[10]")));

            headerLinks.get(i).click();
            int missedText = 0;
            int withText = 0;
            int totalLinks = 0;
            List<WebElement> pagelinks = driver.findElements(By.xpath("//body//a"));
            totalLinks += pagelinks.size();

            for (WebElement each : pagelinks) {
                String link = each.getText();
                if (link.isEmpty()) {
                    missedText++;
                } else {
                    withText++;
                    System.out.println(link);
                }
            }
            System.out.println("Missing text liks are " + missedText);
            System.out.println("Links with text are " + withText);
            System.out.println("Total links are " + totalLinks);

            driver.close();
        }

    }
}


