package test.day4_findElements_checkbox_radio.Byme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P06_SeleniumEasy_Checkbox {

    public static void main(String[] args) throws Exception{
//        TC #3: SeleniumEasy Checkbox Verification – Section 2
//        1. Open Chrome browser
//        2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

//        3. Verify “Check All” button text is “Check All”
        WebElement checkAllButton =driver.findElement(By.xpath("//input[@id='check1']"));
        //WebElement checkAllButton =driver.findElement(By.xpath("//input[@type='button']"));
        String actualText = checkAllButton.getAttribute("value");
        String expectedText = "Check All";

        if (actualText.equals(expectedText)) {
            System.out.println("Check All button text verification PASSED!");
        }else {
            System.out.println("Check All button text verification FAILED!");
        }

//        4. Click to “Check All” button
        Thread.sleep(2000);
        checkAllButton.click();

//        5. Verify all check boxes are checked
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@class='cb1-element']"));

        for ( WebElement each: checkBoxList) {
            if (each.isSelected()) {
                System.out.println(each.getText() + "check box is checked. PASSED!");
            }else {
                System.out.println(each.getText() + "check box is not checked. FAIL!"); //getAttribute("value")
            }
        }

//        6. Verify button text changed to “Uncheck All”

        String actualButtonTextAfterClick = checkAllButton.getAttribute("value");
        String expectedValueAfterClick = "Uncheck All";

        Thread.sleep(1000);
        if (actualButtonTextAfterClick.equals(expectedValueAfterClick)){
            System.out.println("Final verification PASSED!");
        }else{
            System.out.println("Final verification FAILED!!!");
        }

        driver.close();
    }
}
