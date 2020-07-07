package pages;
/*
We will store all Login page related web elements and methods into this class.
 */


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //locating username input box:
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    //locate input password:
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //locate login button:
    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    //login method:
    public void login(String username, String password) { //no static, u will create an instances

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
