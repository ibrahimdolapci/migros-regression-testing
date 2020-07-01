package pages.purchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class BasketPage extends AbstractPage
{
    public BasketPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(id = "summaryRevenue")
    public WebElement basketTotal;

    @FindBy(id = "in-cart-next-button")
    public WebElement approveBasket;

    @FindBy(id = "cartCampaignModal")
    public WebElement cartCampaignModal;

    @FindBy(css = "#cartCampaignModal button.close")
    public WebElement CampaignModalCloseButton;

    @FindBy(xpath = "//*[@id=\"cartPageBagChoiceForm\"]/div/label[2]")
    public WebElement clothBagRadioButton;

    @FindBy(id = "alternativeProductChoice")
    public WebElement alternativeProductChoice;

    @FindBy(css = "#alternativeProductChoice option[value='NO_ALTERNATIVE']")
    public WebElement noAlternativeOption;

    @FindBy(css = "#deliveryTimeSelection tr:nth-of-type(4) td:nth-of-type(4) input")
    public WebElement deliveryTimeSelection;

    @FindBy(css = "#deliveryTimeSelection .delivery-time .description")
    public WebElement deliveryTime;

    @FindBy(css = "#cart-info button.next-button")
    public WebElement goToPaymentButton;
}
