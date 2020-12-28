package com.epam.ta.test;

import com.epam.ta.model.Item;
import com.epam.ta.page.CategoryPage;
import com.epam.ta.page.ComparisonPage;
import com.epam.ta.page.ItemPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ComparisonItemsTests extends CommonConditions{
    @Test
    public void compareItemsFromOneCategory(){
        List<Item> addedItems = new ArrayList<>();
        CategoryPage categoryPage = new CategoryPage(driver)
                                        .openPage()
                                        .createItemsList();
        addedItems.add(categoryPage.addProductInComparison(1));

        ItemPage itemPage = new ItemPage(driver)
                                .openPage()
                                .addToComparison();
        addedItems.add(itemPage.getItem());

        ComparisonPage comparisonPage = itemPage.goToComparison();

        int expectedNum = addedItems.size();
        Assert.assertEquals(expectedNum, comparisonPage.getNumOfAddedItems());

        List<Item> comparedItems = comparisonPage.createProductList();

        assertThat(comparedItems, is(equalTo(addedItems)));
    }

    @Test
    public void compareItemsFromDifferentCategories(){
        List<Item> addedItemsFromFirstCategories = new ArrayList<>();
        List<Item> addedItemsFromSecondCategories = new ArrayList<>();

        CategoryPage categoryPage = new CategoryPage(driver)
                                            .openPage()
                                            .createItemsList();

        addedItemsFromFirstCategories.add(categoryPage.addProductInComparison(2));
        addedItemsFromFirstCategories.add(categoryPage.addProductInComparison(5));

        categoryPage
                .openPage("https://market.yandex.by/catalog--noutbuki-v-minske/54544/list?hid=91013&onstock=1&local-offers-first=0")
                .createItemsList();

        addedItemsFromSecondCategories.add(categoryPage.addProductInComparison(2));
        addedItemsFromSecondCategories.add(categoryPage.addProductInComparison(5));

        ComparisonPage comparisonPage = categoryPage.goToComparison();
        int result = comparisonPage.getNumOfComparedCategories();
        assertThat(result, is(equalTo(2)));
    }
}
