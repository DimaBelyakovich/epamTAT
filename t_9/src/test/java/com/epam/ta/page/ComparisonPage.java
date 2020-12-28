package com.epam.ta.page;

import com.epam.ta.model.Item;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ComparisonPage extends AbstractPage{
    List<Item> items = new ArrayList<>();

    @FindBy(xpath = "//div[@class='XTSL4OaxYO']")
    private List<WebElement> comparedCategories;

    @FindBy(xpath = "//a[@class='_27nuSZ19h7 PzFNvA3yUm cia-cs']")
    private List<WebElement> itemTitles;

    @FindBy(xpath = "//div[@class='zvRJMhRW-w']")
    private List<WebElement> addedItems;

    @Override
    protected ComparisonPage openPage() {
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }

    public int getNumOfComparedCategories(){
        return comparedCategories.size();
    }

    public ComparisonPage(WebDriver driver) {
        super(driver);
        CustomWaits.waitForPageLoaded(driver);
    }

    public int getNumOfAddedItems(){
        return addedItems.size();
    }

    public List<Item> createProductList(){
        int n = addedItems.size();
        for (int i = 0; i < n; i++) {
            items.add(new Item(itemTitles.get(i).getText()));
        }
        return items;
    }

}
