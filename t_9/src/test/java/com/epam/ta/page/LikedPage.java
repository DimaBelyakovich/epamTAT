package com.epam.ta.page;

import com.epam.ta.model.Item;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class LikedPage extends AbstractPage{

    List<Item> items = new ArrayList<>();

    @FindBy(xpath = "//span[@class='mSwwwbBehQ']")
    private WebElement numOfItemsSpan;

    @FindBy(xpath = "//article[@class='_1_IxNTwqll cia-vs cia-cs']")
    private List<WebElement> itemArticles;

    @FindBy(xpath = "//h3[@class='_3dCGE8Y9v3 cLo1fZHm2y']")
    private List<WebElement> itemTitles;

    @FindBy(xpath = "//div[@class='_3NaXxl-HYN _3f2ZtYT7NH _1f_YBwo4nE']/span/span[1]")
    private List<WebElement> itemPrices;

    public Integer getNumberInSpan(){
        return parseInt(numOfItemsSpan.getText());
    }

    public Integer getNumOfProductsOnList(){
        return itemArticles.size();
    }

    public List<Item> createProductList(){
        CustomWaits.waitForElementClickable(driver, itemTitles.get(0));
        int n = itemArticles.size();
        for (int i = 0; i < n; i++) {
            items.add(new Item(itemTitles.get(i).getText()));
        }
        return items;
    }

    public LikedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
