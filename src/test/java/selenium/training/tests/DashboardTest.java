package selenium.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

public class DashboardTest {
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    public DashboardTest(){
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void successfulNotebooks() {
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();

        WebElement notebookConfirm = Driver.getDriver().findElement(By.xpath("//h1[contains(text(), 'Notebook')]"));
        Assert.assertEquals(notebookConfirm.getText(),"Notebooks");
    }

    @Test(priority = 2)
    public void addWishlist() {
        dashboardPage.addWishlist();

        Driver.getWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement wishlistElement = driver.findElement(By.cssSelector("span.wishlist-qty"));
                return wishlistElement.getText().equals("(2)");
            }
        });

        WebElement numriWishlist = Driver.getDriver().findElement(By.cssSelector("span.wishlist-qty"));
        Assert.assertEquals(numriWishlist.getText(),"(2)");
    }

    @Test(priority = 3)
    public void addShoppinglist() {
        dashboardPage.addShopping();

        Driver.getWait().until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement shoppingElement = driver.findElement(By.cssSelector("span.cart-qty"));
                return shoppingElement.getText().equals("(3)");
            }
        });

        WebElement numriShopping = Driver.getDriver().findElement(By.cssSelector("span.cart-qty"));
        Assert.assertEquals(numriShopping.getText(),"(3)");
    }





}