package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;
/*
TC #4: Iframe practice1.Create a new class called: IframePractice2.
Create new test and make set ups3.Go to: http://practice.cybertekschool.com/iframe
4.Assert: “Your content goes here.” Text is displayed.
5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
 */
public class IframePractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void iframe_practice_test() {
        //1Locating iframe as web element, then switching to it.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")); //u should locate to iframe than to the context which is inside
        //WebElement iframe2 = driver.findElement(By.tagName("iframe")); //you will just locate to general iframe

        //switching to iframe using id or name attribute value
        driver.switchTo().frame("mce_0_ifr"); //by id
        //or using index number or tag name:
        //driver.switchTo().frame(0);
        //driver.switchTo().frame(iframe);

        //4.Assert: “Your content goes here.” Text is displayed.
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //WE HAVE TO SWITCH BACK TO DEFAULT HTML TO BE ABLE TO LOCATE ANYTHING IN THERE
        driver.switchTo().parentFrame(); //to go to parent frame
        //driver.switchTo().defaultContent();

        // 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
        WebElement h3Text = driver.findElement(By.xpath("//h3"));
    }


}
