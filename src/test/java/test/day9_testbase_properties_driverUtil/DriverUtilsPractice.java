package test.day9_testbase_properties_driverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DriverUtilsPractice {

    @Test
    public void driver_practice() {
        Driver.getDriver().get("https://google.com");
        //Singleton.getWprd();
        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));
        googleSearch.sendKeys(ConfigurationReader.getProperty("testdata") + Keys.ENTER);


    }


    @Test (priority = 2)
    public void singleton_practice() {
         String str1 = Singleton.getWord(); //null
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);  //str2 = something

        String str3 = Singleton.getWord();      //Word already has value
        System.out.println("str3 = " + str3);  //str3 = something
    }

    @Test (priority = 1)
    public void singleton_practice2() {
        String str4 = Singleton.getWord();    //Word already has value
        System.out.println("str4 = " + str4); //str4 = something
    }




}
