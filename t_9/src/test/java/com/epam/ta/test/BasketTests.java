package com.epam.ta.test;

import com.epam.ta.page.CategoryPage;
import com.epam.ta.page.ItemPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BasketTests extends CommonConditions{
    @Test
    public void addToBasket(){
        Integer numOfAddedItems = new CategoryPage(driver)
                                    .openPage()
                                    .setupLocation("Москва")
                                    .addProductInBasket(2)
                                    .getNumInBasket();
        assertThat(numOfAddedItems, is(equalTo(1)));

        numOfAddedItems = new ItemPage(driver)
                            .openPage()
                            .addToBasket();
        assertThat(numOfAddedItems, is(equalTo(2)));

    }
}
