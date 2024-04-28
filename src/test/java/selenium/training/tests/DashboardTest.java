package selenium.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @Test
    public void successfulNotebooks() {
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();

        WebElement notebookConfirm = Driver.getDriver().findElement(By.xpath("//h1[contains(text(), 'Notebook')]"));
        Assert.assertEquals("Notebooks",notebookConfirm.getText());
    }

    @Test
    public void addWishlist() {
        loginPage.login(GlobalConfigs.username, GlobalConfigs.password);
        dashboardPage.navigateNotebooks();

        dashboardPage.addWishlist();

    }

}
