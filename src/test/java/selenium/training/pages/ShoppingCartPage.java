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

public class ShoppingCartPage extends BasePage{
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(css = ".cart-label")
    private WebElement cart;

    @FindBy(css = ".cart-button")
    private WebElement gotocart;

    @FindBy(id = "termsofservice")
    private WebElement checkbox;

    @FindBy(id = "checkout")
    private WebElement checkout;



    public void navigateShoppingCart() {
        actions.moveToElement(cart).perform();
        gotocart.click();
    }

    public void checkoutDone(){
        checkbox.click();
        checkout.click();
    }


}
