package com.epam.page;

import com.epam.model.Item;
import com.epam.waits.CustomWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryPage extends MainPage {

    private By popUpButton = By.xpath("//div[@class='_3oDLePObQ1']");

    @FindBy(xpath = "//h1[@class='_3wPGpzKmmn']")
    private WebElement pageTitle;

    @FindBy(xpath = "//h3[@class='_3dCGE8Y9v3 cLo1fZHm2y']")
    private List<WebElement> itemsTitle;

    @FindBy(xpath = "//div[@class='_3NaXxl-HYN _3f2ZtYT7NH _1f_YBwo4nE']/span/span[2]")
    private List<WebElement> itemsCurrency;

    @FindBy(xpath = "//div[@class='_2UmyXf5e76']")
    private List<WebElement> itemsLikeButton;

    @FindBy(xpath = "//div[@class='_1CXljk9rtd']")
    private List<WebElement> itemsCompareButton;

    private List<Item> itemsOnPage;

    public CategoryPage(WebDriver driver) {
        super(driver);
        this.itemsOnPage = new ArrayList<>();
        CustomWaits.waitForPageLoaded(driver);
        logger.info("Category page created");
    }

    @Override
    public CategoryPage openPage() {
        return this;
    }

    public String getCategoryTitle(){
        CustomWaits.waitForPageLoaded(driver);
        return pageTitle.getText();
    }

    public List<String> getSearchResultTitles(){
        CustomWaits.waitForPageLoaded(driver);
        return itemsTitle.stream().map(item -> item.getText())
                .collect(Collectors.toList());
    }

    public List<String> getCurrency(){
        CustomWaits.waitForPageLoaded(driver);
        return itemsCurrency.stream().map(i -> i.getText())
                .collect(Collectors.toList());
    }

    public CategoryPage createItemList(){
        for (int i = 0; i < itemsTitle.size(); i++) {
            this.itemsOnPage.add(new Item(itemsTitle.get(i).getText()));
        }
        return this;
    }

    public CategoryPage addToWishList(int num, LinkedList<Item> addedItems){
        CustomWaits.waitForPageLoaded(driver);
        itemsLikeButton.get(num).click();
        CustomWaits.waitForPageLoaded(driver);
        Item item = itemsOnPage.get(num);
        item.setFavourite(true);
        addedItems.addFirst(item);
        logger.info("Added to favourites" + item);
        CustomWaits.waitForElementLocated(driver, "//div[@class='_3oDLePObQ1']");
        return this;
    }

    public CategoryPage addToComparison(int num, LinkedList<Item> addedItems){
        CustomWaits.waitForPageLoaded(driver);
        itemsCompareButton.get(num).click();
        CustomWaits.waitForPageLoaded(driver);
        Item item = itemsOnPage.get(num);
        item.setCompared(true);
        addedItems.addFirst(item);
        logger.info("Added to comparison" + item);
        CustomWaits.waitForElementLocated(driver, "//div[@class='_3oDLePObQ1']");
        return this;
    }

    public ItemPage goToItem(int num){
        itemsTitle.get(num).click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        CustomWaits.waitForPageLoaded(driver);
        return new ItemPage(driver);
    }

    public CategoryPage closePopUp(){
        By closePopUpBy = By.xpath("//button[@class='_1mhpYwuyDz _2FIxngPL9Y JLgsgUmoge _1fzfn22Av_ _1t_-Z3RX29']");
        WebElement closePopUpButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(closePopUpBy));
        CustomWaits.waitForElementClickable(driver, closePopUpButton);
        closePopUpButton.click();
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public ComparisonPage goToComparisonPageFromPopUp(){
        WebElement goToComparison = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(popUpButton));
        goToComparison.click();
        CustomWaits.waitForPageLoaded(driver);
        return new ComparisonPage(driver);
    }
}
