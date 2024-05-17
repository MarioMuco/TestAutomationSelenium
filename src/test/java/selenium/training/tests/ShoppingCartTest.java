package selenium.training.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.pages.ShoppingCartPage;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void gotocart() throws InterruptedException {
       // loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        //dashboardPage.navigateNotebooks();
        shoppingCartPage.navigateShoppingCart();

        String expectedUrl = "https://demo.nopcommerce.com/cart";
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl);

        assertTrue(shoppingCartPage.continueShoppingButtonIsDisplayed() && shoppingCartPage.estimateShippingButtonIsDisplayed());
    }

    @Test(priority = 2)
    public void totali() throws InterruptedException {
        Thread.sleep(2000);
        String price1 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,350.00')]")).getText().replace("$", "").replace(",", "");
        String price2 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,360.00')]")).getText().replace("$", "").replace(",", "");
        String price3 = Driver.getDriver().findElement(By.xpath("//td[contains(span/text(), '$1,590.00')]")).getText().replace("$", "").replace(",", "");

        float currentTotal = Float.parseFloat(price1) + Float.parseFloat(price2) + Float.parseFloat(price3);
        totali = currentTotal;
        Thread.sleep(1000);
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

        Assertions.assertEquals(totali, Float.parseFloat(currentTotal.getText().replace("$", "").replace(",", "")));

        WebElement confirmButton = Driver.getDriver().findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        confirmButton.click();

        WebElement orderSuccess = Driver.getDriver().findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[1]/strong"));
        Assertions.assertEquals(orderSuccess.getText(),"Your order has been successfully processed!");


        WebElement orderNumber = Driver.getDriver().findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div/div[2]/div[1]/strong"));
        String actual = orderNumber.getText();
        String pattern = "ORDER NUMBER: \\d+";

        assertMatchesPattern(pattern, actual);

    }

    @AfterTest
    public void closeDashboard(){
        Driver.getDriver().close();
   }

    private void assertMatchesPattern(String regex, String actual) {
        Pattern pattern = Pattern.compile(regex);
        boolean matches = pattern.matcher(actual).matches();
        assertTrue(matches);
    }

}
