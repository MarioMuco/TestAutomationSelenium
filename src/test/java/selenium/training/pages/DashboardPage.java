package selenium.training.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(css = ".item-grid .item-box:nth-child(4) .product-box-add-to-cart-button")
    public WebElement shoppingButton4;

    @FindBy(css = ".item-grid .item-box:nth-child(5) .product-box-add-to-cart-button")
    public WebElement shoppingButton5;

    @FindBy(css = ".item-grid .item-box:nth-child(6) .product-box-add-to-cart-button")
    public WebElement shoppingButton6;






    public void navigateNotebooks() {
        actions.moveToElement(computers).perform();
        notebooks.click();
    }

    public void addWishlist() {
        wishlistButton2.click();
        close.click();
        wishlistButton3.click();
        close.click();
    }

    public void addShopping(){
        shoppingButton4.click();
        //duhen async wait pas cdo click
        close.click();
        shoppingButton5.click();
        close.click();
        shoppingButton6.click();
    }

}
