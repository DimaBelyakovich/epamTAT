package com.epam.ta.page;

import com.epam.ta.model.Item;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class CategoryPage extends AbstractPage{
    private final String BASE_URL = "https://market.yandex.ru/catalog--smartfony/16814639";

    private List<Item> items = new ArrayList<>();

    @FindBy(xpath = "//article[@class='_1_IxNTwqll cia-vs cia-cs']")
    private List<WebElement> itemArticles;

    @FindBy(xpath = "//div[@class='_3NaXxl-HYN _3f2ZtYT7NH _1f_YBwo4nE']/span/span[2]")
    private List<WebElement> itemPricesFormat;

    @FindBy(xpath = "//div[@class='_2UmyXf5e76']")
    private List<WebElement> itemLikeButton;

    @FindBy(xpath = "//h3[@class='_3dCGE8Y9v3 cLo1fZHm2y']")
    private List<WebElement> listItemTitles;

    @FindBy(xpath = "//div[@class='_1CXljk9rtd']")
    private List<WebElement> itemComparisonButtons;

    @FindBy(xpath = "//div[@class='_1UPuXOJfD4']")
    private List<WebElement> itemBasketButtons;

    @FindBy(xpath = "//div[@class='_3oDLePObQ1']")
    private WebElement goToComparisonButtonPopUp;

    @FindBy(xpath = "//button[@class='MOYcCv2eIJ _3UND8GjCtL']")
    private WebElement changeCityButton;

    @FindBy(xpath = "//input[@class='_1pVZ3jklLF']")
    private WebElement cityInput;

    @FindBy(xpath = "//button[@class='_2EPSjI-GdM _2s55WErgIp aASzJFnmRI _3OsPkXYN80']")
    private WebElement continueChangeCityButton;

    @FindBy(xpath = "//a[@class='aSUR-uUgeo']")
    private List<WebElement> hoverHintCity;

    @FindBy(xpath = "//div[@class='_3BBUsZVSt0 _3pvYcLe0Ew']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//span[@class='mSwwwbBehQ']")
    private WebElement numItemsInBasket;

    @FindBy(xpath = "//div[@class='_6RmNBByo8N']")
    private WebElement cityOnPage;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public CategoryPage setupLocation(String city){
        changeCityButton.click();
        CustomWaits.waitForPageLoaded(driver);
        cityInput.sendKeys(city);
        hoverHintCity.get(0).click();
        continueChangeCityButton.click();
        logger.info("Location set upped");
        CustomWaits.waitForPageLoaded(driver);
        return new CategoryPage(driver);
    }

    public ComparisonPage goToComparison(){
        CustomWaits.waitForElementClickable(driver, goToComparisonButtonPopUp);
        goToComparisonButtonPopUp.click();
        CustomWaits.waitForPageLoaded(driver);
        return new ComparisonPage(driver);
    }

    public Item addProductOnLiked(Integer itemNum){
        itemLikeButton.get(itemNum).click();
        logger.info("Product liked");
        CustomWaits.waitForPageLoaded(driver);
        return items.get(itemNum);
    }

    public Item addProductInComparison(Integer itemNum){
        itemComparisonButtons.get(itemNum).click();
        logger.info("Item added to comparison");
        CustomWaits.waitForPageLoaded(driver);
        return items.get(itemNum);
    }

    public CategoryPage addProductInBasket(Integer itemNum){
        itemBasketButtons.get(itemNum).click();
        logger.info("Basket button clicked");
        CustomWaits.waitForPageLoaded(driver);
        continueShoppingButton.click();
        logger.info("Close Button clicked");
        return this;
    }

    public CategoryPage createItemsList(){
        logger.info("start creating list");
        for (int i = 0; i < itemArticles.size(); i++) {
            items.add(new Item(listItemTitles.get(i).getText()));
        }
        logger.info("list of products created");
        return this;
    }

    public String getCity(){
        return cityOnPage.getText();
    }

    public List<String> getPriceFormat(){
        CustomWaits.waitForElementLocated(driver, "//article[@class='_1_IxNTwqll cia-vs cia-cs']");
        CustomWaits.waitForElementClickable(driver, itemArticles.get(0));
        return itemPricesFormat.stream().map(i -> i.getText()).collect(Collectors.toList());
    }

    public Integer getNumInBasket(){
        return parseInt(numItemsInBasket.getText());
    }

    @Override
    public CategoryPage openPage() {
        sleep();
        driver.navigate().to(BASE_URL);
        CustomWaits.waitForPageLoaded(driver);
        logger.info("Page opened");
        return this;
    }

    public CategoryPage openPage(String URL){
        driver.navigate().to(URL);
        CustomWaits.waitForPageLoaded(driver);
        logger.info("Page opened");
        return this;
    }
}
