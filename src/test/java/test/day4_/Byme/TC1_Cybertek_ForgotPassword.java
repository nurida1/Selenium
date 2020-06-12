package test.day4_.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class TC1_Cybertek_ForgotPassword {

    /*
        //XPATH PRACTICES DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/forgot_password
           //3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        //a. “Home” link b. “Forgot password” header c. “E-mail” text d. E-mail input box e. “Retrieve password” button f. “Powered by Cybertek School” text

     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

        //b. “Forgot password” header
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[contains(@text,Forgot)]"));
        //h2
        ////h2[contains(@text,Forgot)]
        //h2[.='Forgot Password']
        ///html/body/div/div/div/div/h2

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label")); //"/html/body/div/div/div/div/form/div/div/label"

       //d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.xpath("//input")); //"/html/body/div/div/div/div/form/div/div/input"

        // e. “Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.xpath("/html/body/div/div/div/div/form/button"));


        // f. “Powered by Cybertek School” text
        WebElement cybertekSchoolText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));


        //4. Verify all WebElements are displayed.
        //a. “Home” link
        if (homeLink.isDisplayed()) {
            System.out.println("Home link is displayed on the page. PASS!");
        } else {
            System.out.println("Home link is displayed on the page. FAIL!");
        }

        //b. “Forgot password” header
        if (forgotPasswordHeader.isDisplayed()) {
            System.out.println("Forgot password header is displayed. PASS!");
        }else {
            System.out.println("Forgot password header is displayed. FAIL!");
        }

        //c. “E-mail” text
        if (emailText.isDisplayed()) {
            System.out.println("Email text is displayed. PASS!");
        }else {
            System.out.println("Email text is displayed. FAIL!");
        }

        //d. E-mail input box
        if (emailInputBox.isDisplayed()) {
            System.out.println("Email input box is displayed. PASS!");
        }else {
            System.out.println("Email input box is displayed. FAIL!");
        }

        // e. “Retrieve password” button
        if (retrievePasswordButton.isDisplayed()) {
            System.out.println("Retrieve password button is displayed. PASS!");
        }else {
            System.out.println("Retrieve password button is displayed. FAIL!");
        }

        // f. “Powered by Cybertek School” text
        if (cybertekSchoolText.isDisplayed()) {
            System.out.println("Powered by Cybertek School is displayed. PASS!");
        }else {
            System.out.println("Powered by Cybertek School is displayed. FAIL!");
        }
    }

}
