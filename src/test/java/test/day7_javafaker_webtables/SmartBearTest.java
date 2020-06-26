package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtilities.login(driver);

        //3Enter username: "Tester
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");

        //4. Enter password: "test"
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")) ;
        loginButton.click();

    }

    @Test
    public void p1_smartbear_login_test() {

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of the links: " + allLinks.size());
        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();

        Assert.assertEquals(actualNumberOfLinks, 6);

        //7. Print out each link text on this page
        for (WebElement link : allLinks) {
            System.out.println(link.getText() );
        }










    }

    @Test
    public void p2_smartbear_order_placing() throws Exception {
        //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: "Tester"
        //4. Enter password: "test"
        //5. Click on Login button
        //All above done in BeforeMethod

        //6. Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //quantityInput.clear();
        Thread.sleep(1000);
        quantityInput.sendKeys(Keys.BACK_SPACE + "2"); //Immitating as if the user is pressing BACKSPACE to clear and than input 2

        //8. Click to "Calculate" button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        WebElement inputCustomerName= driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();
            //• Generate: name, street, city, state, zip code
        inputCustomerName.sendKeys(faker.name().fullName() );
        inputStreet.sendKeys(faker.address().streetName());
        inputCity.sendKeys(faker.address().city());
        inputState.sendKeys(faker.address().state());
        String zipcode = (faker.address().zipCode().replaceAll("-",""));
        inputZipCode.sendKeys(zipcode);
        //inputZipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //10. Click on "visa" radio button
        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        //11. Generate card number using JavaFaker
        WebElement cardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6") );
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-","") );

        WebElement expirationDateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDateInput.sendKeys("12/25");

        //12. Click on "Process"
        WebElement processButton = driver.findElement(By.xpath("//a[.='Process']")) ;
        processButton.click();

        //13.Verify success message "New order has been successfully added."
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue( successMessage.isDisplayed() );



    }

    @Test
    public void p3_smartbear_software_order_verification() {
        //TC#3: Smartbear software order verification
        //1. Open browser and login to Smartbear software
        //2. Click on View all orders

        WebElement allOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        allOrders.click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
       //WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']//../td[5]"));
        WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String actualDate = susansDate.getText();
        String expectedDate = "01/05/2010";

       Assert.assertEquals(actualDate,expectedDate);




    }

}
