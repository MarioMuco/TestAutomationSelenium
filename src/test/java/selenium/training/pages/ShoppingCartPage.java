package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import selenium.training.utils.Driver;


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


    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement shteti;

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']/option[@value='212']")
    private WebElement shqiperia;

    @FindBy(id = "BillingNewAddress_City")
    private  WebElement qyteti;

    @FindBy(id = "BillingNewAddress_Address1")
    private  WebElement adresa;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private  WebElement zipcode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private  WebElement numri;

    @FindBy(name = "save")
    private  WebElement butoni;

    @FindBy(id = "shippingoption_1")
    private WebElement shippingtype;

    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button' and text()='Continue']")
    private WebElement vazhdo;

    @FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
    private WebElement vazhdopayment;

    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    private WebElement vazhdopayment1;

    @FindBy(name = "continueshopping")
    private WebElement continueShopping;

    @FindBy(id = "open-estimate-shipping-popup")
    private WebElement estimateShipping;



    public void navigateShoppingCart() throws InterruptedException {
        actions.moveToElement(cart).perform();
        gotocart.click();
    }

    public void checkoutDone(){
        checkbox.click();
        checkout.click();
    }

    public void shippingDone(){
        shteti.click();
        shqiperia.click();
        qyteti.sendKeys("Tirana");
        adresa.sendKeys("Tirana");
        zipcode.sendKeys("1001");
        numri.sendKeys("0000000000");
        butoni.click();
        shippingtype.click();
        vazhdo.click();
        vazhdopayment.click();
        vazhdopayment1.click();
    }

    public boolean continueShoppingButtonIsDisplayed() {
        return continueShopping.isDisplayed();
    }

    public boolean estimateShippingButtonIsDisplayed() {
        return estimateShipping.isDisplayed();
    }


}
