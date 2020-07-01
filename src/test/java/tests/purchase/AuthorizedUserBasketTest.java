package tests.purchase;

import org.junit.Assert;
import org.junit.Test;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.common.SearchPage;
import pages.purchase.BasketPage;
import pages.user.LoginPage;
import pages.user.ProfilePage;
import tests.AuthorizedUserTest;

public class AuthorizedUserBasketTest extends AuthorizedUserTest {
    int storeCounter = 2;

    @Test
    public void clearBasketItems() throws InterruptedException {
        MainPage mainPage = new MainPage(browser);
        Assert.assertEquals("Sepetiniz şu anda boş.", mainPage.emptyBasketText.getText());
    }

    @Test
    public void changeEmailAddress() throws InterruptedException {
        LoginPage loginPage = new LoginPage(browser);

        browser.waitAndClick(loginPage.displayName);
        browser.waitAndClick(loginPage.accountInformationLink);


        ProfilePage profilePage = new ProfilePage(browser);

        String newEmail = "ibrahimdolapci0909@gmail.com";
        browser.waitAndSendKeys(profilePage.newEmailInput,"ibrahimdolapci0909@gmail.com");
        browser.waitAndClick(profilePage.updateEmailButton);
        AuthorizedUserTest.getVerificationCode();

        Assert.assertEquals(profilePage.email.getText(),newEmail);
    }


    @Test
    public void changeStoreAndSearch() {
        SearchPage searchPage = new SearchPage(browser);

        do{
            changeStore();
        }
        while(!browser.isElementDisplayed(searchPage.emptySearchState));

        Assert.assertTrue(browser.isElementDisplayed(searchPage.searchResultMessageWithResult));
    }

    public void changeStore(){
        MainPage mainPage = new MainPage(browser);

        if (browser.isElementDisplayed(mainPage.cookieDismissButton)) {
            browser.waitAndClick(mainPage.cookieDismissButton);
        }
        browser.waitAndClick(mainPage.addressDropdown);
        browser.waitAndClick(mainPage.deliveryFromStore);
        browser.waitAndClick(mainPage.citySelect);
        browser.waitAndClick(mainPage.selectNthOption(2));
        browser.waitAndClick(mainPage.townSelect);
        browser.waitAndClick(mainPage.selectNthOption(2));
        browser.waitAndClick(mainPage.districtSelect);
        browser.waitAndClick(mainPage.selectNthOption(storeCounter++));

        browser.waitAndSendKeys(mainPage.searchInput,"Petrix");
        browser.waitAndClick(mainPage.searchButton);
    }

    @Test
    public void addToFavorites(){
        SearchPage searchPage = new SearchPage(browser);

        browser.waitAndClick(searchPage.addtoFavoriteIcon);
        Assert.assertTrue(browser.isElementDisplayed(searchPage.notifyPopup));
    }

    @Test
    public void selectMainCategory() {
        MainPage mainPage = new MainPage(browser);

        if (browser.isElementDisplayed(mainPage.cookieDismissButton)) {
            browser.waitAndClick(mainPage.cookieDismissButton);
        }
        browser.waitAndClick(mainPage.paperCosmeticsMenu);

        CategoryPage categoryPage = new CategoryPage(browser);

        Assert.assertEquals("Kağıt, Kozmetik", categoryPage.currentCategoryTitle.getText());
    }

    @Test
    public void selectSubCategory() {
        selectMainCategory();

        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.shavingSuppliesCategory);

        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(mainPage.shaversCategory);

        Assert.assertEquals("Tıraş Malzemeleri", categoryPage.currentSubCategoryTitle.getText());
    }

    @Test
    public void sortByDiscountAmount() {
        selectSubCategory();
        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.othersButton);
        browser.waitAndClick(categoryPage.sortDiscountAmount);

        String attribute = categoryPage.selectedSortCriteria.getAttribute("data-sort-criteria");
        Assert.assertEquals("DISCOUNT_AMOUNT", attribute);
    }

    @Test
    public void addToBasket() {
        sortByDiscountAmount();

        MainPage mainPage = new MainPage(browser);

        while (browser.isElementDisplayed(mainPage.progressBarText)) {
            browser.waitAndClick(mainPage.plusButton);
        }
        browser.waitAndClick(mainPage.goToBasketButton);

        BasketPage basketPage = new BasketPage(browser);
        if (browser.isElementDisplayed(basketPage.cartCampaignModal)) {
            browser.waitAndClick(basketPage.CampaignModalCloseButton);
        }
    }

    @Test
    public void changeProductAlternative() {
        addToBasket();

        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.firstProductAddBasketButton);

        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.shoppingBasketButton);
        Assert.assertEquals(mainPage.addedCartItem.getText(), categoryPage.firstProductTitle.getText());

        BasketPage basketPage = new BasketPage(browser);
        browser.waitAndClick(basketPage.alternativeProductChoice);
        browser.waitAndClick(basketPage.noAlternativeOption);
    }

    @Test
    public void approveBasket() {
        changeProductAlternative();

        BasketPage basketPage = new BasketPage(browser);

        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket);

        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
    }

    @Test
    public void selectDeliveryTime() throws InterruptedException {
        //changeEmailAddress();
        changeStoreAndSearch();
        addToFavorites();
        approveBasket();
        BasketPage basketPage = new BasketPage(browser);

        browser.waitAndClick(basketPage.deliveryTimeSelection);
        Assert.assertTrue(basketPage.deliveryTime.getText().contains("16:30 - 18:30"));
    }
}