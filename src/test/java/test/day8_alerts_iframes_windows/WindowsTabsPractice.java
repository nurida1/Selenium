package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {
    //#5
    //TC	#	:	Window	Handle	practice
    //1. Create	a	new	class	called:	WindowHandlePractice
    // 2. Create	new	test	and	make	set	ups
    // 3. Go	to	:	http://practice.cybertekschool.com/windows
    // 4. Assert:	Title	is	“Practice”
    // 5. Click	to:	“Click	Here”	text
    // 6. Switch	to	new	Window.
    // 7. Assert:	Title	is	“New	Window”

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void p5_window_handle_practice() {
        String currentWindowHandle = driver.getWindowHandle();

        System.out.println("currentWindowHandle = " + currentWindowHandle);//currentWindowHandle = CDwindow-34631783B99BA243C36187D127472849

        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        System.out.println("BEFORE CLICKING" + driver.getTitle()); //Practice
        clickHereLink.click();
        System.out.println("AFTER CLICKING" + driver.getTitle()); //Practice - > because we need to switch the window, because it's looking for previous window

        //driver.getWindowHandles() --> returns us A SET of Strings //SET- doesn't allow duplicates

        Set<String> windowHandles = driver.getWindowHandles();

//        for (String each : driver.getWindowHandles()) { //to switch between window handles
 /*
            for (String each : windowHandles) {
                System.out.println("BEFORE SWITCHING");
            driver.switchTo().window(each);
                System.out.println("AFTER SWITCHING");
                System.out.println(driver.getTitle() );
   */
       /*
        //We need to switch between windows:
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getTitle().equals("New Window")) {
                Assert.assertTrue(driver.getTitle().equals("New Window"));
                break; //if matching it will assert and it will break the loop
            }}
        */

        //We need to switch between windows:
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println(driver.getTitle());
        }
        //switching to previous window:
        driver.switchTo().window(currentWindowHandle);
        System.out.println(driver.getTitle() );



    }







}
