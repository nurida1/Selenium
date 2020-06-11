package test.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasiNavigation {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        String url = "http://google.com";
        String url2 = "http://amazon.com";

        driver.get(url);

        Thread.sleep(3000);
        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.navigate().to(url2);

        Thread.sleep(3000);

        driver.navigate().back(); //in our case it's google.com

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.close();//will close web browser



    }
}
