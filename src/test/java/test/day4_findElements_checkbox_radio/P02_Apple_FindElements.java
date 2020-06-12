package test.day4_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P02_Apple_FindElements {

    public static void main(String[] args) throws Exception{
        //    TC #02: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        //2. Go to https://www.apple.com

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");

        // 3. Click to iPhone
        //WebElement iPhone = driver.findElement(By.xpath("//span[.='iPhone']"));
        //WebElement iPhone = driver.findElement(By.xpath("(//a[href='/iphone/'])[1]"));
        //WebElement iPhone = driver.findElement(By.xpath("(//a[@data-analytics-title='iphone'])[1]"))
        //WebElement iPhone = driver.findElement(By.xpath("//span[.='iPhone']/..")); //locating a child and going to parent
        //driver.findElements(By.name("a")); //returns a list of elements
        //WebElement iPhone = driver.findElement(By.xpath("//*[@class='ac-gn-link ac-gn-link-iphone']"));
        //WebElement iPhone = driver.findElement(By.xpath("//*[@class='ac-gn-link ac-gn-link-iphone']/a")); locate a unique parent, than move to the child by using /

        WebElement iphoneLink = driver.findElement(By.xpath("//span[.='iPhone']/.."));
        Thread.sleep(3000);
        iphoneLink.click();

        //4. Print out the texts of all links
        //we need to locate all of the links on the page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithoutText = 0;
        int linksWitText = 0;

        for (WebElement link : allLinks) {
            String textOfLinks = link.getText();
            System.out.println(textOfLinks);
            if (textOfLinks.isEmpty()) {
                linksWithoutText++;
            }else {
               //linksWitText += allLinks.size()-linksWithoutText; //size - without links
               linksWitText++;
            }

        }
        //5. Print out how many link is missing text
        System.out.println("Number of links without texts ==> " +linksWithoutText);

        //6. Print out how many link has text
        System.out.println("Number of links with text ==> " + linksWitText);

        //7. Print out how many total link
        System.out.println("Number of total links: " + allLinks.size());



    }
}
