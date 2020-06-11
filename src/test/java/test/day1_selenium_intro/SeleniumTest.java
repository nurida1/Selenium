package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException{
        //1- set up the web driver
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the chrome driver to be able to do action on ChromeBrowser
        WebDriver driver = new ChromeDriver();

        //The line below maximizes the browser page after opening it.
        driver.manage().window().maximize();
//        driver.manage().window().fullscreen(); or u can use this to maximize the window

        //TO use firefox driver
        //WebDriver driver = new FirefoxDriver();

        //3- test if driver is working
        //String googleURL = "https:www.google.com"; or u can do this
        driver.get("https://www.google.com");

        System.out.println("driver.getTitle() --> " + driver.getTitle() );
        System.out.println("driver.getCurrentUrl() --> " + driver.getCurrentUrl() );

        //BROWSER NAVIGATIONS
        //this line will take user to the previous page
        Thread.sleep(2000);  //this line adds 2000 miliseconds of wait = 2 seconds
        driver.navigate().back();

        //Thread.sleep is being added just to be able to see selenium movements
        Thread.sleep(2000); //Thread.sleep
        driver.navigate().forward(); //This line will go to the next page

        Thread.sleep(2000);
        driver.navigate().refresh(); //This line will refresh the page

        driver.navigate().to("https://www.facebook.com");

        System.out.println("driver.getTitle() --> " + driver.getTitle() );
        System.out.println("driver.getCurrentUrl() --> " + driver.getCurrentUrl() );

        System.out.println( driver.getPageSource() );

        //driver.manage().window().maximize();

        driver.close();

    }



}
