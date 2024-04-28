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

    @FindBy(css = "button.button-2.add-to-wishlist-button:nth-of-type(2)")
    public WebElement wishlistButton2;

    @FindBy(css = "button.button-2.add-to-wishlist-button:nth-of-type(3)")
    public WebElement wishlistButton3;



    public void navigateNotebooks() {
        actions.moveToElement(computers).perform();
        notebooks.click();
    }

    public void addWishlist() {
        wishlistButton2.click();


        wishlistButton3.click();

    }

}
