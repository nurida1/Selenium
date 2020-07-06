package test.office_hours;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderPractice {
    private static Properties properties;
    WebDriver driver;

    static {
        //click on FileInputStream and read
        //try with resources used to automatically close input stream
        try (FileInputStream fileInputStream = new FileInputStream("src\\test\\resources\\config.properties")) { //copy path from content root
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public String getProperty(String key){
            return properties.getProperty(key);
        }



    /*
    To go into the method /class implementation click and hold control/command and make a click
    @param args
     */
    public static void main(String[] args) {
        String browser = properties.get("browser").toString();
        System.out.println(browser);
        // you will get null, if there is no such property
        System.out.println(properties.getProperty("url"));

    }
    @Test
    public void loginTest() {
        String browser = getProperty("browser");
        String URL = getProperty("url");
        String username = getProperty("username");
        String password = getProperty("password");

        driver = WebDriverFactory.getDriver(browser);
        driver.get(URL);
        System.out.println("Page title :: " + driver.getTitle());
        //login
        driver.findElement(By.id("prependedInput")).sendKeys(username   );
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        Assert.assertEquals(actual,expected,"Page title is not correct");
    }

    //after method to automatically close the browser
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

        //static - because it's easy to call through class name

}

