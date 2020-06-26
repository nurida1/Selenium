package test.day6_testing_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice { //TestNg checks annotations and runs according to them

    @BeforeClass
    public void before_class() {
        System.out.println("BeforeCLASS is running! -------------------------");
    }

    @AfterClass
    public void after_class() {
        System.out.println("AfterCLASS is running! ---------------------------");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method is runnning...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running");
    }

    @Test
    public void test1() {
        System.out.println("Test1 running");
        String actualTitle = "Homepage"; //driver.getTitle();
        String expectedTitle = "Homepage";

        Assert.assertEquals(actualTitle, expectedTitle);

        //The same as if else statement:
//        if (actualTitle.equals(expectedTitle)) {
//            System.out.println("Title verification passed!");
//        }else {
//            System.out.println("Title verification failed!");
//        }
    }

    @Ignore //ignores the method execution
    @Test //every time you need to individually identify what kind of annotations  you want to apply
    public void test2() {
        System.out.println("Test2 is running");

        Assert.assertEquals("string1", "string2", "String verification on test2 failed");
        //message is optional, will be executed if false
    }

    //@BeforeClass: runs one time
        // -> BeforeClass makes the annotated method run ONCE before all of the test in the class.
        // -> Runs even before the BeforeMethod
        // -> Used for setting up environments, opening browsers, etc.

        // -> If you want to open just one browser and run all of your tests in that browser, you can put
        // WebDriver driver = new ChromeDriver(); into before class
        //If you need to open a browser for EACH TEST, you need  to put that line into BeforeMethod

    //@After Class:
        //-> After class makes the annotated method run once after the tests in the class

    @Test
    public void test3() {
        System.out.println("Test3 is running....");

        String actualTitle = "Amazon prime";
        String expectedTitle = "prime";
        String testString = "asdofjasdf";

        //if the boolean value we pass in assertTrue is "true", assertion will pass.
        //else it will fail

        //Assert.assertTrue(false);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Assert.assertTrue(actualTitle.contains(testString));
            System.out.println("JUST CHECKING IF THIS LINE IS RUNNING");
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /*
    BeforeCLASS is running! -------------------------

Before Method is runnning...

Test1 running

After method is running

Before Method is runnning...

Test3 is running....
JUST CHECKING IF THIS LINE IS RUNNING

After method is running

AfterCLASS is running! ---------------------------
===============================================
Default Suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================
     */





}
