package test.day5_testng_intro;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGClass {

    //annotations control which methods will run first

    @BeforeMethod   //runs before each method that has @Test annotation
                    //this is useful when u want to make a driver setups
    public void setUp(){
        System.out.println("Before method running...");
    }

    @AfterMethod
    public void tearDown() { //tearDown - anything related to closing. Closing quitting driver. Closing browser.
        System.out.println("After method runnning...");
    }

    @Test
    public void test1() {
        System.out.println("Test1 is running...");

    }

    @Test
    public void test2() {
        System.out.println("Test2 is running...");
    }

}
