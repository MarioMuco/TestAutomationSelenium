package selenium.training.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

import static selenium.training.pages.LoginPage.navigateToLoginPage;
import selenium.training.pages.LoginPage;

public class DashboardPage extends BasePage {
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(linkText = "Computers")
    public WebElement computers;

    @FindBy(linkText = "Notebooks")
    public WebElement notebooks;

    @FindBy(css = ".item-grid .item-box:nth-child(2) .add-to-wishlist-button")
    public WebElement wishlistButton2;

    @FindBy(css = ".item-grid .item-box:nth-child(3) .add-to-wishlist-button")
    public WebElement wishlistButton3;

    @FindBy(css = "span.close")
    public WebElement close;

    @FindBy(css = ".item-grid .item-box:nth-child(4) .button-2.product-box-add-to-cart-button")
    public WebElement shoppingButton4;

    @FindBy(css = ".item-grid .item-box:nth-child(5) .button-2.product-box-add-to-cart-button")
    public WebElement shoppingButton5;

    @FindBy(css = ".item-grid .item-box:nth-child(6) .button-2.product-box-add-to-cart-button")
    public WebElement shoppingButton6;





    public void navigateNotebooks() {
        actions.moveToElement(computers).perform();
        notebooks.click();
    }

    public void addWishlist() {
        wishlistButton2.click();
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();
        try {
            Thread.sleep(1000); // 1000 milliseconds = 1 second
        } catch (InterruptedException e) {
            // Handle interruption exception
            e.printStackTrace();
        }
        wishlistButton3.click();
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void addShopping(){
        shoppingButton4.click();
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();
        try {
            Thread.sleep(1000); // 1000 milliseconds = 1 second
        } catch (InterruptedException e) {
            // Handle interruption exception
            e.printStackTrace();
        }
        shoppingButton5.click();
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();
        try {
            Thread.sleep(1000); // 1000 milliseconds = 1 second
        } catch (InterruptedException e) {
            // Handle interruption exception
            e.printStackTrace();
        }
        shoppingButton6.click();
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();
    }

}
