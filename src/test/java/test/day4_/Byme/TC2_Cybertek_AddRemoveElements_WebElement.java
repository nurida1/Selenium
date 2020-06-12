package test.day4_.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC2_Cybertek_AddRemoveElements_WebElement {

    /*
    TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/add_remove_elements

     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();
        //driver.findElement(By.xpath("//button [.= 'Add Element']"));

        //4. Verify “Delete” button is displayed after clicking.
       WebElement deleteButton =  driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
       deleteButton.isDisplayed();
       // driver.findElement(By.xpath("//button[.='Delete']"));
        //driver.findElement(By.xpath("//button[contains(@onclick,deleteElement)]"));

        //5. Click to “Delete” button.
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.

        WebElement deleteButtonNotDisplayed = driver.findElement(By.xpath("//div[@id='elements']"));
       if (deleteButtonNotDisplayed.isDisplayed()) {
           System.out.println("Delete button is not displayed, PASS!");
       }else {
           System.out.println("Delete button is NOT displayed, FAIL");
       }


    }


}
