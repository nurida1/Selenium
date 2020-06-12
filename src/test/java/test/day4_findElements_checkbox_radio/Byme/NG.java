package test.day4_findElements_checkbox_radio.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class NG {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.navigate().to("http://practice.cybertekschool.com/forgot_password");
        // a. "Home" link
        WebElement element1= driver.findElement(By.xpath("//a[@class='nav-link']"));//kalip //tagName[@attributeName='value']]
        // * b. "Forgot password" header
        WebElement element2= driver.findElement(By.xpath("//h2[contains(text(),Forgot)]"));//tagName[contains(text(),text)]
        // * c. "E-mail" text
        WebElement element3=driver.findElement(By.xpath("//label[@for='email']"));//tagName[@attributeName='value']]
        // * d. E-mail input box
        WebElement element4=driver.findElement(By.xpath("//input[@name='email']"));//tagName[@attributeName='value']]
        //* e. "Retrieve password" button
        WebElement element5= driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));//tagName[@attributeName='value'
        driver.findElement(By.xpath("//i[contains(text(),Ret)]"));//text
        driver.findElement(By.xpath("//i[contains(@class,icon)]"));
        //* f. "Powered by Cybertek School" text
        WebElement element6= driver.findElement(By.xpath("//div[@style='text-align: center;']/a"));
        // * 4. Verify all WebElements are displayed.
        System.out.println(element1.isDisplayed());
        System.out.println(element2.isDisplayed());
        System.out.println(element3.isDisplayed());
        System.out.println(element4.isDisplayed());
        System.out.println(element5.isDisplayed());
        System.out.println(element6.isDisplayed());
    }
}

