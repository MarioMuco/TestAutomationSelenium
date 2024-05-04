package selenium.training.tests;

import org.junit.jupiter.api.AfterAll;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.pages.RegisterPage;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


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
    }


}
