package test.day4_findElements_checkbox_radio.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class P07_FindElements {
    /*
    TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Hint: Need to use findElements method.
     */
    public static void main(String[] args) throws Exception{

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
                                                            //button[.='Add Element']
        for (int i=1; i <=50; i++) {
            addElement.click();
        }

        Thread.sleep(3000);
        //4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement>listOfDeleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("Number of delete buttons on the page: " + listOfDeleteButtons.size());


        Thread.sleep(3000);
        //5. Click to ALL “Delete” buttons to delete them.
        for (WebElement button : listOfDeleteButtons) {
            button.click();
        }

        Thread.sleep(3000);
        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            if (!deleteButton.isDisplayed()) {
                System.out.println("Delete button is NOT displayed after clicking. PASS!");
            } else {
                System.out.println("Delete button is displayed after clicking. FAILED!");
            }
        } catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element has been completely deleted from the HTML.");
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }
    }
}

