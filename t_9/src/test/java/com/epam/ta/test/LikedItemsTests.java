package com.epam.ta.test;

import com.epam.ta.model.Item;
import com.epam.ta.page.CategoryPage;
import com.epam.ta.page.ItemPage;
import com.epam.ta.page.LikedPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LikedItemsTests extends CommonConditions{
    @Test
    public void likedItemsWithoutAuthorization(){
        List<Item> addedItems = new ArrayList<>();

        Item addedFromCategoryPage = new CategoryPage(driver)
                                        .openPage()
                                        .createItemsList()
                                        .addProductOnLiked(1);
        addedItems.add(addedFromCategoryPage);

        ItemPage itemPage = new ItemPage(driver).openPage();
        itemPage.addToLiked();
        Item addedFromItemPage = itemPage.getItem();
        addedItems.add(addedFromItemPage);

        LikedPage likedPage = itemPage.goToLikedPage();

        int numInSpan = likedPage.getNumberInSpan();
        int expected = likedPage.getNumOfProductsOnList();
        assertThat(expected, is(equalTo(numInSpan)));

        List<Item> likedItems = likedPage.createProductList();
        Collections.reverse(likedItems);
        assertThat(likedItems,is(equalTo(addedItems)));
    }
}
