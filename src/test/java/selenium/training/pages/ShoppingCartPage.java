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

public class ShoppingCartPage {
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(css = "span.wishlist-qty")
    private WebElement cart;

    @FindBy(css = ".button-1 .cart-button")
    private WebElement gotocart;


    public void navigateShoppingCart() {
        actions.moveToElement(cart).perform();
        gotocart.click();
    }



}
