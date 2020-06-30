package test.day9_testbase_properties_driverUtil.Home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC10_SmartBear_editOrder {
//TC #10: SmartBear edit order
// 1. Open browser and login to SmartBear
// 2. Click to edit button from the right for “Steve Johns”
// 3. Change name to “Michael Jordan”
// 4. Click Update
// 5. Assert “Michael Jordan” is in the list

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test_editOrder () throws Exception {
        SmartBearUtilities.login(driver);
        WebElement editButton = driver.findElement(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']//tr[4]//td[13]"));
        editButton.click();

        Thread.sleep(3000);
        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        nameInput.clear();
        nameInput.sendKeys("Michael Jordan");
        //nameInput.sendKeys(Keys.BACK_SPACE + "Michael Jordan");

        Thread.sleep(3000);
        WebElement update = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        update.click();

        Thread.sleep(3000);
        String expectedName = "Michael Jordan";
        String actualName = driver.findElement(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']//tr[4]//td[2]")).getText();

        Assert.assertEquals(expectedName,actualName);


    }




}
