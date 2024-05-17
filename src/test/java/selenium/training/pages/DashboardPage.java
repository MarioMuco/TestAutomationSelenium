package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.training.utils.Driver;

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

    public void addWishlist() throws InterruptedException {
        wishlistButton2.click();
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();
        Thread.sleep(1000);
        wishlistButton3.click();
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();
    }

    public void addShopping() throws InterruptedException {
        shoppingButton4.click();
        Thread.sleep(1000);
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();

        shoppingButton5.click();
        Thread.sleep(1000);
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();

        shoppingButton6.click();
        Thread.sleep(1000);
        Driver.getWait().until(ExpectedConditions.elementToBeClickable(close)).click();

    }

}
