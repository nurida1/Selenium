package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) {


        //TC#4:	Google	search
        //1-Open	a	chrome	browser
        // for manual importing windows:alt+enter; Mac: option + enter
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2-Go	to:	https://google.com
        driver.get("https://google.com");

        //3-Write	“apple”	in	search	box
       // driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER); //imitating pressing "ENTER"
        driver.findElement(By.name("q")).sendKeys("apple");

        //4-Click	google	search	button
        driver.findElement(By.name("btnK")).click(); //click the search button

        //5-Verify	title:Expected:	Title	should	start	with	“apple”
        String actualTitle = driver.getTitle();
        String expectedInTitle = "apple";

        if (actualTitle.startsWith(expectedInTitle)) {
            System.out.println("Google search title verification PASSED!");
        }else {

            System.out.println("Google search title verification FAILED!");
        }




    }

}
