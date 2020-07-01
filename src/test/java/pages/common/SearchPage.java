package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class SearchPage extends AbstractPage {
    public SearchPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(css = ".empty-search-state")
    public WebElement emptySearchState;

    @FindBy(css = ".search-result-message--with-result")
    public WebElement searchResultMessageWithResult;

    @FindBy(css = ".sub-category-product- .list:first-child .icon.like-heart")
    public WebElement addtoFavoriteIcon;

    @FindBy(id = "noty_layout__topRight")
    public WebElement notifyPopup;
}
