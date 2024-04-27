package selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

public class LoginPage extends BasePage{

    @FindBy(className = "ico-login")
    private  WebElement loginButton;

    @FindBy(className = "email")
    private  WebElement loginEmail;

    @FindBy(className = "password")
    private  WebElement loginPassword;

    @FindBy(css = ".button-1.login-button")
    private WebElement loginDone;


    public void login(String email, String password){
        navigateToLoginPage();
        loginButton.click();
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        loginDone.click();
    }

    public static void navigateToLoginPage() {
        Driver.getDriver().get(GlobalConfigs.URL);
    }
}
