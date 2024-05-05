package selenium.training.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


    WebElement expectedTotal = Driver.getDriver().findElement(By.cssSelector(".cart-total-right"));
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

        Assertions.assertEquals(Float.parseFloat(expectedTotal.getText().replace("$", "").replace(",", "").replace(",", "")), currentTotal);

    }

    @Test
    public void checkoutComplete(){
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();
        dashboardPage.addShopping();
        shoppingCartPage.navigateShoppingCart();

        shoppingCartPage.checkoutDone();

        WebElement emaili = Driver.getDriver().findElement(By.id("BillingNewAddress_Email"));
        WebElement emri = Driver.getDriver().findElement(By.id("BillingNewAddress_FirstName"));
        WebElement mbiemri = Driver.getDriver().findElement(By.id("BillingNewAddress_LastName"));

        Assertions.assertEquals(GlobalConfigs.username,emaili.getAttribute("value"));
        Assertions.assertEquals(GlobalConfigs.firstName,emri.getAttribute("value"));
        Assertions.assertEquals(GlobalConfigs.lastName,mbiemri.getAttribute("value"));
    }


    @Test
    public void shippingAdress(){
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();
        dashboardPage.addShopping();
        shoppingCartPage.navigateShoppingCart();
        shoppingCartPage.checkoutDone();

        shoppingCartPage.shippingDone();

        WebElement currentTotal = Driver.getDriver().findElement(By.cssSelector(".cart-total-right"));

        Assertions.assertEquals(Float.parseFloat(expectedTotal.getText().replace("$", "").replace(",", "")), Float.parseFloat(currentTotal.getText().replace("$", "").replace(",", "")));

        WebElement confirmButton = Driver.getDriver().findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        confirmButton.click();
    }




}
