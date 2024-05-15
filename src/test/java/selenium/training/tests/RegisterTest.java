package selenium.training.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import selenium.training.pages.RegisterPage;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterTest {

    private RegisterPage registerPage;

    public RegisterTest() {
        registerPage = new RegisterPage();
    }

    @Test
    public void successfulRegisterTest() {
        registerPage.register(GlobalConfigs.username, GlobalConfigs.password, GlobalConfigs.firstName, GlobalConfigs.lastName);
        WebElement success_result = Driver.getDriver().findElement(By.className("result"));
        Assert.assertEquals("Your registration completed",success_result.getText());
        WebElement logout = Driver.getDriver().findElement(By.xpath("//a[@class='ico-logout']"));
        logout.click();
    }

    @AfterTest
    public void closeRegister(){
        Driver.getDriver().close();
    }

}
