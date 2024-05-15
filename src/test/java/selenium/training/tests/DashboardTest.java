package selenium.training.tests;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
    public void addWishlist() throws InterruptedException {
        dashboardPage.addWishlist();

        WebElement numriWishlist = Driver.getDriver().findElement(By.cssSelector("span.wishlist-qty"));
        Assert.assertEquals(numriWishlist.getText(),"(2)");
    }

    @Test(priority = 3)
    public void addShoppinglist() throws InterruptedException {
        dashboardPage.addShopping();

        WebElement numriShopping = Driver.getDriver().findElement(By.cssSelector("span.cart-qty"));
        Assert.assertEquals(numriShopping.getText(),"(3)");
    }

    @AfterTest
    public void closeDashboard(){
        Driver.getDriver().close();
    }



}