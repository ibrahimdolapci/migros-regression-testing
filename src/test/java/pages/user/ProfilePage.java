package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class ProfilePage extends AbstractPage {
    public ProfilePage(Browser browser)
    {
        super(browser);
    }


    @FindBy(id = "newEmail")
    public WebElement newEmailInput;


    @FindBy(css = "#changeEmailForm button")
    public WebElement updateEmailButton;

    @FindBy(css = ".registered-information .list .info")
    public WebElement email;



}
