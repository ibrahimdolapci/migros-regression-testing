package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class MainPage extends AbstractPage
{
    Browser browser;
    public MainPage(Browser browser)
    {
        super(browser);
        this.browser = browser;
    }

    @FindBy(css = ".header-sticky-register-login .header-sticky-register-login--list-item:last-child")
    public WebElement loginButton;

    @FindBy(linkText = "Kağıt, Kozmetik")
    public WebElement paperCosmeticsMenu;

    @FindBy(css = "a[data-monitor-ga-action='Tıraş Malzemeleri']")
    public WebElement shavingSuppliesCategory;

    @FindBy(css = "a[data-monitor-ga-action='Tıraş Makinaları']")
    public WebElement shaversCategory;

    @FindBy(css = ".shoping-cart-icon-block .fa-shopping-cart")
    public WebElement shoppingBasketButton;

    @FindBy(xpath = "//*[@id=\"cart-bar\"]/div/div/div/div/h3")
    public WebElement emptyBasketText;

    @FindBy(className = "rubbish")
    public WebElement trashButton;

    @FindBy(className = "go-to-basket-button")
    public WebElement goToBasketButton;

    @FindBy(css = "#deliveryFromStoreAnnouncement button[aria-label='Close']")
    public WebElement closeStoreAnnouncementButton;

    @FindBy(css = "#membership-modal button.close")
    public WebElement closePopupButton;

    @FindBy(className = "progress-bar-text")
    public WebElement progressBarText;

    @FindBy(css = ".action-td .plus-orange")
    public WebElement plusButton;

    @FindBy(linkText = "Çıkış Yap")
    public WebElement logoutButton;

    @FindBy(css = "#cart-bar td.title")
    public WebElement addedCartItem;

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement cookieDismissButton;



    @FindBy(id = "addressSelectionTooltip1")
    public WebElement addressDropdown;

    @FindBy(id = "addressSelectionTooltip2")
    public WebElement deliveryFromStore;

    @FindBy(xpath = "//*[@id=\"store\"]/form/div[1]/div/div/div[2]/div")
    public WebElement citySelect;

    @FindBy(xpath = "//*[@id=\"store\"]/form/div[2]/div/div/div[2]/div")
    public WebElement townSelect;

    @FindBy(xpath = "//*[@id=\"store\"]/form/div[3]/label/div/div[2]/div")
    public WebElement districtSelect;

    public WebElement selectNthOption(int n){
        return browser.findElement(By.cssSelector(String.format(".chosen-container-active .chosen-drop .chosen-results li.active-result:nth-of-type(%s)", n)));
    }

    @FindBy(id = "search")
    public WebElement searchInput;

    @FindBy(css = "#main-search button")
    public WebElement searchButton;

}
