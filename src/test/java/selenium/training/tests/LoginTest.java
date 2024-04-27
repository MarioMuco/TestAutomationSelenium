package selenium.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.training.pages.LoginPage;
import selenium.training.pages.RegisterPage;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

public class LoginTest {

    private LoginPage loginPage;

    public LoginTest() {
        loginPage = new LoginPage();
    }

    @Test
    public void successfulLoginTest() {
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);

        WebElement welcome_msg = Driver.getDriver().findElement(By.xpath("//div[@class='topic-block-title']/h2"));
        Assert.assertEquals("Welcome to our store",welcome_msg.getText());
        WebElement logout = Driver.getDriver().findElement(By.xpath("//a[@class='ico-logout']"));
        Assert.assertEquals("Log out",logout.getText());
        logout.click();

    }



}
