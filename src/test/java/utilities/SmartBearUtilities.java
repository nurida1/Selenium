package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {
    /*
Mini-Task: • Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter
     */
    public static void login(WebDriver driver){
        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

    }
/*
PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in SmartBearUtils class.
• Method takes WebDriver object and String(name).
•Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether given name is in the list or not.
 */
    public static void verifyOrder(WebDriver driver, String name) {
       List<WebElement> names = driver.findElements(By.xpath("//div//td[2]"));
        String actualName = "";
        String expectedName = name;

        for (WebElement each : names ) {
            if (each.getText().equals(expectedName)) {
                actualName += each.getText();
            }
        }
          Assert.assertTrue(actualName.equals(expectedName));

      }

//Practice #5: Method: printNamesAndCities
// • Create a method named printNamesAndCities in SmartBearUtils class.
// • Method takes WebDriver object.
// • This method should simply print all the names in the List of All Orders.
// • Create a new TestNG test to test if the method is working as expected.
// • Output should be like:
// • Name1: name , City1: city
// • Name2: name , City2: city

    public static void printNamesAndCities (WebDriver driver) {

        List<WebElement> names = driver.findElements(By.xpath("//table[@class = 'SampleTable']//td[2]" ) );
        List<WebElement> cities = driver.findElements(By.xpath("//table[@class = 'SampleTable']//td[7]") );

        int count = 1;
        int i = 0;
        for (WebElement each : names) {
            System.out.println("Name" +count+": " + each.getText() + ", " + ("City" + count+": "+cities.get(i).getText()) );
            count ++;
            i++;
        }

    }
}






















