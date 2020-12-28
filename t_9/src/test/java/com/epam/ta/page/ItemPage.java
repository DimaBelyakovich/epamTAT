package com.epam.ta.page;

import com.epam.ta.model.Item;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;

public class ItemPage extends AbstractPage{

    private final String URL = "https://market.yandex.by/product--smartfon-samsung-galaxy-a31-128gb/657802078";

    @FindBy(xpath = "//div[@class='_2UmyXf5e76']")
    private WebElement addToLikedButton;

    @FindBy(xpath = "//div[@class='_1CXljk9rtd']")
    private WebElement addToComparisonButton;

    @FindBy(xpath = "//div[@class='_3oDLePObQ1']")
    private WebElement goToComparisonButtonPopUp;

    @FindBy(xpath = "//div[@class='_3oDLePObQ1']")
    private WebElement goToLikedButtonPopUp;

    @FindBy(xpath = "//h1[@class='_1BWd__A9LM _2OAACZwAjs undefined']")
    private WebElement itemTitle;

    @FindBy(xpath = "//button[@class='_2EPSjI-GdM _2s55WErgIp BCVQlNQsVv _3OsPkXYN80 _2Sz75Y384m _1XumhZyXqj _2VlTHnWxF8 _1jnLi6H271']")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//span[@class='mSwwwbBehQ']")
    private WebElement numItemsInBasket;

    @FindBy(xpath = "//div[@class='_3BBUsZVSt0 _3pvYcLe0Ew']")
    private WebElement continueShoppingButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public Item getItem(){
        return new Item(itemTitle.getText());
    }

    public ItemPage addToLiked(){
        addToLikedButton.click();
        return this;
    }

    public ItemPage addToComparison(){
        addToComparisonButton.click();
        return this;
    }

    public ComparisonPage goToComparison(){
        goToComparisonButtonPopUp.click();
        CustomWaits.waitForPageLoaded(driver);
        return new ComparisonPage(driver);
    }

    public LikedPage goToLikedPage(){
        goToLikedButtonPopUp.click();
        return new LikedPage(driver);
    }

    public Integer addToBasket(){
        addToBasketButton.click();
        logger.info("basket button clicked");
        CustomWaits.waitForPageLoaded(driver);
        continueShoppingButton.click();
        logger.info("closeButton clicked");
        return parseInt(numItemsInBasket.getText());
    }

    @Override
    public ItemPage openPage() {
        driver.navigate().to(URL);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
