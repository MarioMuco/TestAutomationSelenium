package selenium.training.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.training.utils.Driver;

public class DashboardPage extends BasePage {

    @FindBy(css = ".oxd-topbar-header-userarea ul[class='oxd-dropdown-menu'] li:nth-child(4)")
    public WebElement logoutButtonWebElement;

    @FindBy(css = ".oxd-topbar-header-userarea .oxd-userdropdown-icon")
    public WebElement openProfileWebElement;

    @FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
    public WebElement pimTabWebElement;

    public void logout() {
        openProfileWebElement.click();
        logoutButtonWebElement.click();
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("/auth/login"));
    }

    public void clickPIMTab() {
        pimTabWebElement.click();
    }
}
