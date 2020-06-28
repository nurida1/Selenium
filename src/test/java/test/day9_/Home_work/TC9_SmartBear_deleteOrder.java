package test.day9_.Home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;

public class TC9_SmartBear_deleteOrder {
    //TC #9: SmartBear delete order
    // 1. Open browser and login to SmartBear
    // 2. Delete “Mark Smith” from the list
    // 3. Assert it is deleted from the list

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test
    public void test_deleteOrder () throws Exception {
        SmartBearUtilities.login(driver);
        WebElement checkBox =  driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        checkBox.click();

        WebElement deleteButton = driver.findElement(By.xpath("//input[@type='submit']"));
        deleteButton.click();

        List<WebElement> names = driver.findElements(By.xpath("//table[@id ='ctl00_MainContent_orderGrid']//tr//td[2]"));
        Thread.sleep(3000);
        for (WebElement each : names ) {
            Assert.assertTrue(!each.getText().contains("Mark Smith"));
            //Assert.assertFalse(each.getText().contains("Mark Smith"));
            }
        }
    }
