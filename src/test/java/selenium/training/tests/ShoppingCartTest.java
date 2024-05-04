package selenium.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.pages.ShoppingCartPage;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

public class ShoppingCartTest {
    private ShoppingCartPage shoppingCartPage;

    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    public ShoppingCartTest(){
        shoppingCartPage = new ShoppingCartPage();
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
    }


    @Test
    public void gotocart(){
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();
        dashboardPage.addShopping();

        shoppingCartPage.navigateShoppingCart();

    }



}
