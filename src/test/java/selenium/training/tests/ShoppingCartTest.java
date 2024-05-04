package selenium.training.tests;

import org.junit.jupiter.api.Assertions;
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

        String expectedUrl = "https://demo.nopcommerce.com/cart";
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    public void totali(){
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();
        dashboardPage.addShopping();

        shoppingCartPage.navigateShoppingCart();

        String price1 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,350.00')]")).getText().replace("$", "").replace(",", "");
        String price2 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,360.00')]")).getText().replace("$", "").replace(",", "");
        String price3 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,590.00')]")).getText().replace("$", "").replace(",", "");

        float currentTotal = Float.parseFloat(price1) + Float.parseFloat(price2) + Float.parseFloat(price3);
        WebElement expectedTotal = Driver.getDriver().findElement(By.cssSelector(".cart-total-right"));

        Assertions.assertEquals(Float.parseFloat(expectedTotal.getText().replace("$", "").replace(",", "").replace(",", "")), currentTotal);

    }

    @Test
    public void checkoutComplete(){
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();
        dashboardPage.addShopping();
        shoppingCartPage.navigateShoppingCart();

        shoppingCartPage.checkoutDone();

    }




}
