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

    private float totali;

    public ShoppingCartTest(){
        shoppingCartPage = new ShoppingCartPage();
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
    }


    @Test(priority = 1)
    public void gotocart(){
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();
        shoppingCartPage.navigateShoppingCart();

        String expectedUrl = "https://demo.nopcommerce.com/cart";
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl);
    }

    @Test(priority = 2)
    public void totali(){
        String price1 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,350.00')]")).getText().replace("$", "").replace(",", "");
        String price2 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,360.00')]")).getText().replace("$", "").replace(",", "");
        String price3 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,590.00')]")).getText().replace("$", "").replace(",", "");

        float currentTotal = Float.parseFloat(price1) + Float.parseFloat(price2) + Float.parseFloat(price3);
        totali = currentTotal;
        WebElement expectedTotal = Driver.getDriver().findElement(By.cssSelector(".cart-total-right"));

        Assertions.assertEquals(Float.parseFloat(expectedTotal.getText().replace("$", "").replace(",", "").replace(",", "")), currentTotal);

    }

    @Test(priority = 3)
    public void checkoutComplete(){
        shoppingCartPage.checkoutDone();

        WebElement emaili = Driver.getDriver().findElement(By.id("BillingNewAddress_Email"));
        WebElement emri = Driver.getDriver().findElement(By.id("BillingNewAddress_FirstName"));
        WebElement mbiemri = Driver.getDriver().findElement(By.id("BillingNewAddress_LastName"));

        Assertions.assertEquals(GlobalConfigs.username,emaili.getAttribute("value"));
        Assertions.assertEquals(GlobalConfigs.firstName,emri.getAttribute("value"));
        Assertions.assertEquals(GlobalConfigs.lastName,mbiemri.getAttribute("value"));
    }

    @Test(priority = 4)
    public void shippingAdress(){
        shoppingCartPage.shippingDone();

        WebElement currentTotal = Driver.getDriver().findElement(By.cssSelector(".cart-total-right"));

        Assertions.assertEquals(4300.0, Float.parseFloat(currentTotal.getText().replace("$", "").replace(",", "")));

        WebElement confirmButton = Driver.getDriver().findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        confirmButton.click();

        WebElement thankyou = Driver.getDriver().findElement(By.xpath("//h1[contains(text(), 'Thank you')]"));
        WebElement orderLink = Driver.getDriver().findElement(By.xpath("//a[text()='Click here for order details.']"));

        Assertions.assertEquals(thankyou.getText(),"Thank you");
        Assertions.assertEquals(orderLink.getText(),"Click here for order details.");

    }


}
